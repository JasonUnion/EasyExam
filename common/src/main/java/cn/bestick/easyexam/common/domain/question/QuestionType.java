package cn.bestick.easyexam.common.domain.question;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/28/16
 * Time: 22:57
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class QuestionType implements Serializable {

    private int id;
    private String name;
    private boolean subjective;

    public boolean isSubjective() {
        return subjective;
    }

    public void setSubjective(boolean subjective) {
        this.subjective = subjective;
    }

    public QuestionType() {
    }

    public QuestionType(String name) {
        this.name = name;
    }

    public QuestionType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QuestionType [id=" + id + ", name=" + name + ", subjective="
                + subjective + "]";
    }
}
