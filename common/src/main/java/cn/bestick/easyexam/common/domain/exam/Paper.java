package cn.bestick.easyexam.common.domain.exam;

import cn.bestick.easyexam.common.domain.question.QuestionStruts;
import cn.bestick.easyexam.common.util.Roulette;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/27/16
 * Time: 16:23
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class Paper {

    public static Log log = LogFactory.getLog(Paper.class);

    /**
     * 试卷试题列表
     */
    private HashMap<Integer, QuestionStruts> paperQuestionMap = new HashMap<>();

    /**
     * 适应度
     */
    private float fitness;

    /**
     * 曝光度
     */
    private double exposure;

    /**
     * 难度系数
     */
    private float difficulty;

    /**
     * 期望难度系数
     */
    private float eDifficulty = 0.2f;

    /**
     * 每种题型的数量
     */
    private HashMap<Integer, Integer> questionTypeNum;

    /**
     * 每种题型的分数
     */
    private HashMap<Integer, Float> questionTypePoint;

    /**
     * 知识点字典
     */
    private HashMap<Integer, String> knowledgeMap;

    /**
     * 试题类型字典
     */
    private HashMap<Integer, String> typeMap;

    /**
     * 知识点概率分布
     */
    private HashMap<Integer, Float> knowledgePointRate;

    /**
     * 题目总数，通过questionTypeNum计算
     */
    private int questionNum = 0;

    /**
     * 涵盖的知识点，越多越好，暂时不使用
     */
    // private HashMap<Integer,Float> knowledgeNum;

    /**
     * 试题库
     */
    private HashMap<Integer, HashMap<Integer, List<QuestionStruts>>> questionMap;

    public HashMap<Integer, QuestionStruts> getPaperQuestionMap() {
        return paperQuestionMap;
    }

    public Paper(
            HashMap<Integer, HashMap<Integer, List<QuestionStruts>>> questionMap,
            HashMap<Integer, Integer> questionTypeNum,
            HashMap<Integer, Float> questionTypePoint,
            HashMap<Integer, Float> knowledgePointRate,
            HashMap<Integer, String> knowledgeMap,
            HashMap<Integer, String> typeMap
    ) {

        this.questionMap = questionMap;
        this.questionTypeNum = questionTypeNum;
        this.questionTypePoint = questionTypePoint;
        this.knowledgePointRate = knowledgePointRate;
        this.knowledgeMap = knowledgeMap;
        this.typeMap = typeMap;
    }

    /**
     * 创建试卷
     *
     * @throws Exception
     */
    public void createPaper() throws Exception {

        // 保存数据库中读取的每种题型的数量
        HashMap<Integer, Integer> questionTypeNumCheck = new HashMap<>();
        Iterator<Integer> iterator1 = questionMap.keySet().iterator();

        // 遍历每一种知识点
        while (iterator1.hasNext()) {
            int key = iterator1.next();
            Iterator<Integer> iterator2 = questionMap.get(key).keySet()
                    .iterator();
            // 遍历知识点下每一种题型
            while (iterator2.hasNext()) {
                // 题型ID
                int typeNum = (Integer) iterator2.next();
                // 如果题型校验Map包含这个题型ID
                if (questionTypeNumCheck.containsKey(typeNum))
                    questionTypeNumCheck.put(typeNum,
                            questionTypeNumCheck.get(typeNum)
                                    + questionMap.get(key).get(typeNum).size());
                else
                    questionTypeNumCheck.put(typeNum,
                            questionMap.get(key).get(typeNum).size());
            }
        }

        Iterator<Integer> iterator3 = questionTypeNum.keySet().iterator();
        while (iterator3.hasNext()) {
            int key = iterator3.next();
            if (!questionTypeNumCheck.containsKey(key))
                throw new Exception("试题清单中无试题类型" + typeMap.get(key));
            if (questionTypeNum.get(key) > questionTypeNumCheck.get(key))
                throw new Exception("试题库中试题类型：" + typeMap.get(key) + "数量不足");
        }

        this.paperQuestionMap = new HashMap<>();

        // 设置知识点的概率，默认平均
        List<Integer> resultList = new ArrayList<>();

        HashMap<Integer, Float> hm = new HashMap<>();

        float sum = 0f;
        Iterator<Integer> itrate;
        if (knowledgePointRate != null) {
            itrate = knowledgePointRate.keySet().iterator();
            while (itrate.hasNext()) {
                sum = sum + knowledgePointRate.get(itrate.next());
            }
        }

        // 如果没有提供知识点概率，或者概率相加不等于1，则按平均概率计算
        if (knowledgePointRate == null || sum != 1) {
            Iterator<Integer> it = questionMap.keySet().iterator();
            int count = 0;
            while (it.hasNext()) {
                int key = it.next();
                resultList.add(key);
                hm.put(count, 0f);
                count++;
            }
            it = questionMap.keySet().iterator();

            float avg = (float) (Math.round((1f / (float) count) * 1000)) / 1000;
            float dt = (float) (Math
                    .round(((1f - avg * (count - 1))) * 1000)) / 1000;

            log.info("dt = " + dt);
            log.info("avg = " + avg);
            for (int i = 0; i < count; i++) {
                if (i == count - 1)
                    hm.put(i, dt);
                else
                    hm.put(i, avg);
                log.info("知识点" + i + "的选择概率:" + hm.get(i));
            }
        } else {
            Iterator<Integer> itrate1 = knowledgePointRate.keySet().iterator();
            int count = 0;
            while (itrate1.hasNext()) {
                int key = itrate1.next();
                resultList.add(key);
                hm.put(count, knowledgePointRate.get(key));
                count++;
            }
        }

        // 轮盘赌选择知识点
        Roulette<Integer> r = new Roulette<>(resultList, hm);

        // 选择题型
        List<Integer> resultList1 = new ArrayList<>();
        Iterator<Integer> it1 = questionTypeNum.keySet().iterator();
        HashMap<Integer, Float> hm1 = new HashMap<>();

        int count1 = 0;

        while (it1.hasNext()) {
            int key = it1.next();
            resultList1.add(key);
            // 获取题型数量
            count1++;
            // 获取题量
            questionNum += questionTypeNum.get(key);
        }
        log.info("题型数量=" + count1);

        it1 = questionMap.keySet().iterator();

        // 每种题型的概率
        float avg1 = (float) (Math.round((1f / (float) count1) * 1000)) / 1000;
        // 所有题型的概率相加和1之间的差值加上平均值
        float dt1 = (float) (Math
                .round(((1f - avg1 * (count1 - 1))) * 1000)) / 1000;

        for (int i = 0; i < count1; i++) {
            // 最后一种题型概率加上差值
            if (i == count1 - 1)
                hm1.put(i, dt1);
            else
                hm1.put(i, avg1);
            log.info("题型" + i + "的选择概率:" + hm1.get(i));
        }
        // 轮盘赌选择题型
        Roulette<Integer> r1 = new Roulette<>(resultList1, hm1);

        // 如果没有选择足够的题量，循环选择试题
        while (questionNum > paperQuestionMap.size()) {
            int pointId;
            int typeId;
            try {
                pointId = r.getResult();
                typeId = r1.getResult();
                List<QuestionStruts> qs = questionMap.get(pointId).get(typeId);
                if (qs == null) {
                    log.info("pointId=" + pointId + "typeId=" + typeId);
                    log.info(questionMap.get(pointId));
                    continue;

                }

                Random random = new Random();
                int typeNum = questionTypeNum.get(typeId);
                if (typeNum > 0) {
                    QuestionStruts q = qs.get(random.nextInt(qs.size()));

                    if (paperQuestionMap.containsKey(q.getQuestionId()))
                        continue;
                    if (questionTypePoint != null) {
                        if (questionTypePoint.containsKey(typeId)) {
                            q.setPoint(questionTypePoint.get(typeId));
                        }
                    }
                    paperQuestionMap.put(q.getQuestionId(), q);
                    typeNum--;
                    questionTypeNum.put(typeId, typeNum);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * 适应度计算公式
     * 给定试卷难度系数和生成试卷难度系数差的绝对值越小越好
     * 曝光度越小越好
     * 涵盖的知识点越多越好
     */
    private void setFitness() {
        float difficultyMinus = Math.abs(this.difficulty - eDifficulty);
        log.info("eDifficulty=" + eDifficulty);
        this.fitness = (float) ((1 / difficultyMinus) * Math
                .sqrt(this.exposure));
    }

    public float getFitness() {
        return this.fitness;
    }

    /**
     * 初始化试卷
     */
    public void initPaper() {
        float pointLose = 0;
        float pointSum = 0;
        double exposureSum = 0;
        for (Integer key : paperQuestionMap.keySet()) {
            QuestionStruts q = paperQuestionMap.get(key);
            pointLose = (float) (pointLose + (q.getWrongTimes() / q
                    .getExposeTimes()) * q.getPoint());
            pointSum += q.getPoint();
            exposureSum += q.getExposeTimes();
        }
        this.difficulty = pointLose / pointSum;
        log.info("difficulty=" + this.difficulty);
        this.exposure = exposureSum;
        setFitness();
    }
}