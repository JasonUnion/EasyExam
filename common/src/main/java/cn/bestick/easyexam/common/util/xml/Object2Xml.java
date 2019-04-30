package cn.bestick.easyexam.common.util.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/28/16
 * Time: 23:58
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class Object2Xml {

    public static String toXml(Object obj) {
        XStream xstream = new XStream();
        xstream.processAnnotations(obj.getClass());

        return xstream.toXML(obj);
    }

    public static <T> T toBean(String xmlStr, Class<T> cls) {
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(cls);
        T obj = (T) xstream.fromXML(xmlStr);
        return obj;
    }
}
