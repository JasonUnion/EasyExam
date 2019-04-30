package cn.bestick.easyexam.portal.controller.action;

import cn.bestick.easyexam.common.domain.exam.Message;
import cn.bestick.easyexam.common.domain.exam.UserQuestionHistory;
import cn.bestick.easyexam.common.domain.question.QuestionHistory;
import cn.bestick.easyexam.portal.security.UserInfo;
import cn.bestick.easyexam.portal.service.QuestionHistoryService;
import cn.bestick.easyexam.portal.service.QuestionService;
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
 * Date: 4/29/16
 * Time: 10:50
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Controller
public class PracticeAction {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionHistoryService questionHistoryService;

    /**
     * 练习模式完成一道题
     *
     * @param qh
     * @return
     */
    @RequestMapping(value = "/student/practice-improve", method = RequestMethod.POST)
    public
    @ResponseBody
    Message submitPractice(@RequestBody QuestionHistory qh) {
        Message msg = new Message();
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserQuestionHistory history = new UserQuestionHistory();
        history.setQuestionId(qh.getQuestionId());
        history.setUserId(userInfo.getUserid());
        history.setQuestionTypeId(qh.getQuestionTypeId());
        boolean isRight = qh.getAnswer().equals(qh.getMyAnswer());
        history.setRight(isRight);
        try {
            questionHistoryService.addUserQuestionHist(history);
        } catch (Exception e) {
            msg.setResult(e.getClass().getName());
            e.printStackTrace();
        }
        return msg;
    }
}
