package cn.bestick.easyexam.common.domain.exam;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/26
 * Time: 23:11
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class AnswerSheetItem {

    /**
     * 题分
     */
    private float point;

    /**
     * 试题类别id
     */
    private int questionTypeId;

    /**
     * 答案
     */
    private String answer;

    /**
     * 试题id
     */
    private int questionId;

    /**
     * 注释
     */
    private String comment;

    /**
     * 正误
     */
    private boolean right;

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
