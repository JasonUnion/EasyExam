package cn.bestick.easyexam.management.controller.action;

import cn.bestick.easyexam.common.domain.exam.AnswerSheet;
import cn.bestick.easyexam.common.domain.exam.AnswerSheetItem;
import cn.bestick.easyexam.common.domain.exam.ExamPaper;
import cn.bestick.easyexam.common.domain.exam.Message;
import cn.bestick.easyexam.management.service.ExamPaperService;
import cn.bestick.easyexam.management.service.ExamService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 22:30
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Controller
public class ExamAction {

    @Autowired
    private ExamPaperService examPaperService;

    @Autowired
    private ExamService examService;

    @RequestMapping(value = "/api/exampaper/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ExamPaper getExamPaper(@PathVariable("id") int id) {
        ExamPaper paper = examPaperService.getExamPaperById(id);
        return paper;
    }

    @RequestMapping(value = "/api/answersheet", method = RequestMethod.POST)
    public
    @ResponseBody
    Message submitAnswerSheet(@RequestBody AnswerSheet answerSheet) {

        List<AnswerSheetItem> itemList = answerSheet.getAnswerSheetItems();

        //全部是客观题，则状态更改为已阅卷
        int approved = 3;
        for (AnswerSheetItem item : itemList) {
            if (item.getQuestionTypeId() != 1 && item.getQuestionTypeId() != 2 && item.getQuestionTypeId() != 3) {
                approved = 2;
                break;
            }
        }
        Gson gson = new Gson();
        examService.updateUserExamHist(answerSheet, gson.toJson(answerSheet), approved);
        return new Message();
    }
}