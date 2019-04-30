package cn.bestick.easyexam.management.service;

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
 * Date: 5/5/16
 * Time: 18:46
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

    List<User> getUserListByRoleId(int roleId, Page<User> page);

    void updateUser(User user, String oldPassword);

    /**
     * 获取
     *
     * @param userId
     * @param page
     * @return
     */
    List<Group> getGroupListByUserId(int userId, Page<Group> page);

    /**
     * 添加一个分组
     *
     * @param group
     */
    void addGroup(Group group);

    /**
     * 更新分组
     *
     * @param groupId
     * @param groupName
     */
    void updateGroup(int groupId, String groupName);

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
     * 删除分组
     *
     * @param groupId
     */
    void deleteGroup(int groupId);

    /**
     * 添加用户到分组
     *
     * @param userId
     * @param groupId
     */
    void addUserGroup(int userId, int groupId);

    /**
     * 根据groupid和关键字来查询用户
     *
     * @param groupId   0 则为全部用户
     * @param searchStr
     * @param page
     * @return
     */
    List<User> getUserListByGroupIdAndParams(int groupId, String authority, String searchStr, Page<User> page);

    /**
     * 将一批用户插入到用户分组
     *
     * @param userNames
     * @param groupId
     * @param roleMap
     */
    void addUsers2Group(String[] userNames, int groupId, HashMap<String, Role> roleMap);

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
     * 新增部门
     *
     * @param dep
     */
    void addDep(Department dep);

    /**
     * 更新部门
     *
     * @param dep
     */
    void updateDep(Department dep);

    /**
     * 删除一个部门
     *
     * @param depId
     */
    void deleteDep(int depId);

    /**
     * 重置用户密码
     *
     * @param userName
     * @param password
     */
    void updateUserPwd(String userName, String password, String authority) throws Exception;
}