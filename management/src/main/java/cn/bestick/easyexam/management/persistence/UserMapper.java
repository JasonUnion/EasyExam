package cn.bestick.easyexam.management.persistence;

import cn.bestick.easyexam.common.domain.user.Department;
import cn.bestick.easyexam.common.domain.user.Group;
import cn.bestick.easyexam.common.domain.user.Role;
import cn.bestick.easyexam.common.domain.user.User;
import cn.bestick.easyexam.common.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 17:30
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Repository
public interface UserMapper {

    /**
     * 根据用户名称查询用户基本信息
     *
     * @param username
     * @return
     */
    User getUserByName(String username);

    /**
     * 添加user并返回该记录的主键
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新user基本信息(包括更新password,fullname)
     *
     * @param user
     */
    void updateUser(@Param("user") User user, @Param("oldpassword") String oldpassword);

    /**
     * 查询某角色的所有用户
     *
     * @param roleId
     * @return
     */
    List<User> getUserListByRoleId(@Param("roleId") int roleId, @Param("page") Page<User> page);

    /**
     * 给用户授权一种角色
     *
     * @param userId roleId
     */
    void grantUserRole(@Param("userId") int userId, @Param("roleId") int roleId);

    /**
     * 获取
     *
     * @param userId
     * @param page
     * @return
     */
    List<Group> getGroupListByUserId(@Param("userId") int userId, @Param("page") Page<Group> page);

    /**
     * 添加一个分组
     *
     * @param group
     */
    void addGroup(@Param("group") Group group);

    /**
     * 为学员分配一个用户组
     *
     * @param userId
     * @param groupId
     */
    void addUserGroup(@Param("userId") int userId, @Param("groupId") int groupId);

    /**
     * 更新分组
     *
     * @param groupId
     * @param groupName
     */
    void updateGroup(@Param("groupId") int groupId, @Param("groupName") String groupName);

    /**
     * 获取所有的角色
     *
     * @return
     */
    List<Role> getRoleList();

    /**
     * 更新用户状态
     *
     * @param idList
     * @param enabled
     */
    void changeUserStatus(@Param("array") List<Integer> idList, @Param("enabled") boolean enabled);

    /**
     * 删除分组
     *
     * @param groupId
     */
    void deleteGroup(int groupId);

    /**
     * 删除分组
     *
     * @param userId
     * @param groupId
     * @param managerId 只能删除自己管理的分组中的数据
     */
    void deleteUserGroup(@Param("userId") int userId, @Param("groupId") int groupId, @Param("managerId") int managerId);

    /**
     * 根据groupid和关键字来查询用户
     *
     * @param groupId   0 则为全部用户
     * @param searchStr
     * @param page
     * @return
     */
    List<User> getUserListByGroupIdAndParams(@Param("groupId") int groupId, @Param("authority") String authority,
                                                    @Param("searchStr") String searchStr, @Param("page") Page<User> page);

    /**
     * 根据用户名清单获取用户
     *
     * @param nameList
     * @return
     */
    List<User> getUserByNames(@Param("array") String[] nameList, @Param("roleId") int roleId);

    /**
     * 批量添加用户到分组
     *
     * @param idList
     * @param groupId
     */
    void addUsers2Group(@Param("array") List<Integer> idList, @Param("groupId") int groupId);

    /**
     * 获取所有部门信息
     *
     * @param page
     * @return
     */
    List<Department> getDepList(@Param("page") Page<Department> page);

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
     * 为用户添加一个部门
     *
     * @param userId
     * @param depId
     */
    void addUser2Dep(@Param("userId") int userId, @Param("depId") int depId);

    /**
     * 删除用户的部门信息
     *
     * @param userId
     */
    void deleteUser2Dep(int userId);

    /**
     * 获取分组中的用户
     *
     * @param idList
     * @param user
     * @return
     */
    List<User> getUserListByGroupIdList(@Param("array") List<Integer> idList, @Param("page") Page<User> user);
}
