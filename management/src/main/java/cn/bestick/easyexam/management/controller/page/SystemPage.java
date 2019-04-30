package cn.bestick.easyexam.management.controller.page;

import cn.bestick.easyexam.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 21:44
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Controller
public class SystemPage {

    @Autowired
    private UserService userService;

    /**
     * 系统备份页面
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/sys-backup", method = RequestMethod.GET)
    private String sysBackUpPage(Model model, HttpServletRequest request) {
        return "sys-backup";
    }
}
