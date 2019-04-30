package cn.bestick.easyexam.portal.service;

import cn.bestick.easyexam.common.domain.user.Department;
import cn.bestick.easyexam.common.domain.user.Group;
import cn.bestick.easyexam.common.domain.user.Role;
import cn.bestick.easyexam.common.domain.user.User;
import cn.bestick.easyexam.common.util.Page;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 10:43
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public interface UserService {

    /**
     * 添加一个用户，并授权。如果授权为（教师），则groupId无意义，如果授权为（学员）,groupId为教师管理的分组之一
     *
     * @param user
     * @param authority
     * @param groupId
     * @param roleMap
     * @return
     */
    int addUser(User user, String authority, int groupId, HashMap<String, Role> roleMap);

    void updateUser(User user, String oldPassword);

    /**
     * 修改用户密码
     *
     * @param user
     * @param oldPwd
     */
    void updateUserPwd(User user, String oldPwd);

    /**
     * 获取
     *
     * @param userId
     * @param page
     * @return
     */
    List<Group> getGroupListByUserId(int userId, Page<Group> page);


    /**
     * 获取所有的角色并生成字典
     *
     * @return
     */
    HashMap<String, Role> getRoleMap();

    /**
     * 更新用户状态
     *
     * @param idList
     * @param enabled
     */
    void changeUserStatus(List<Integer> idList, boolean enabled);


    /**
     * 添加用户到分组
     *
     * @param userId
     * @param groupId
     */
    void addUserGroup(int userId, int groupId);

    /**
     * 删除分组
     *
     * @param userId
     * @param groupId
     * @param managerId 只能删除自己管理的分组中的数据
     */
    void deleteUserGroup(int userId, int groupId, int managerId);

    /**
     * 获取所有部门信息
     *
     * @param page
     * @return
     */
    List<Department> getDepList(Page<Department> page);

    /**
     * 获取用户
     *
     * @param userName
     * @return
     */
    User getUserByName(String userName);
}
