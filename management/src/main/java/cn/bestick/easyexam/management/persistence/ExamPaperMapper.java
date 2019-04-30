package cn.bestick.easyexam.management.persistence;

import cn.bestick.easyexam.common.domain.exam.ExamPaper;
import cn.bestick.easyexam.common.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 17:45
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Repository
public interface ExamPaperMapper {

    List<ExamPaper> getExamPaperList(@Param("searchStr") String searchStr, @Param("paperType") String paperType, @Param("page") Page<ExamPaper> page);

    void insertExamPaper(ExamPaper examPaper);

    ExamPaper getExamPaperById(int examPaperId);

    void updateExamPaper(ExamPaper examPaper);

    void deleteExamPaper(int id);

    List<ExamPaper> getEnabledExamPaperList(@Param("userName") String userName, @Param("page") Page<ExamPaper> page);
}
