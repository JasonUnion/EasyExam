package cn.bestick.easyexam.portal.service;

import cn.bestick.easyexam.common.domain.exam.ExamPaper;
import cn.bestick.easyexam.portal.persistence.ExamPaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("examPaperService")
public class ExamPaperServiceImpl implements ExamPaperService {

    @Autowired
    private ExamPaperMapper examPaperMapper;

    @Override
    public ExamPaper getExamPaperById(int examPaperId) {
        return examPaperMapper.getExamPaperById(examPaperId);
    }
}
