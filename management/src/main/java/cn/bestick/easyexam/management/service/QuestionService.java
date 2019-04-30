package cn.bestick.easyexam.management.service;

import cn.bestick.easyexam.common.domain.question.*;
import cn.bestick.easyexam.common.util.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:26
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public interface QuestionService {

    List<Question> getQuestionList(Page<Question> pageModel, QuestionFilter qf);

    List<Field> getAllField(Page<Field> page);

    List<KnowledgePoint> getKnowledgePointByFieldId(int FieldId, Page<KnowledgePoint> page);

    Map<String, KnowledgePoint> getKnowledgePointMapByFieldId(int fieldId, Page<KnowledgePoint> page);

    List<QuestionType> getQuestionTypeList();

    /**
     * @param page
     * @return
     */
    List<Tag> getTags(Page<Tag> page);

    /**
     * 增加一个标签
     *
     * @param tag
     */
    void addTag(Tag tag);

    /**
     * 添加试题，同时添加试题知识点对应关系
     *
     * @param question
     */
    void addQuestion(Question question);

    /**
     * 添加题库
     *
     * @param field
     */
    void addField(Field field);

    /**
     * 添加知识点
     *
     * @param point
     */
    void addKnowledgePoint(KnowledgePoint point);

    /**
     * 获取试题的tag，只包含公有tag和自己的私有tag
     *
     * @param questionId
     * @param userId
     * @param page
     * @return
     */
    List<QuestionTag> getQuestionTagByQuestionIdAndUserId(int questionId, int userId, Page<QuestionTag> page);

    /**
     * 给题目打标签
     *
     * @param questionId
     * @param userId
     */
    void addQuestionTag(int questionId, int userId, List<QuestionTag> questionTagList);

    /**
     * 重载，整合了tag的功能
     *
     * @param question
     * @param userId
     * @param questionTagList
     */
    void updateQuestionPoint(Question question, int userId, List<QuestionTag> questionTagList);

    /**
     * 删除专业
     *
     * @param idList
     */
    void deleteFieldByIdList(List<Integer> idList);

    /**
     * 删除知识分类
     *
     * @param idList
     */
    void deleteKnowledgePointByIdList(List<Integer> idList);

    /**
     * 删除一个标签
     *
     * @param idList
     */
    void deleteTagByIdList(List<Integer> idList);

    Question getQuestionByQuestionId(int questionId);

    List<QuestionQueryResult> getQuestionDescribeListByIdList(List<Integer> idList);

    void deleteQuestionByQuestionId(int questionId);

    HashMap<Integer, HashMap<Integer, List<QuestionStruts>>> getQuestionStrutsMap(List<Integer> idList);

    /**
     * 导入试题
     *
     * @param filePath
     * @param username
     * @param fieldId
     */
    void uploadQuestions(String filePath, String username, int fieldId);

    /**
     * 根据fieldId,pointId,typeId分组统计试题数量
     *
     * @param fieldId
     * @return
     */
    Map<Integer, Map<Integer, QuestionStatistic>> getTypeQuestionStaticByFieldId(int fieldId);

    /**
     * 获取知识点字典
     *
     * @param fieldId
     * @return
     */
    Map<Integer, String> getKnowledgePointMap(int fieldId);

    /**
     * 获取试题类型字典
     *
     * @return
     */
    Map<Integer, String> getQuestionTypeMap();

    /**
     * 更新试题
     *
     * @param question
     * @param questionTagList
     */
    void updateQuestion(Question question, List<QuestionTag> questionTagList);

    /**
     * 获取试题信息（详细）
     *
     * @param questionId
     */
    Question getQuestionDetail(int questionId, int userId);

    /**
     * 获取知识点统计信息
     *
     * @param fieldId
     * @return
     */
    List<PointStatistic> getPointCount(int fieldId, Page<PointStatistic> page);
}
