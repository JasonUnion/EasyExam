package cn.bestick.easyexam.common.domain.question;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/28/16
 * Time: 22:54
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class QuestionHistory implements Comparable<QuestionHistory> {

    /**
     * 记录试卷id：-1找不到试卷；0练习题
     */
    private int examPaperId;
    private int questionId;
    private Date time;
    private String answer;
    private String myAnswer;
    private boolean isRight;
    private int questionTypeId;
    private int pointId;
    /**
     * 来源，强化练习则设置成1
     */
    private int from;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
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

    public int getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(int examPaperId) {
        this.examPaperId = examPaperId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getMyAnswer() {
        return myAnswer;
    }

    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean isRight) {
        this.isRight = isRight;
    }

    @Override
    public int compareTo(QuestionHistory o) {
        if (this.time.getTime() > o.getTime().getTime())
            return 1;
        else if (this.time.getTime() < o.getTime().getTime())
            return -1;
        else return 0;
    }
}
