package cn.bestick.easyexam.management.service;

import cn.bestick.easyexam.common.domain.exam.AnswerSheet;
import cn.bestick.easyexam.common.domain.exam.Exam;
import cn.bestick.easyexam.common.domain.exam.ExamHistory;
import cn.bestick.easyexam.common.domain.user.Role;
import cn.bestick.easyexam.common.util.Page;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:32
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public interface ExamService {

    /**
     * 插入一个考试，如果考试目标分组已经确定，则同时给每个学员插入历史记录
     *
     * @param exam
     */
    void addExam(Exam exam);

    /**
     * 往考试中添加用户
     *
     * @param examId
     * @param userNameStr
     * @param roleMap
     */
    void addExamUser(int examId, String userNameStr, HashMap<String, Role> roleMap);

    /**
     * 获取考试清单
     *
     * @param page
     * @param typeIdList 考试类型
     * @return
     */
    List<Exam> getExamList(Page<Exam> page, int... typeIdList);

    /**
     * 根据考试id获取考试历史记录
     *
     * @param examId
     * @param searchStr
     * @param order
     * @param limit
     * @param page
     * @return
     */
    List<ExamHistory> getUserExamHistListByExamId(int examId, String searchStr, String order, int limit, Page<ExamHistory> page);

    /**
     * 删除一门考试
     *
     * @param examId
     */
    void deleteExamById(int examId) throws Exception;

    /**
     * 更新考试的审核状态
     *
     * @param examId
     * @param approved
     */
    void changeExamStatus(int examId, int approved);

    /**
     * 审核用户考试申请
     *
     * @param histId
     * @param approved
     */
    void changeUserExamHistStatus(int histId, int approved);

    /**
     * 更新答题卡及得分
     *
     * @param answerSheet
     * @param answerSheetStr
     */
    void updateUserExamHist(AnswerSheet answerSheet, String answerSheetStr, int approved);

    /**
     * 根据考试历史id获取考试历史
     *
     * @param histId
     * @return
     */
    ExamHistory getUserExamHistListByHistId(int histId);

    /**
     * 根据用户id和考试id查询考试历史
     *
     * @param userId
     * @param examId
     * @return
     */
    ExamHistory getUserExamHistByUserIdAndExamId(int userId, int examId, int... approved);

    /**
     * 删除一条考试申请（历史记录），只能删除未审核的记录
     *
     * @param histId
     */
    void deleteUserExamHist(int histId);

    /**
     * 根据id获取exam
     *
     * @param examId
     * @return
     */
    Exam getExamById(int examId);

    /**
     * 将用户组中的用户添加到考试中
     *
     * @param groupIdList
     * @param examId
     */
    void addGroupUser2Exam(List<Integer> groupIdList, int examId);

    /**
     * 获取用户考试历史列表（所有）
     *
     * @param page
     * @param approved
     * @return
     */
    List<ExamHistory> getUserExamHistList(Page<ExamHistory> page, int... approved);
}