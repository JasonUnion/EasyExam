package cn.bestick.easyexam.common.domain.question;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/28/16
 * Time: 22:49
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class Comments {

    private List<Comment> comments = null;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
