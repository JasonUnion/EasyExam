package cn.bestick.easyexam.management.service;

import cn.bestick.easyexam.common.domain.news.News;
import cn.bestick.easyexam.common.util.Page;
import cn.bestick.easyexam.management.persistence.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:38
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

    @Override
    public void addNews(News news) {
        newsMapper.addNews(news);
    }
}
