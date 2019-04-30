package cn.bestick.easyexam.management.controller.page.admin;

import cn.bestick.easyexam.common.domain.news.News;
import cn.bestick.easyexam.common.domain.user.Department;
import cn.bestick.easyexam.common.domain.user.User;
import cn.bestick.easyexam.common.util.Page;
import cn.bestick.easyexam.common.util.PagingUtil;
import cn.bestick.easyexam.management.security.UserInfo;
import cn.bestick.easyexam.management.service.NewsService;
import cn.bestick.easyexam.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 22:14
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Controller
public class SystemPageAdmin {

    @Autowired
    private UserService userService;

    @Autowired
    private NewsService newsService;

    /**
     * 管理员列表
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/system/admin-list", method = RequestMethod.GET)
    private String adminListPage(Model model, HttpServletRequest request) {
        int index = 1;
        if (request.getParameter("page") != null)
            index = Integer.parseInt(request.getParameter("page"));
        Page<User> page = new Page<>();
        page.setPageNo(index);
        page.setPageSize(10);
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Department> depList = userService.getDepList(null);
        List<User> userList = userService.getUserListByRoleId(userInfo.getRoleMap().get("ROLE_ADMIN").getRoleId(), page);
        String pageStr = PagingUtil.getPagelink(index, page.getTotalPage(), "", "admin/system/admin-list");
        model.addAttribute("depList", depList);
        model.addAttribute("userList", userList);
        model.addAttribute("pageStr", pageStr);
        return "sys-admin-list";
    }

    /**
     * 添加管理员
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/system/admin-add", method = RequestMethod.GET)
    private String adminAddPage(Model model, HttpServletRequest request) {
        return "";
    }

    /**
     * 数据备份
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/system/backup", method = RequestMethod.GET)
    private String backupPage(Model model, HttpServletRequest request) {
        return "";
    }

    /**
     * 系统公告
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/system/news-list", method = RequestMethod.GET)
    private String newsListPage(Model model, HttpServletRequest request, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {

        Page<News> pageModel = new Page<>();
        pageModel.setPageNo(page);
        pageModel.setPageSize(10);
        List<News> newsList = newsService.getNewsList(pageModel);
        String pageStr = PagingUtil.getPagelink(page, pageModel.getTotalPage(), "", "admin/system/news-list");
        model.addAttribute("newsList", newsList);
        model.addAttribute("pageStr", pageStr);
        return "news-list";
    }

    /**
     * 发布公告
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/system/news-add", method = RequestMethod.GET)
    private String newsAddPage(Model model, HttpServletRequest request) {
        return "";
    }
}