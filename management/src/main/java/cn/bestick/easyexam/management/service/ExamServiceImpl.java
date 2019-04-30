package cn.bestick.easyexam.management.service;

import cn.bestick.easyexam.common.domain.exam.AnswerSheet;
import cn.bestick.easyexam.common.domain.exam.Exam;
import cn.bestick.easyexam.common.domain.exam.ExamHistory;
import cn.bestick.easyexam.common.domain.exam.ExamPaper;
import cn.bestick.easyexam.common.domain.user.Role;
import cn.bestick.easyexam.common.domain.user.User;
import cn.bestick.easyexam.common.util.Page;
import cn.bestick.easyexam.common.util.StringUtil;
import cn.bestick.easyexam.management.persistence.ExamMapper;
import cn.bestick.easyexam.management.persistence.ExamPaperMapper;
import cn.bestick.easyexam.management.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:34
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Service("examService")
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ExamPaperMapper examPaperMapper;

    @Transactional
    @Override
    public void addExam(Exam exam) {
        try {
            examMapper.addExam(exam);
            if (exam.getGroupIdList() != null && exam.getGroupIdList().size() > 0) {
                List<User> userList = userMapper.getUserListByGroupIdList(exam.getGroupIdList(), null);
                ExamPaper examPaper = examPaperMapper.getExamPaperById(exam.getExamPaperId());
                SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
                Date now = new Date();
                for (User user : userList) {
                    ExamHistory history = new ExamHistory();
                    history.setExamId(exam.getExamId());
                    history.setExamPaperId(exam.getExamPaperId());
                    history.setContent(examPaper.getContent());
                    history.setDuration(examPaper.getDuration());
                    //默认创建的记录都是审核通过的
                    history.setApproved(1);
                    //TO-DO:用户名,密码,开始时间,结束时间 进行md5
                    String seriNo = sdf.format(now) + StringUtil.format(user.getUserId(), 3) + StringUtil.format(exam.getExamId(), 3);
                    history.setSeriNo(seriNo);
                    history.setVerifyTime(new Date());
                    history.setUserId(user.getUserId());
                    examMapper.addUserExamHist(history);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public void addExamUser(int examId, String userNameStr, HashMap<String, Role> roleMap) {

        try {
            String[] userNames = userNameStr.split(";");
            List<User> userList = userMapper.getUserByNames(userNames, roleMap.get("ROLE_STUDENT").getRoleId());
            Exam exam = examMapper.getExamById(examId);
            ExamPaper examPaper = examPaperMapper.getExamPaperById(exam.getExamPaperId());
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
            Date now = new Date();
            for (User user : userList) {
                ExamHistory history = this.getUserExamHistByUserIdAndExamId(user.getUserId(), examId, 0, 1, 2, 3);
                if (history == null) {
                    history = new ExamHistory();
                    history.setExamId(exam.getExamId());
                    history.setExamPaperId(exam.getExamPaperId());
                    history.setContent(examPaper.getContent());
                    history.setDuration(examPaper.getDuration());
                    //默认创建的记录都是审核通过的
                    history.setApproved(1);
                    String seriNo = sdf.format(now) + StringUtil.format(user.getUserId(), 3) + StringUtil.format(exam.getExamId(), 3);
                    history.setSeriNo(seriNo);
                    history.setVerifyTime(new Date());
                    history.setUserId(user.getUserId());
                    examMapper.addUserExamHist(history);
                } else if (history.getApproved() == 0) {
                    //审核状态是0的才允许重新添加
                    examMapper.deleteUserExamHistByUserId(exam.getExamId(), user.getUserId());
                    //批量添加的都是审核通过的记录
                    history.setApproved(1);
                    examMapper.addUserExamHist(history);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Exam> getExamList(Page<Exam> page, int... typeIdList) {
        if (typeIdList.length == 0)
            typeIdList = null;
        return examMapper.getExamList(typeIdList, page);
    }

    @Override
    public List<ExamHistory> getUserExamHistListByExamId(int examId, String searchStr, String order, int limit, Page<ExamHistory> page) {
        return examMapper.getUserExamHistListByExamId(examId, searchStr, order, limit, page);
    }

    @Override
    public void deleteExamById(int examId) throws Exception {
        Exam exam = examMapper.getExamById(examId);
        if (exam.getApproved() == 0 || exam.getApproved() == 2)
            examMapper.deleteExamById(examId);
        else
            throw new Exception("考试已经审核通过！不允许删除！");
    }

    @Override
    public void changeExamStatus(int examId, int approved) {
        examMapper.changeExamStatus(examId, approved);
    }

    @Override
    public void changeUserExamHistStatus(int histId, int approved) {
        examMapper.changeUserExamHistStatus(histId, approved);
    }

    @Override
    public void updateUserExamHist(AnswerSheet answerSheet, String answerSheetStr, int approved) {
        examMapper.updateUserExamHist(answerSheet, answerSheetStr, approved);
    }

    @Override
    public ExamHistory getUserExamHistListByHistId(int histId) {
        return examMapper.getUserExamHistListByHistId(histId);
    }

    @Override
    public void deleteUserExamHist(int histId) {
        examMapper.deleteUserExamHist(histId);
    }

    @Override
    public Exam getExamById(int examId) {
        return examMapper.getExamById(examId);
    }

    @Override
    public ExamHistory getUserExamHistByUserIdAndExamId(int userId, int examId, int... approved) {
        if (approved.length == 0)
            approved = null;
        return examMapper.getUserExamHistByUserIdAndExamId(userId, examId, approved);
    }

    @Transactional
    @Override
    public void addGroupUser2Exam(List<Integer> groupIdList, int examId) {
        try {
            Exam exam = examMapper.getExamById(examId);
            ExamPaper examPaper = examPaperMapper.getExamPaperById(exam.getExamPaperId());
            List<User> userList = userMapper.getUserListByGroupIdList(groupIdList, null);
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
            Date now = new Date();
            for (User user : userList) {
                ExamHistory history = this.getUserExamHistByUserIdAndExamId(user.getUserId(), examId, 0, 1, 2, 3);
                if (history == null) {
                    history = new ExamHistory();
                    history.setExamId(exam.getExamId());
                    history.setExamPaperId(exam.getExamPaperId());
                    history.setContent(examPaper.getContent());
                    history.setDuration(examPaper.getDuration());
                    //默认创建的记录都是审核通过的
                    history.setApproved(1);
                    String seriNo = sdf.format(now) + StringUtil.format(user.getUserId(), 3) + StringUtil.format(exam.getExamId(), 3);
                    history.setSeriNo(seriNo);
                    history.setVerifyTime(new Date());
                    history.setUserId(user.getUserId());
                    examMapper.addUserExamHist(history);
                } else if (history.getApproved() == 0) {
                    //审核状态是0的才允许重新添加
                    examMapper.deleteUserExamHistByUserId(exam.getExamId(), user.getUserId());
                    //批量添加的都是审核通过的记录
                    history.setApproved(1);
                    examMapper.addUserExamHist(history);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ExamHistory> getUserExamHistList(Page<ExamHistory> page, int... approved) {
        if (approved.length == 0)
            approved = null;
        return examMapper.getUserExamHistList(approved, page);
    }
}