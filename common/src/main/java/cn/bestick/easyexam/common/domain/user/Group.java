package cn.bestick.easyexam.common.domain.user;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/28/16
 * Time: 23:05
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@XmlRootElement
public class Group implements Serializable {

    private int groupId;
    private String groupName;
    private int userId;
    private boolean defaultt;

    public boolean isDefaultt() {
        return defaultt;
    }

    public void setDefaultt(boolean defaultt) {
        this.defaultt = defaultt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
