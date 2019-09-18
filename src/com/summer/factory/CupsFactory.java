package com.summer.factory;

import java.lang.reflect.InvocationTargetException;

public interface CupsFactory {
    /**
     * 获取该对象实例
     */
    Object getCup(String name) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

}
