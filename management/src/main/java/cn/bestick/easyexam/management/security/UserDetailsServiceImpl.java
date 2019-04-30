package cn.bestick.easyexam.management.security;

import cn.bestick.easyexam.common.domain.user.User;
import cn.bestick.easyexam.management.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:08
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Component("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserInfo userInfo;

    @Autowired
    public UserMapper userMapper;

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userMapper.getUserByName(username);
        if (user == null)
            throw new UsernameNotFoundException("user not found!");

        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles());
        userInfo = new UserInfo(username, user.getPassword(), true, true, true, true, authorities);
        userInfo.setUserid(user.getUserId());
        userInfo.setRolesName(user.getRoles());
        return userInfo;
    }
}
