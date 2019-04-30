package cn.bestick.easyexam.common.domain.practice;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/28/16
 * Time: 22:39
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class TypeAnalysis {

    private int questionTypeId;
    private String questionTypeName;
    private int restAmount;
    private int rightAmount;
    private int wrongAmount;

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    public int getRestAmount() {
        return restAmount;
    }

    public void setRestAmount(int restAmount) {
        this.restAmount = restAmount;
    }

    public int getRightAmount() {
        return rightAmount;
    }

    public void setRightAmount(int rightAmount) {
        this.rightAmount = rightAmount;
    }

    public int getWrongAmount() {
        return wrongAmount;
    }

    public void setWrongAmount(int wrongAmount) {
        this.wrongAmount = wrongAmount;
    }
}
