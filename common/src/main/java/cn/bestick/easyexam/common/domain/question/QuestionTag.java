package cn.bestick.easyexam.common.domain.question;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/28/16
 * Time: 22:57
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class QuestionTag implements Serializable {

    private int questionTagId;
    private int questionId;
    private int tagId;
    private String tagName;
    private int creator;
    private boolean privatee;
    private Date createtime;

    public int getQuestionTagId() {
        return questionTagId;
    }

    public void setQuestionTagId(int questionTagId) {
        this.questionTagId = questionTagId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public boolean isPrivatee() {
        return privatee;
    }

    public void setPrivatee(boolean privatee) {
        this.privatee = privatee;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
