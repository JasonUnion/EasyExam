package cn.bestick.easyexam.management.service;

import cn.bestick.easyexam.common.domain.exam.UserQuestionHistory;
import cn.bestick.easyexam.common.domain.question.QuestionStatistic;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:39
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public interface QuestionHistoryService {

    /**
     * 插入试题历史
     *
     * @param historyList
     */
    void addUserQuestionHist(List<UserQuestionHistory> historyList);

    /**
     * 插入试题历史
     *
     * @param history
     */
    void addUserQuestionHist(UserQuestionHistory... history);

    /**
     * 获取用户的试题练习历史
     *
     * @param userId
     * @param fieldId
     * @return Map<知识点,List<UserQuestionHistory>>
     */
    Map<Integer, List<UserQuestionHistory>> getUserQuestionHist(int userId, int fieldId);

    /**
     * 根据fieldId,pointId分组统计练习历史试题数量
     *
     * @param fieldId
     * @param userId
     * @return
     */
    Map<Integer, QuestionStatistic> getQuestionHistStaticByFieldId(int fieldId, int userId);

    /**
     * 根据fieldId,pointId,typeId分组统计练习历史试题数量
     *
     * @param fieldId
     * @param userId
     * @return
     */
    Map<Integer, Map<Integer, QuestionStatistic>> getTypeQuestionHistStaticByFieldId(int fieldId, int userId);
}