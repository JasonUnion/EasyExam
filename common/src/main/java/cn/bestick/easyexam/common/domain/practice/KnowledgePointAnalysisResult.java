package cn.bestick.easyexam.common.domain.practice;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/28/16
 * Time: 22:36
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class KnowledgePointAnalysisResult {

    private int knowledgePointId;
    private String knowledgePointName;
    private List<TypeAnalysis> typeAnalysis;
    private float finishRate;

    public int getKnowledgePointId() {
        return knowledgePointId;
    }

    public void setKnowledgePointId(int knowledgePointId) {
        this.knowledgePointId = knowledgePointId;
    }

    public String getKnowledgePointName() {
        return knowledgePointName;
    }

    public void setKnowledgePointName(String knowledgePointName) {
        this.knowledgePointName = knowledgePointName;
    }

    public List<TypeAnalysis> getTypeAnalysis() {
        return typeAnalysis;
    }

    public void setTypeAnalysis(List<TypeAnalysis> typeAnalysis) {
        this.typeAnalysis = typeAnalysis;
    }

    public float getFinishRate() {
        return finishRate;
    }

    public void setFinishRate(float finishRate) {
        this.finishRate = finishRate;
    }
}
