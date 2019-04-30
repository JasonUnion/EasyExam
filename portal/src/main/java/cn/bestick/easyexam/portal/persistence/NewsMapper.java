package cn.bestick.easyexam.portal.persistence;

import cn.bestick.easyexam.common.domain.news.News;
import cn.bestick.easyexam.common.util.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/29/16
 * Time: 00:09
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Repository
public interface NewsMapper {

    List<News> getNewsList(Page<News> page);

    News getNewsById(int newsId);
}
