package cn.bestick.easyexam.common.domain.exam;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/27/16
 * Time: 16:23
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class Message implements Serializable {

    /**
     * 结果
     */
    private String result = "success";

    /**
     * generatedId
     */
    private int generatedId;

    /**
     * messageInfo
     */
    private String messageInfo;

    /**
     * object
     */
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getGeneratedId() {
        return generatedId;
    }

    public void setGeneratedId(int generatedId) {
        this.generatedId = generatedId;
    }
}
