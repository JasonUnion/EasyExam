package cn.bestick.easyexam.portal.service;

import cn.bestick.easyexam.common.domain.exam.ExamPaper;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 10:30
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public interface ExamPaperService {

    /**
     * 获取一张试卷
     *
     * @param examPaperId
     * @return
     */
    ExamPaper getExamPaperById(int examPaperId);
}
