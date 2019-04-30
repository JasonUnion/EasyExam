package cn.bestick.easyexam.common.domain.question;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/27/16
 * Time: 23:10
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class QuestionStruts {

    /**
     * 试题id
     */
    private int questionId;

    /**
     * 试题类型id
     */
    private int questionTypeId;

    /**
     * 曝光次数
     */
    private double exposeTimes;

    /**
     * 正确次数
     */
    private double rightTimes;

    /**
     * 错误次数
     */
    private double wrongTimes;

    /**
     * 难度
     */
    private float difficulty;

    /**
     * 分数id
     */
    private int pointId;

    /**
     * 关联id
     */
    private int referenceId;

    /**
     * 分数
     */
    private float point;

    /**
     * 关键词
     */
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public double getExposeTimes() {
        return exposeTimes;
    }

    public void setExposeTimes(double exposeTimes) {
        this.exposeTimes = exposeTimes;
    }

    public double getRightTimes() {
        return rightTimes;
    }

    public void setRightTimes(double rightTimes) {
        this.rightTimes = rightTimes;
    }

    public double getWrongTimes() {
        return wrongTimes;
    }

    public void setWrongTimes(double wrongTimes) {
        this.wrongTimes = wrongTimes;
    }

    public float getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(float difficulty) {
        this.difficulty = difficulty;
    }
}
