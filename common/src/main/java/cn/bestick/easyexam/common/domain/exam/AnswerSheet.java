package cn.bestick.easyexam.common.domain.exam;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/26
 * Time: 23:10
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class AnswerSheet {

    /**
     * 考试历史id
     */
    private int examHistroyId;

    /**
     * 考试id
     */
    private int examId;

    /**
     * 考试卷id
     */
    private int examPaperId;

    /**
     * 考试时间
     */
    private int duration;

    /**
     * 答题卡
     */
    private List<AnswerSheetItem> answerSheetItems;

    /**
     * pointMax
     */
    private float pointMax;

    /**
     * pointRaw
     */
    private float pointRaw;

    /**
     * 考试开始时间
     */
    private Date startTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getExamHistroyId() {
        return examHistroyId;
    }

    public void setExamHistroyId(int examHistroyId) {
        this.examHistroyId = examHistroyId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(int examPaperId) {
        this.examPaperId = examPaperId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<AnswerSheetItem> getAnswerSheetItems() {
        return answerSheetItems;
    }

    public void setAnswerSheetItems(List<AnswerSheetItem> answerSheetItems) {
        this.answerSheetItems = answerSheetItems;
    }

    public float getPointMax() {
        return pointMax;
    }

    public void setPointMax(float pointMax) {
        this.pointMax = pointMax;
    }

    public float getPointRaw() {
        return pointRaw;
    }

    public void setPointRaw(float pointRaw) {
        this.pointRaw = pointRaw;
    }
}
