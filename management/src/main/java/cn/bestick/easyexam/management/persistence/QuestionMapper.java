package cn.bestick.easyexam.management.persistence;

import cn.bestick.easyexam.common.domain.question.*;
import cn.bestick.easyexam.common.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 17:52
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Repository
public interface QuestionMapper {

    List<Question> getQuestionList(
            @Param("filter") QuestionFilter filter,
            @Param("page") Page<Question> page);

    List<Field> getAllField(@Param("page") Page<Field> page);

    List<KnowledgePoint> getKnowledgePointByFieldId(
            @Param("fieldId") int fieldId,
            @Param("page") Page<KnowledgePoint> page);

    List<QuestionType> getQuestionTypeList();

    /**
     * 获取tag列表，包含所有公有的或者自己私有的
     *
     * @param userId
     * @param page
     * @return
     */
    List<Tag> getTagByUserId(@Param("userId") int userId,
                                    @Param("page") Page<Tag> page);

    /**
     * 获取所有标签（管理员使用）
     *
     * @return
     */
    List<Tag> getTags(@Param("page") Page<Tag> page);

    /**
     * 增加一个标签
     *
     * @param tag
     */
    void addTag(Tag tag);

    void insertQuestion(Question question) throws Exception;

    void addQuestionKnowledgePoint(@Param("questionId") int questionId,
                                          @Param("pointId") int pointId) throws Exception;

    void addField(Field field);

    void addKnowledgePoint(KnowledgePoint point);

    /**
     * 获取试题的tag
     *
     * @param questionId
     * @param userId
     * @param page
     * @return
     */
    List<QuestionTag> getQuestionTagByQuestionIdAndUserId(
            @Param("questionId") int questionId, @Param("userId") int userId,
            @Param("page") Page<QuestionTag> page);

    /**
     * 给题目打标签
     */
    void addQuestionTag(@Param("array") List<QuestionTag> array);

    void deleteQuestionTag(@Param("questionId") int questionId, @Param("userId") int userId, @Param("array") List<Integer> array);

    void deleteQuestionPointByQuestionId(
            @Param("questionId") int questionId) throws Exception;

    void deleteFieldByIdList(@Param("array") List<Integer> idList);

    void deleteKnowledgePointByIdList(@Param("array") List<Integer> idList);

    void deleteTagByIdList(@Param("array") List<Integer> idList);

    Question getQuestionByQuestionId(@Param("questionId") int questionId);

    List<QuestionQueryResult> getQuestionAnalysisListByIdList(
            @Param("array") List<Integer> idList);

    void deleteQuestionByQuestionId(@Param("questionId") int questionId);

    /**
     * 获取某一题型的试题
     *
     * @param QuestionTypeId
     * @param page
     * @return
     */
    List<Question> getQuestionByTypeId(@Param("QuestionTypeId") int QuestionTypeId, @Param("page") Page<Question> page);

    /**
     * 按知识点获取试题
     *
     * @param idList
     * @return
     */
    List<QuestionStruts> getQuestionListByPointId(@Param("array") List<Integer> idList);

    /**
     * 根据fieldId,pointId,typeId分组统计试题数量
     *
     * @param fieldId
     * @return
     */
    List<QuestionStatistic> getTypeQuestionStaticByFieldId(int fieldId);

    /**
     * 更新一道试题
     *
     * @param question Object为null，int＝0则不更新
     */
    void updateQuestion(Question question);

    /**
     * 获取试题的知识点
     *
     * @param questionId
     */
    List<KnowledgePoint> getQuestionPoint(int questionId);

    /**
     * 获取试题标签
     *
     * @param questionId
     * @return
     */
    List<Tag> getQuestionTags(int questionId);

    /**
     * 获取知识点统计信息
     *
     * @param fieldId
     * @return
     */
    List<PointStatistic> getPointCount(@Param("fieldId") int fieldId, @Param("page") Page<PointStatistic> page);
}
