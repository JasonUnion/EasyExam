package cn.bestick.easyexam.common.util;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/28/16
 * Time: 23:41
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class EhcacheTest {

    @Cacheable(value = "wordCache")
    public String sayWord(String word) {
        System.out.println("nocache");
        return word;
    }

    @CacheEvict(value = "wordCache", key = "#word")
    public String clearWord(String word) {
        return "Ok";
    }
}
