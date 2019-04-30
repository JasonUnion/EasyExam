package cn.bestick.easyexam.management.controller.page;

import cn.bestick.easyexam.common.util.MenuItem;
import cn.bestick.easyexam.management.security.UserInfo;
import cn.bestick.easyexam.management.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 21:46
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Controller
public class MenuPage {

    @Autowired
    private SystemService systemService;

    /**
     * 显示顶部菜单
     *
     * @param model
     * @param request
     * @return String
     */
    @RequestMapping(value = {"common-page/top-menu"}, method = RequestMethod.GET)
    public String showTopMenuPage(Model model, HttpServletRequest request) {

        UserInfo userInfo = "anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal()) ? null : (UserInfo) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        String role = userInfo == null ? "ROLE_TEACHER" : userInfo.getRolesName();

        List<MenuItem> list = new ArrayList<MenuItem>();

        if (userInfo != null) {
            LinkedHashMap<String, MenuItem> map = userInfo.getMenuMap();
            for (Map.Entry<String, MenuItem> entry : map.entrySet()) {
                list.add(entry.getValue());
            }
            model.addAttribute("topMenuList", list);
        }

        System.out.println(request.getParameter("topMenuId"));
        System.out.println(request.getParameter("leftMenuId"));
        model.addAttribute("topMenuId", request.getParameter("topMenuId"));
        model.addAttribute("leftMenuId", request.getParameter("leftMenuId"));

        return "common/top-menu";
    }

    @RequestMapping(value = {"common-page/left-menu"}, method = RequestMethod.GET)
    public String showLeftMenuPage(Model model, HttpServletRequest request) {

        String topMenuId = request.getParameter("topMenuId");
        String leftMenuId = request.getParameter("leftMenuId");

        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = userInfo.getRolesName();

        List<MenuItem> list = new ArrayList<MenuItem>();

        LinkedHashMap<String, MenuItem> map = userInfo.getMenuMap().get(topMenuId).getChildMap();
        for (Map.Entry<String, MenuItem> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        model.addAttribute("leftMenuList", list);
        System.out.println(request.getParameter("topMenuId"));
        System.out.println(request.getParameter("leftMenuId"));
        model.addAttribute("topMenuId", topMenuId);
        model.addAttribute("leftMenuId", leftMenuId);
        return "common/left-menu";
    }

    @RequestMapping(value = {"common-page/footer"}, method = RequestMethod.GET)
    public String showFooterPage(Model model, HttpServletRequest request) {
        return "common/footer";
    }
}