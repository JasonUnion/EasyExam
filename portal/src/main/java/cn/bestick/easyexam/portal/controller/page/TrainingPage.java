package cn.bestick.easyexam.portal.controller.page;

import cn.bestick.easyexam.common.domain.training.Training;
import cn.bestick.easyexam.common.domain.training.TrainingSection;
import cn.bestick.easyexam.common.domain.training.TrainingSectionProcess;
import cn.bestick.easyexam.common.domain.training.UserTrainingHistory;
import cn.bestick.easyexam.common.util.Page;
import cn.bestick.easyexam.common.util.PagingUtil;
import cn.bestick.easyexam.portal.security.UserInfo;
import cn.bestick.easyexam.portal.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 11:05
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Controller
public class TrainingPage {

    @Autowired
    private TrainingService trainingService;

    @RequestMapping(value = "/training-list", method = RequestMethod.GET)
    public String trainingListPage(Model model, HttpServletRequest request, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {

        Page<Training> pageModel = new Page<Training>();
        pageModel.setPageNo(page);
        pageModel.setPageSize(10);
        List<Training> trainingList = trainingService.getTrainingList(pageModel);
        String pageStr = PagingUtil.getPageBtnlink(page,
                pageModel.getTotalPage());
        model.addAttribute("trainingList", trainingList);
        model.addAttribute("pageStr", pageStr);
        return "training-list";
    }

    @RequestMapping(value = "/student/training/{trainingId}", method = RequestMethod.GET)
    public String trainingPage(Model model, HttpServletRequest request, @PathVariable("trainingId") int trainingId, @RequestParam(value = "sectionId", required = false, defaultValue = "-1") int sectionId) {

        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        List<TrainingSection> sectionList = trainingService.getTrainingSectionByTrainingId(trainingId, null);
        if (sectionList == null) {
            model.addAttribute("errorMsg", "章节不存在！");
            return "error";
        }
        TrainingSection thisSection = null;

        for (TrainingSection section : sectionList) {

            if (section.getSectionId() == sectionId || sectionId == -1) {
                String filePath = section.getFilePath();
                section.setFilePath("../" + filePath.replace("\\", "/"));
                thisSection = section;
                sectionId = section.getSectionId();
                break;
            }
        }
        UserTrainingHistory history = trainingService.getTrainingHistBySectionId(thisSection.getSectionId(), userInfo.getUserid());
        float duration = 0;
        boolean finished = false;
        if (history != null) {
            duration = history.getDuration();
            if (history.getProcess() == 1)
                finished = true;
        }

        //每一个章节已经耗费的时间，每次提交需要加上这个时间
        model.addAttribute("finished", finished);
        model.addAttribute("duration", duration);
        model.addAttribute("sectionList", sectionList);
        model.addAttribute("sectionId", sectionId);
        model.addAttribute("section", thisSection);
        if (thisSection.getFileType().toLowerCase().equals(".pdf"))
            return "training-pdf";
        else
            return "training";
    }

    @RequestMapping(value = "/student/training/video", method = RequestMethod.GET)
    public String videoPage(Model model, HttpServletRequest request) {
        return "video";
    }

    @RequestMapping(value = "/student/training-history", method = RequestMethod.GET)
    public String trainingHistory(Model model, HttpServletRequest request, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Page<Training> pageModel = new Page<Training>();
        pageModel.setPageNo(page);
        pageModel.setPageSize(10);
        List<Training> trainingList = trainingService.getTrainingList(pageModel);
        Map<Integer, List<TrainingSectionProcess>> processMap = trainingService.getTrainingSectionProcessMapByUserId(userInfo.getUserid());
        String pageStr = PagingUtil.getPageBtnlink(page,
                pageModel.getTotalPage());
        model.addAttribute("trainingList", trainingList);
        model.addAttribute("processMap", processMap);
        model.addAttribute("pageStr", pageStr);
        return "training-history";
    }
}
