package cn.bestick.easyexam.portal.service;

import cn.bestick.easyexam.common.domain.exam.UserQuestionHistory;
import cn.bestick.easyexam.common.domain.question.QuestionStatistic;
import cn.bestick.easyexam.portal.persistence.QuestionHistoryMapper;
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
 * Time: 10:38
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Service("questionHistoryService")
public class QuestionHistoryServiceImpl implements QuestionHistoryService {

    @Autowired
    private QuestionHistoryMapper questionHistoryMapper;

    @Override
    public void addUserQuestionHist(List<UserQuestionHistory> historyList) {
        questionHistoryMapper.addUserQuestionHist(historyList);
    }

    @Override
    public void addUserQuestionHist(UserQuestionHistory... history) {

        List<UserQuestionHistory> historyList = new ArrayList<UserQuestionHistory>();
        for (UserQuestionHistory h : history) {
            historyList.add(h);
        }
        questionHistoryMapper.addUserQuestionHist(historyList);
    }

    @Override
    public Map<Integer, List<UserQuestionHistory>> getUserQuestionHist(int userId, int fieldId) {

        List<UserQuestionHistory> histList = questionHistoryMapper.getUserQuestionHist(userId, fieldId);
        Map<Integer, List<UserQuestionHistory>> map = new HashMap<Integer, List<UserQuestionHistory>>();
        for (UserQuestionHistory hist : histList) {
            List<UserQuestionHistory> result = map.get(hist.getPointId());
            if (result == null)
                result = new ArrayList<UserQuestionHistory>();

            result.add(hist);
            map.put(hist.getPointId(), result);
        }
        return map;
    }

    @Override
    public Map<Integer, QuestionStatistic> getQuestionHistStaticByFieldId(int fieldId, int userId) {

        List<QuestionStatistic> statisticList = questionHistoryMapper.getQuestionHistStaticByFieldId(fieldId, userId);
        Map<Integer, QuestionStatistic> map = new HashMap<Integer, QuestionStatistic>();
        for (QuestionStatistic statistic : statisticList) {
            map.put(statistic.getPointId(), statistic);
        }

        return map;
    }

    @Override
    public Map<Integer, Map<Integer, QuestionStatistic>> getTypeQuestionHistStaticByFieldId(int fieldId, int userId) {

        List<QuestionStatistic> statisticList = questionHistoryMapper.getTypeQuestionHistStaticByFieldId(fieldId, userId);
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
