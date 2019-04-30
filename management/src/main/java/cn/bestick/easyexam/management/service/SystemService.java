package cn.bestick.easyexam.management.service;

import cn.bestick.easyexam.common.util.MenuItem;

import java.util.LinkedHashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:42
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public interface SystemService {

    LinkedHashMap<String,MenuItem> getMenuItemsByAuthority(String authority);
}
