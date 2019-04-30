package cn.bestick.easyexam.common.domain.exam;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/27/16
 * Time: 16:22
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@XmlRootElement
public class ExamFinishParam implements Serializable {

    /**
     * 考试历史id
     */
    private int exam_history_id;

    /**
     * 持续时间
     */
    private int duration;

    /**
     * 答题卡item的HashMap
     */
    private HashMap<Integer, AnswerSheetItem> as;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getExam_history_id() {
        return exam_history_id;
    }

    public void setExam_history_id(int exam_history_id) {
        this.exam_history_id = exam_history_id;
    }

    public HashMap<Integer, AnswerSheetItem> getAs() {
        return as;
    }

    public void setAs(HashMap<Integer, AnswerSheetItem> as) {
        this.as = as;
    }

}
