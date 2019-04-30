package cn.bestick.easyexam.portal.controller.action;

import cn.bestick.easyexam.common.domain.exam.Message;
import cn.bestick.easyexam.common.domain.training.UserTrainingHistory;
import cn.bestick.easyexam.portal.security.UserInfo;
import cn.bestick.easyexam.portal.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 10:51
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Controller
public class TrainingAction {

    @Autowired
    private TrainingService trainingService;

    @RequestMapping(value = "student/set-training-hist", method = RequestMethod.POST)
    public
    @ResponseBody
    Message setTrainingHist(@RequestBody UserTrainingHistory history) {

        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Date now = new Date();
        history.setUserId(userInfo.getUserid());
        history.setLastStateTime(now);
        Message msg = new Message();
        try {
            UserTrainingHistory historyOri = trainingService.getTrainingHistBySectionId(history.getSectionId(), userInfo.getUserid());
            if (historyOri != null) {
                history.setStartTime(historyOri.getStartTime());
                history.setUserTrainingDetail(historyOri.getUserTrainingDetail());
            } else {
                history.setStartTime(now);
            }
            trainingService.setUserTrainingHistory(history);
        } catch (Exception e) {
            msg.setResult(e.getClass().getName());
            e.printStackTrace();
        }
        return msg;
    }
}
