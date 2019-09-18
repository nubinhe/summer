package com.summer.support;


import org.dom4j.DocumentException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface XmlReader<T> {
    List arr = new LinkedList<String>();
    /**
     *该方法读取配置文件目录下的配置文件.xml
     * @return cup的map集合
     */
    HashMap<T,T> cupsRead(String xmlRoot);

    HashMap<T,T> cupsRead() throws DocumentException;

    ArrayList propertyRead() throws DocumentException;
}
