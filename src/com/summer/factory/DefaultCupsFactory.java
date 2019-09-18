package com.summer.factory;

import com.summer.commons.LRUCache;

import java.lang.reflect.InvocationTargetException;

public class DefaultCupsFactory extends CupsFactorySupport {

    private LRUCache<String,Object> lruCache = new LRUCache(255);

    private volatile static DefaultCupsFactory defaultCupsFactory;
    private DefaultCupsFactory (){}
    public static DefaultCupsFactory getSingleton() {
        if (defaultCupsFactory == null) {
            synchronized (DefaultCupsFactory.class) {
                if (defaultCupsFactory == null) {
                    defaultCupsFactory = new DefaultCupsFactory();
                }
            }
        }
        return defaultCupsFactory;
    }

    public Object getCup(String name) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (lruCache.get(name)!=null){
            return lruCache.get(name);
        }else {
            lruCache.put(name,super.getCup(name));
            return super.getCup(name);
        }
    }

}
