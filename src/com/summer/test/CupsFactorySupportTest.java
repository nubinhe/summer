package com.summer.test;

import com.summer.factory.DefaultCupsFactory;

import java.lang.reflect.InvocationTargetException;

public class CupsFactorySupportTest{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Book book = (Book)DefaultCupsFactory.getSingleton().getCup("book");
        book.t();
        Atricle atricle =(Atricle)DefaultCupsFactory.getSingleton().getCup("atricle");
        atricle.a();
    }

//    public static void mIn(Book book) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException { ;
//        Class<? extends Book> aClass = book.getClass();
//        Book book1 = aClass.newInstance();
//        Method method = aClass.getMethod("setAtricle",Atricle.class);
//        System.out.println(method);
//        method.setAccessible(true);
//        System.out.println(method.invoke(book, new Atricle()));
//        method.invoke(book, new Atricle());
//    }
}