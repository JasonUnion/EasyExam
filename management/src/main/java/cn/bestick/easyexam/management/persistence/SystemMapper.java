package cn.bestick.easyexam.management.persistence;

import cn.bestick.easyexam.common.util.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 17:53
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Repository
public interface SystemMapper {

    List<MenuItem> getMenuItemsByAuthority(String authority);
}
