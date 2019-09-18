package com.summer.commons;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Deprecated
public class InjectUtils {

    public static void enhance(Object object, Object t,String ref) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (object != null && t != null) {
            Class<?> aClass = object.getClass();
            Class tClass = t.getClass();
            Method method = aClass.getMethod("set" + ref.substring(0, 1).toUpperCase() + ref.substring(1), tClass);
            method.setAccessible(true);
            method.invoke(object, t);
        }
    }
}
