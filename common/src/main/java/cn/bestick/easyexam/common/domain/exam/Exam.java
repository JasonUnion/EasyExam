package cn.bestick.easyexam.common.domain.exam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/27/16
 * Time: 15:58
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class Exam implements Serializable {

    /**
     * 考试id
     */
    private int examId;

    /**
     * 考试名
     */
    private String examName;

    /**
     * 考试描述
     */
    private String examSubscribe;

    /**
     * 考试类别
     */
    private int examType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 生效时间
     */
    private Date effTime;

    /**
     * 失效时间
     */
    private Date expTime;

    /**
     * 考试卷id
     */
    private int examPaperId;

    /**
     * 考试卷名
     */
    private String examPaperName;

    /**
     * 组id List
     */
    private List<Integer> groupIdList;

    /**
     * 创建者
     */
    private int creator;

    /**
     * 创建者id
     */
    private String creatorId;

    /**
     * 准考证号
     */
    private String seriNo;

    /**
     * 0 未审核, 1 审核通过, 2 审核不通过
     */
    private int approved;

    public String getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(String seriNo) {
        this.seriNo = seriNo;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getExamPaperName() {
        return examPaperName;
    }

    public void setExamPaperName(String examPaperName) {
        this.examPaperName = examPaperName;
    }

    public int getExamType() {
        return examType;
    }

    public void setExamType(int examType) {
        this.examType = examType;
    }

    public String getExamSubscribe() {
        return examSubscribe;
    }

    public void setExamSubscribe(String examSubscribe) {
        this.examSubscribe = examSubscribe;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEffTime() {
        return effTime;
    }

    public void setEffTime(Date effTime) {
        this.effTime = effTime;
    }

    public Date getExpTime() {
        return expTime;
    }

    public void setExpTime(Date expTime) {
        this.expTime = expTime;
    }

    public int getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(int examPaperId) {
        this.examPaperId = examPaperId;
    }

    public List<Integer> getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(List<Integer> groupIdList) {
        this.groupIdList = groupIdList;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }
}
