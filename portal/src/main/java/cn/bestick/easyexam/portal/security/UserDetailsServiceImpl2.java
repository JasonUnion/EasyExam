package cn.bestick.easyexam.portal.security;

import cn.bestick.easyexam.common.domain.user.User;
import cn.bestick.easyexam.portal.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 10:16
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Repository("userDetailsServiceImpl2")
public class UserDetailsServiceImpl2 implements UserDetailsService {

    private UserInfo userInfo;
    @Autowired
    public UserMapper userMapper;

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userMapper.getUserByName(username);
        if (user == null)
            throw new UsernameNotFoundException("user not found!");
        //roles=角色代码
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles());
        userInfo = new UserInfo(username, "", user.isEnabled(), true, true, true, authorities);
        userInfo.setUserid(user.getUserId());
        userInfo.setRolesName(user.getRoles());
        userInfo.setTrueName(user.getTrueName());
        userInfo.setEmail(user.getEmail());
        userInfo.setPhoneNum(user.getPhoneNum());
        userInfo.setNationalId(user.getNationalId());
        userInfo.setDepId(user.getDepId());
        return userInfo;
    }
}
