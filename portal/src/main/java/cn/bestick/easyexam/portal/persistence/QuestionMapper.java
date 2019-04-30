package cn.bestick.easyexam.portal.persistence;

import cn.bestick.easyexam.common.domain.question.*;
import cn.bestick.easyexam.common.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 00:10
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Repository
public interface QuestionMapper {

    List<QuestionType> getQuestionTypeList();

    Question getQuestionByQuestionId(@Param("questionId") int questionId);

    /**
     * 获取某一题型的试题
     *
     * @param QuestionTypeId
     * @param page
     * @return
     */
    List<Question> getQuestionByTypeId(@Param("QuestionTypeId") int QuestionTypeId,
                                              @Param("page") Page<Question> page);

    /**
     * 按知识点获取试题
     *
     * @param idList
     * @return
     */
    List<QuestionStruts> getQuestionListByPointId(@Param("array") List<Integer> idList);

    /**
     * 根据试题类型和知识点获取试题
     *
     * @param typeId
     * @param pointId
     * @return
     */
    List<QuestionQueryResult> getQuestionAnalysisListByPointIdAndTypeId(@Param("typeId") int typeId,
                                                                        @Param("pointId") int pointId);

    /**
     * 根据试题id获取试题清单
     *
     * @param idList
     * @return
     */
    List<QuestionQueryResult> getQuestionAnalysisListByIdList(@Param("array") List<Integer> idList);

    /**
     * 获取所有的Field
     *
     * @param page
     * @return
     */
    List<Field> getAllField(@Param("page") Page<Field> page);

    /**
     * 获取Field下的知识点
     *
     * @param fieldIdList 为null则获取所有知识点
     * @param page
     * @return
     */
    List<KnowledgePoint> getKnowledgePointByFieldId(@Param("array") int[] fieldIdList,
                                                           @Param("page") Page<KnowledgePoint> page);

    /**
     * 按专业获取试题
     *
     * @param fieldId
     * @param page
     * @return
     */
    List<QuestionQueryResult> getQuestionListByFieldId(@Param("fieldId") int fieldId,
                                                              @Param("page") Page<QuestionQueryResult> page);

    /**
     * 根据fieldId,pointId分组统计试题数量
     *
     * @param fieldId
     * @return
     */
    List<QuestionStatistic> getQuestionStaticByFieldId(int fieldId);

    /**
     * 根据fieldId,pointId,typeId分组统计试题数量
     *
     * @param fieldId
     * @return
     */
    List<QuestionStatistic> getTypeQuestionStaticByFieldId(int fieldId);
}
