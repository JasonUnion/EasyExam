package cn.bestick.easyexam.portal.persistence;

import cn.bestick.easyexam.common.domain.question.Comment;
import cn.bestick.easyexam.common.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/28/16
 * Time: 23:35
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Repository
public interface CommentMapper {

    List<Comment> getCommentByTypeAndReferId(@Param("commentType") int commentType,
                                             @Param("referId") int referId,
                                             @Param("indexId") int indexId,
                                             @Param("page") Page<Comment> page);

    /**
     * 添加评论
     *
     * @param comment
     */
    void addComment(Comment comment);

    Integer getMaxCommentIndexByTypeAndReferId(@Param("commentType") int commentType,
                                               @Param("referId") int referId);
}
