package cn.bestick.easyexam.common.domain.question;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/28/16
 * Time: 22:55
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class QuestionImproveResult {

    private int questionPointId;
    private String questionPointName;
    private int questionTypeId;
    private String questionTypeName;
    private int amount;
    private int rightTimes;
    private int wrongTimes;

    public int getRightTimes() {
        return rightTimes;
    }

    public void setRightTimes(int rightTimes) {
        this.rightTimes = rightTimes;
    }

    public int getWrongTimes() {
        return wrongTimes;
    }

    public void setWrongTimes(int wrongTimes) {
        this.wrongTimes = wrongTimes;
    }

    public int getQuestionPointId() {
        return questionPointId;
    }

    public void setQuestionPointId(int questionPointId) {
        this.questionPointId = questionPointId;
    }

    public String getQuestionPointName() {
        return questionPointName;
    }

    public void setQuestionPointName(String questionPointName) {
        this.questionPointName = questionPointName;
    }

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
