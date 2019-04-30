package cn.bestick.easyexam.portal.service;

import cn.bestick.easyexam.common.domain.question.Comment;
import cn.bestick.easyexam.common.util.Page;
import cn.bestick.easyexam.portal.persistence.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 10:27
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentByTypeAndReferId(int commentType, int referId, int indexId, Page<Comment> page) {
        return commentMapper.getCommentByTypeAndReferId(commentType, referId, indexId, page);
    }

    @Override
    @Transactional
    public void addComment(Comment comment) {
        try {
            Object index = commentMapper.getMaxCommentIndexByTypeAndReferId(comment.getCommentType(), comment.getReferId());
            int i = 0;
            if (index == null)
                i = 0;
            else
                i = (Integer) index;
            comment.setIndexId(i + 1);
            commentMapper.addComment(comment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
