package cn.bestick.easyexam.management.service;

import cn.bestick.easyexam.common.util.MenuItem;
import cn.bestick.easyexam.management.persistence.SystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 18:43
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Service("systemService")
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemMapper systemMapper;

    @Override
    public LinkedHashMap<String, MenuItem> getMenuItemsByAuthority(String authority) {

        List<MenuItem> ml = systemMapper.getMenuItemsByAuthority(authority);
        LinkedHashMap<String, MenuItem> map = new LinkedHashMap<String, MenuItem>();

        for (MenuItem item : ml) {
            if (item.getParentId().equals("-1")) {
                LinkedHashMap<String, MenuItem> childs = new LinkedHashMap<String, MenuItem>();
                for (MenuItem mi : ml) {
                    if (mi.getParentId().equals(item.getMenuId())) {
                        childs.put(mi.getMenuId(), mi);
                    }
                }
                item.setChildMap(childs);
                map.put(item.getMenuId(), item);
            }
        }
        return map;
    }
}
