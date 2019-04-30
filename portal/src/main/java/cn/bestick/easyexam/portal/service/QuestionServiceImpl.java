package cn.bestick.easyexam.portal.service;

import cn.bestick.easyexam.common.domain.question.*;
import cn.bestick.easyexam.common.util.Page;
import cn.bestick.easyexam.portal.persistence.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 10:41
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public Map<Integer, QuestionType> getQuestionTypeMap() {

        Map<Integer, QuestionType> map = new HashMap<Integer, QuestionType>();
        List<QuestionType> typeList = questionMapper.getQuestionTypeList();
        for (QuestionType type : typeList)
            map.put(type.getId(), type);
        return map;
    }

    @Override
    public Question getQuestionByQuestionId(int questionId) {
        return questionMapper.getQuestionByQuestionId(questionId);
    }

    @Override
    public List<QuestionQueryResult> getQuestionAnalysisListByPointIdAndTypeId(int typeId, int pointId) {
        return questionMapper.getQuestionAnalysisListByPointIdAndTypeId(typeId, pointId);
    }

    @Override
    public List<Field> getAllField(Page<Field> page) {
        return questionMapper.getAllField(page);
    }

    @Override
    public Map<Integer, KnowledgePoint> getKnowledgePointByFieldId(Page<KnowledgePoint> page, int... fieldIdList) {

        Map<Integer, KnowledgePoint> map = new HashMap<Integer, KnowledgePoint>();

        if (fieldIdList != null && fieldIdList.length == 0)
            fieldIdList = null;
        List<KnowledgePoint> pointList = questionMapper.getKnowledgePointByFieldId(fieldIdList, page);
        for (KnowledgePoint point : pointList)
            map.put(point.getPointId(), point);
        return map;
    }

    @Override
    public Map<Integer, Map<Integer, List<QuestionQueryResult>>> getQuestionMapByFieldId(int fieldId, Page<QuestionQueryResult> page) {

        List<QuestionQueryResult> questionList = questionMapper.getQuestionListByFieldId(fieldId, page);
        Map<Integer, Map<Integer, List<QuestionQueryResult>>> map = new HashMap<Integer, Map<Integer, List<QuestionQueryResult>>>();
        for (QuestionQueryResult result : questionList) {
            Map<Integer, List<QuestionQueryResult>> tmpMap = map.get(result.getKnowledgePointId());
            if (tmpMap == null)
                tmpMap = new HashMap<Integer, List<QuestionQueryResult>>();
            List<QuestionQueryResult> tmpList = tmpMap.get(result.getQuestionTypeId());
            if (tmpList == null)
                tmpList = new ArrayList<QuestionQueryResult>();
            tmpList.add(result);
            tmpMap.put(result.getQuestionTypeId(), tmpList);
            map.put(result.getKnowledgePointId(), tmpMap);
        }
        return map;
    }

    @Override
    public List<QuestionQueryResult> getQuestionAnalysisListByIdList(List<Integer> idList) {

        return questionMapper.getQuestionAnalysisListByIdList(idList);
    }

    @Override
    public Map<Integer, QuestionStatistic> getQuestionStaticByFieldId(int fieldId) {

        List<QuestionStatistic> statisticList = questionMapper.getQuestionStaticByFieldId(fieldId);
        Map<Integer, QuestionStatistic> map = new HashMap<Integer, QuestionStatistic>();
        for (QuestionStatistic statistic : statisticList) {
            map.put(statistic.getPointId(), statistic);
        }

        return map;
    }

    @Override
    public Map<Integer, Map<Integer, QuestionStatistic>> getTypeQuestionStaticByFieldId(int fieldId) {

        List<QuestionStatistic> statisticList = questionMapper.getTypeQuestionStaticByFieldId(fieldId);
        Map<Integer, Map<Integer, QuestionStatistic>> map = new HashMap<Integer, Map<Integer, QuestionStatistic>>();
        for (QuestionStatistic statistic : statisticList) {
            Map<Integer, QuestionStatistic> tmp = map.get(statistic.getPointId());
            if (tmp == null) {
                tmp = new HashMap<Integer, QuestionStatistic>();
            }
            tmp.put(statistic.getQuestionTypeId(), statistic);
            map.put(statistic.getPointId(), tmp);
        }
        return map;
    }
}
