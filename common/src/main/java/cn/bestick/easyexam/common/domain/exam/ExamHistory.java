package cn.bestick.easyexam.common.domain.exam;

import java.util.Date;

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
public class ExamHistory {

    /**
     * 历史id
     */
    private int histId;

    /**
     * 用户id
     */
    private int userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 实名
     */
    private String trueName;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 考试id
     */
    private int examId;

    /**
     * 考试名
     */
    private String examName;

    /**
     * 考试类别
     */
    private int examType;

    /**
     * 启用
     */
    private boolean enabled;

    /**
     * 考试卷id
     */
    private int examPaperId;

    /**
     * 分数
     */
    private float point;

    /**
     * 准考证号
     */
    private String seriNo;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 答题卡
     */
    private String answerSheet;

    /**
     * 持续时间
     */
    private int duration;

    /**
     * 得分
     */
    private float pointGet;

    /**
     * 提交时间
     */
    private Date submitTime;

    /**
     * 0未审核 1 通过 2 未通过
     */
    private int approved;

    /**
     * 认证时间
     */
    private Date verifyTime;

    /**
     * 通过分数
     */
    private float passPoint;

    /**
     * nationalId
     */
    private String nationalId;

    /**
     * depName
     */
    private String depName;

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public float getPassPoint() {
        return passPoint;
    }

    public void setPassPoint(float passPoint) {
        this.passPoint = passPoint;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getExamType() {
        return examType;
    }

    public void setExamType(int examType) {
        this.examType = examType;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHistId() {
        return histId;
    }

    public void setHistId(int histId) {
        this.histId = histId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(int examPaperId) {
        this.examPaperId = examPaperId;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public String getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(String seriNo) {
        this.seriNo = seriNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAnswerSheet() {
        return answerSheet;
    }

    public void setAnswerSheet(String answerSheet) {
        this.answerSheet = answerSheet;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getPointGet() {
        return pointGet;
    }

    public void setPointGet(float pointGet) {
        this.pointGet = pointGet;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }
}
