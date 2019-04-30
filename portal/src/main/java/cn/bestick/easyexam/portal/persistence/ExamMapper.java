package cn.bestick.easyexam.portal.persistence;

import cn.bestick.easyexam.common.domain.exam.Exam;
import cn.bestick.easyexam.common.domain.exam.ExamHistory;
import cn.bestick.easyexam.common.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 00:07
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Repository
public interface ExamMapper {

    /**
     * 根据准考证号获取用户考试历史
     *
     * @param seriNo
     * @return
     */
    ExamHistory getUserExamHistBySeriNo(@Param("seriNo") String seriNo, @Param("approved") int approved);

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
     * 根据用户id查询考试历史
     *
     * @param userId
     * @param typeIdList
     * @param page
     * @return
     */
    List<ExamHistory> getUserExamHistByUserId(@Param("userId") int userId, @Param("array") int[] typeIdList, @Param("page") Page<ExamHistory> page);

    /**
     * 根据id获取考试
     *
     * @param examId
     * @return
     */
    Exam getExamById(int examId);

    /**
     * 考试历史表插入一条记录
     *
     * @param examHistory
     */
    void addUserExamHist(ExamHistory examHistory);

    /**
     * 根据考试历史id获取考试历史
     *
     * @param histId
     * @return
     */
    ExamHistory getUserExamHistListByHistId(int histId);

    /**
     * 获取可以申请的考试清单，供用户申请
     *
     * @param userId
     * @param page
     * @return
     */
    List<Exam> getExamListToApply(@Param("userId") int userId, @Param("page") Page<Exam> page);

    /**
     * 获取可以考试的清单，供用户考试
     *
     * @param userId
     * @param page
     * @param typeIdList 考试类型id
     * @return
     */
    List<Exam> getExamListToStart(@Param("userId") int userId, @Param("array") int[] typeIdList, @Param("page") Page<Exam> page);

    /**
     * 获取试卷清单
     *
     * @param idList 类型id
     * @param page
     * @return
     */
    List<Exam> getExamList(@Param("array") int[] idList, @Param("page") Page<Exam> page);
}
