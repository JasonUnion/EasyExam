package cn.bestick.easyexam.management.persistence;

import cn.bestick.easyexam.common.domain.exam.AnswerSheet;
import cn.bestick.easyexam.common.domain.exam.Exam;
import cn.bestick.easyexam.common.domain.exam.ExamHistory;
import cn.bestick.easyexam.common.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 17:42
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Repository
public interface ExamMapper {

    /**
     * 添加考试
     *
     * @param exam
     */
    void addExam(Exam exam);

    /**
     * 考试历史表插入一条记录
     *
     * @param examHistory
     */
    void addUserExamHist(ExamHistory examHistory);

    /**
     * 获取试卷清单
     *
     * @param idList 类型id
     * @param page
     * @return
     */
    List<Exam> getExamList(@Param("array") int[] idList, @Param("page") Page<Exam> page);

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
    List<ExamHistory> getUserExamHistListByExamId(@Param("examId") int examId, @Param("searchStr") String searchStr, @Param("order") String order, @Param("limit") int limit, @Param("page") Page<ExamHistory> page);

    /**
     * 删除一门考试
     *
     * @param examId
     */
    void deleteExamById(int examId);

    /**
     * 根据id获取考试
     *
     * @param examId
     * @return
     */
    Exam getExamById(int examId);

    /**
     * 更新考试的审核状态
     *
     * @param approved
     */
    void changeExamStatus(@Param("examId") int examId, @Param("approved") int approved);

    /**
     * 审核用户考试申请
     *
     * @param histId
     * @param approved
     */
    void changeUserExamHistStatus(@Param("histId") int histId, @Param("approved") int approved);

    /**
     * 更新答题卡及得分
     *
     * @param answerSheet
     * @param answerSheetStr
     */
    void updateUserExamHist(@Param("answerSheet") AnswerSheet answerSheet, @Param("answerSheetStr") String answerSheetStr, @Param("approved") int approved);

    /**
     * 根据考试历史id获取考试历史
     *
     * @param histId
     * @return
     */
    ExamHistory getUserExamHistListByHistId(int histId);

    /**
     * 删除一条考试申请（历史记录），只能删除未审核的记录
     *
     * @param histId
     */
    void deleteUserExamHist(int histId);

    /**
     * 删除一条考试申请（历史记录），只能删除未审核的记录
     *
     * @param examId
     * @param userId
     */
    void deleteUserExamHistByUserId(@Param("examId") int examId, @Param("userId") int userId);

    /**
     * 根据用户id和考试id查询考试历史
     *
     * @param userId
     * @param examId
     * @param approvedType
     * @return
     */
    ExamHistory getUserExamHistByUserIdAndExamId(@Param("userId") int userId, @Param("examId") int examId, @Param("array") int[] approvedType);

    /**
     * 获取考试历史记录列表（所有）
     *
     * @param approvedType
     * @param page
     * @return
     */
    List<ExamHistory> getUserExamHistList(@Param("array") int[] approvedType, @Param("page") Page<ExamHistory> page);
}
