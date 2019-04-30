package cn.bestick.easyexam.management.persistence;

import cn.bestick.easyexam.common.domain.exam.UserQuestionHistory;
import cn.bestick.easyexam.common.domain.question.QuestionStatistic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 17:51
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Repository
public interface QuestionHistoryMapper {

    /**
     * 插入试题历史
     *
     * @param historyList
     */
    void addUserQuestionHist(@Param("array") List<UserQuestionHistory> historyList);

    /**
     * 获取用户的试题练习历史
     *
     * @param userId
     * @param fieldId
     * @return
     */
    List<UserQuestionHistory> getUserQuestionHist(@Param("userId") int userId, @Param("fieldId") int fieldId);

    /**
     * 根据fieldId,pointId分组统计练习历史试题数量
     *
     * @param fieldId
     * @param userId
     * @return
     */
    List<QuestionStatistic> getQuestionHistStaticByFieldId(@Param("fieldId") int fieldId, @Param("userId") int userId);

    /**
     * 根据fieldId,pointId,typeId分组统计练习历史试题数量
     *
     * @param fieldId
     * @param userId
     * @return
     */
    List<QuestionStatistic> getTypeQuestionHistStaticByFieldId(@Param("fieldId") int fieldId, @Param("userId") int userId);
}
