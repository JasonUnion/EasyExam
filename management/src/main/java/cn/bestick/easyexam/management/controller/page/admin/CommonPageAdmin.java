package cn.bestick.easyexam.management.controller.page.admin;

import cn.bestick.easyexam.common.domain.question.Field;
import cn.bestick.easyexam.common.domain.question.KnowledgePoint;
import cn.bestick.easyexam.common.domain.question.Tag;
import cn.bestick.easyexam.common.domain.user.Department;
import cn.bestick.easyexam.common.util.Page;
import cn.bestick.easyexam.common.util.PagingUtil;
import cn.bestick.easyexam.management.service.QuestionService;
import cn.bestick.easyexam.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 22:02
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Controller
public class CommonPageAdmin {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    /**
     * 标签管理
     *
     * @param model
     * @param index
     * @return
     */
    @RequestMapping(value = "/admin/common/tag-list", method = RequestMethod.GET)
    public String tagListPage(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int index) {
        Page<Tag> page = new Page<Tag>();
        page.setPageNo(index);
        page.setPageSize(8);
        List<Tag> tagList = questionService.getTags(page);
        String pageStr = PagingUtil.getPagelink(index, page.getTotalPage(), "", "admin/common/tag-list");
        model.addAttribute("tagList", tagList);
        model.addAttribute("pageStr", pageStr);
        return "tag-list";
    }

    /**
     * 添加标签
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/common/add-tag", method = RequestMethod.GET)
    public String addTagPage(Model model) {
        return "add-tag";
    }

    /**
     * 专业管理
     *
     * @param model
     * @param index
     * @return
     */
    @RequestMapping(value = "/admin/common/field-list", method = RequestMethod.GET)
    public String fieldListPage(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int index) {

        Page<Field> page = new Page<Field>();
        page.setPageNo(index);
        page.setPageSize(8);
        List<Field> fieldList = questionService.getAllField(page);
        String pageStr = PagingUtil.getPagelink(index, page.getTotalPage(), "", "admin/common/field-list");
        model.addAttribute("fieldList", fieldList);
        model.addAttribute("pageStr", pageStr);
        return "field-list";
    }

    /**
     * 添加专业
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/common/add-field", method = RequestMethod.GET)
    public String addFieldPage(Model model) {
        return "add-field";
    }

    /**
     * 知识点管理
     *
     * @param model
     * @param fieldId
     * @param index
     * @return
     */
    @RequestMapping(value = "/admin/common/knowledge-list/{fieldId}", method = RequestMethod.GET)
    public String knowledgeListPage(Model model, @PathVariable("fieldId") int fieldId, @RequestParam(value = "page", required = false, defaultValue = "1") int index) {

        Page<KnowledgePoint> page = new Page<KnowledgePoint>();
        page.setPageNo(index);
        page.setPageSize(8);

        List<Field> fieldList = questionService.getAllField(null);

        List<KnowledgePoint> pointList = questionService.getKnowledgePointByFieldId(fieldId, page);
        String pageStr = PagingUtil.getPagelink(index, page.getTotalPage(), "", "admin/common/knowledge-list/" + fieldId);
        model.addAttribute("pointList", pointList);
        model.addAttribute("fieldList", fieldList);
        model.addAttribute("fieldId", fieldId);
        model.addAttribute("pageStr", pageStr);
        return "knowledge-list";
    }

    /**
     * 添加知识点
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/common/add-point", method = RequestMethod.GET)
    public String addKnowledgePage(Model model) {
        List<Field> fieldList = questionService.getAllField(null);
        model.addAttribute("fieldList", fieldList);
        return "add-point";
    }

    /**
     * 专业管理
     *
     * @param model
     * @param index
     * @return
     */
    @RequestMapping(value = "/admin/common/dep-list", method = RequestMethod.GET)
    public String depListPage(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int index) {

        Page<Department> page = new Page<Department>();
        page.setPageNo(index);
        page.setPageSize(8);
        List<Department> depList = userService.getDepList(page);
        String pageStr = PagingUtil.getPagelink(index, page.getTotalPage(), "", "admin/common/dep-list");
        model.addAttribute("depList", depList);
        model.addAttribute("pageStr", pageStr);
        return "dep-list";
    }
}