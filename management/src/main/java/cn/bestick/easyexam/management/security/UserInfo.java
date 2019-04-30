package cn.bestick.easyexam.management.security;

import cn.bestick.easyexam.common.domain.user.Role;
import cn.bestick.easyexam.common.util.MenuItem;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:05
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class UserInfo extends User {

    private int userid;
    private List<Role> roleList;
    private String trueName;
    private String rolesName;
    private String enabled;
    private int fieldId;
    private String fieldName;
    private String email;
    private Date lastLoginTime;
    private Date loginTime;
    private LinkedHashMap<String, MenuItem> menuMap;
    private HashMap<String, Role> roleMap;

    public HashMap<String, Role> getRoleMap() {
        return roleMap;
    }

    public void setRoleMap(HashMap<String, Role> roleMap) {
        this.roleMap = roleMap;
    }

    public LinkedHashMap<String, MenuItem> getMenuMap() {
        return menuMap;
    }

    public void setMenuMap(LinkedHashMap<String, MenuItem> menuMap) {
        this.menuMap = menuMap;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public UserInfo(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
                    Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
