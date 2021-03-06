package cn.bestick.easyexam.portal.controller.page;

import cn.bestick.easyexam.common.domain.news.News;
import cn.bestick.easyexam.common.domain.user.Department;
import cn.bestick.easyexam.common.util.Page;
import cn.bestick.easyexam.portal.security.UserInfo;
import cn.bestick.easyexam.portal.service.ExamService;
import cn.bestick.easyexam.portal.service.NewsService;
import cn.bestick.easyexam.portal.service.UserService;
import cn.bestick.easyexam.portal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 11:08
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Controller
public class UserPage {

    @Autowired
    private UserService userService;
    @Autowired
    private ExamService examService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private NewsService newsService;

    /**
     * 用户登录页面
     *
     * @return
     */
    @RequestMapping(value = {"/user-login-page"}, method = RequestMethod.GET)
    public String loginPage(Model model, @RequestParam(value = "result", required = false, defaultValue = "") String result, HttpServletRequest request) {
        AuthenticationServiceException exception = (AuthenticationServiceException) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        if (exception != null) {
            if ("准考证号码错误！".equals(exception.getMessage()) || "不在考试时间范围内，不允许使用准考证！".equals(exception.getMessage()))
                return "redirect:quick-start";
        }
        return "login";
    }

    @RequestMapping(value = {"/quick-start"}, method = RequestMethod.GET)
    public String quickStartPage(Model model, @RequestParam(value = "result", required = false, defaultValue = "") String result) {
        return "quick-start";
    }

    @RequestMapping(value = {"/user-register"}, method = RequestMethod.GET)
    public String registerPage(Model model) {
        List<Department> depList = userService.getDepList(null);
        model.addAttribute("depList", depList);
        return "register";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        return "redirect:home";
    }

    @RequestMapping(value = {"home"}, method = RequestMethod.GET)
    public String directToBaseHomePage(Model model, HttpServletRequest request) {

        Page<News> pageModel = new Page<News>();
        pageModel.setPageNo(1);
        pageModel.setPageSize(2);
        List<News> newsList = newsService.getNewsList(pageModel);
        model.addAttribute("newsList", newsList);

        request.getSession().removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        String result = request.getParameter("result");
        if ("failed".equals(result)) {
            model.addAttribute("result_msg", "登陆失败");
        }

        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            //this.appendBaseInfo(model);
            return "home";
        }
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().endsWith("anonymousUser")) {
            //this.appendBaseInfo(model);
            return "home";
        }

        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        //非常关键，只有histid被重置，其他都不变
        if (userInfo.getHistId() != 0) {
            return "redirect:student/exam-start/" + userInfo.getExamId();
        }
        return "home";
    }

    @RequestMapping(value = {"student/setting"}, method = RequestMethod.GET)
    public String settingPage(Model model) {

        List<Department> depList = userService.getDepList(null);
        model.addAttribute("depList", depList);
        return "setting";
    }

    @RequestMapping(value = {"student/change-password"}, method = RequestMethod.GET)
    public String changePasswordPage() {
        return "change-password";
    }

    @RequestMapping(value = {"news/{newsId}"}, method = RequestMethod.GET)
    public String newsDetailPage(Model model, @PathVariable("newsId") int newsId) {
        News news = newsService.getNewsById(newsId);
        model.addAttribute("news", news);
        return "news-detail";
    }
}
