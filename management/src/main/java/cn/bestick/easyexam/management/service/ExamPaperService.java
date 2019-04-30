package cn.bestick.easyexam.management.service;

import cn.bestick.easyexam.common.domain.exam.ExamPaper;
import cn.bestick.easyexam.common.domain.question.QuestionStruts;
import cn.bestick.easyexam.common.util.Page;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:19
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public interface ExamPaperService {

    /**
     * 获取试卷列表
     *
     * @param page
     * @param searchStr 查询关键字
     * @param paperType 试卷类型（专业）
     * @return
     */
    List<ExamPaper> getExamPaperList(String searchStr, String paperType, Page<ExamPaper> page);

    /**
     * 插入一张试卷
     *
     * @param examPaper
     */
    void insertExamPaper(ExamPaper examPaper);

    /**
     * 创建试卷
     *
     * @param questionMap
     * @param questionTypeNum
     * @param questionTypePoint
     * @param knowledgePointRate
     * @param examPaper
     */
    void createExamPaper(
            HashMap<Integer, HashMap<Integer, List<QuestionStruts>>> questionMap,
            HashMap<Integer, Integer> questionTypeNum,
            HashMap<Integer, Float> questionTypePoint,
            HashMap<Integer, Float> knowledgePointRate, ExamPaper examPaper);

    /**
     * 获取一张试卷
     *
     * @param examPaperId
     * @return
     */
    ExamPaper getExamPaperById(int examPaperId);

    /**
     * 更新一张试卷
     *
     * @param examPaper
     */
    void updateExamPaper(ExamPaper examPaper);

    /**
     * 删除一张试卷
     *
     * @param id
     */
    void deleteExamPaper(int id);

    /**
     * 获取当前用户可用的试卷列表
     *
     * @param userName
     * @param page
     * @return is_visiable=1的和当前用户创建的试卷列表
     */
    List<ExamPaper> getEnabledExamPaperList(String userName, Page<ExamPaper> page);

    /**
     * 生成导出试卷
     *
     * @param examPaper
     * @param path
     * @throws Exception
     */
    void generateDoc(ExamPaper examPaper, String path) throws Exception;
}
