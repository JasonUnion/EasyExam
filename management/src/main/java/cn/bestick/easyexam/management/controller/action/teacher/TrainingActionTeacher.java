package cn.bestick.easyexam.management.controller.action.teacher;

import cn.bestick.easyexam.common.domain.exam.Message;
import cn.bestick.easyexam.common.domain.training.Training;
import cn.bestick.easyexam.common.domain.training.TrainingSection;
import cn.bestick.easyexam.management.security.UserInfo;
import cn.bestick.easyexam.management.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 22:58
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Controller
public class TrainingActionTeacher {

    @Autowired
    private TrainingService trainingService;

    @RequestMapping(value = "teacher/training/add-training", method = RequestMethod.POST)
    public
    @ResponseBody
    Message addTraining(@RequestBody Training training) {

        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Message msg = new Message();
        try {
            training.setCreatorId(userInfo.getUserid());
            trainingService.addTraining(training);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setResult(e.getClass().getName());
        }
        return msg;
    }

    @RequestMapping(value = "teacher/training/add-training-section", method = RequestMethod.POST)
    public
    @ResponseBody
    Message addTrainingSection(@RequestBody TrainingSection section) {

        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Message msg = new Message();
        try {
            section.setUserId(userInfo.getUserid());
            trainingService.addTrainingSection(section);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setResult(e.getClass().getName());
        }
        return msg;
    }
}