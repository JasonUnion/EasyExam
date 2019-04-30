package cn.bestick.easyexam.portal.service;

import cn.bestick.easyexam.common.domain.news.News;
import cn.bestick.easyexam.common.util.Page;
import cn.bestick.easyexam.portal.persistence.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 10:37
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> getNewsList(Page<News> page) {
        return newsMapper.getNewsList(page);
    }

    @Override
    public News getNewsById(int newsId) {
        return newsMapper.getNewsById(newsId);
    }
}
