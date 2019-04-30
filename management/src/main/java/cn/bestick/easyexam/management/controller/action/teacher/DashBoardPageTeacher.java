package cn.bestick.easyexam.management.controller.action.teacher;

import cn.bestick.easyexam.common.domain.question.Field;
import cn.bestick.easyexam.management.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 22:54
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Controller
public class DashBoardPageTeacher {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/teacher/dashboard", method = RequestMethod.GET)
    public String dashboardPage(Model model) {

        List<Field> fieldList = questionService.getAllField(null);
        model.addAttribute("fieldList", fieldList);
        return "dashboard";
    }
}