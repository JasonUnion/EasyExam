package cn.bestick.easyexam.portal.service;

import cn.bestick.easyexam.common.domain.question.*;
import cn.bestick.easyexam.common.util.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 10:40
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public interface QuestionService {

    Map<Integer, QuestionType> getQuestionTypeMap();

    Question getQuestionByQuestionId(int questionId);

    List<QuestionQueryResult> getQuestionAnalysisListByPointIdAndTypeId(
            int typeId, int pointId);

    /**
     * 获取所有的Field
     *
     * @param page
     * @return
     */
    List<Field> getAllField(Page<Field> page);

    /**
     * 获取Field下的知识点
     *
     * @param fieldIdList 为null则获取所有知识点
     * @param page
     * @return
     */
    Map<Integer, KnowledgePoint> getKnowledgePointByFieldId(Page<KnowledgePoint> page, int... fieldIdList);

    /**
     * 按专业获取试题
     *
     * @param fieldId
     * @param page
     * @return
     */
    Map<Integer, Map<Integer, List<QuestionQueryResult>>> getQuestionMapByFieldId(int fieldId, Page<QuestionQueryResult> page);

    /**
     * 根据试题id获取试题清单
     *
     * @param idList
     * @return
     */
    List<QuestionQueryResult> getQuestionAnalysisListByIdList(List<Integer> idList);

    /**
     * 根据fieldId,pointId分组统计试题数量
     *
     * @param fieldId
     * @return
     */
    Map<Integer, QuestionStatistic> getQuestionStaticByFieldId(int fieldId);

    /**
     * 根据fieldId,pointId,typeId分组统计试题数量
     *
     * @param fieldId
     * @return
     */
    Map<Integer, Map<Integer, QuestionStatistic>> getTypeQuestionStaticByFieldId(int fieldId);
}
