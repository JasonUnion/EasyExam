package cn.bestick.easyexam.management.security;

import com.rabbitmq.http.client.domain.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:04
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class UserInfoUtil {

    public static UserInfo getUserInfo() {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userInfo;
    }
}
