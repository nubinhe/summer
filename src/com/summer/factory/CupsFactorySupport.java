package com.summer.factory;

import com.summer.commons.InjectUtils;
import com.summer.entity.Cup;
import com.summer.entity.Property;
import com.summer.support.XmlReaderSupport;
import org.dom4j.DocumentException;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class CupsFactorySupport implements CupsFactory {

    private static HashMap singleCupsHashMap = new HashMap();
    private static ArrayList<Cup> singleCupsPropertiseList = new ArrayList();

    @Override
    public Object getCup(String name) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //未进行实例化的对象的String描述
        HashMap hashMap = getCupsMap();
        //clsRoot表示类的路径
        String clsRoot = (String) hashMap.get(name);
        Object o = classInstance(clsRoot);
        if(singleCupsHashMap.containsKey(name)||singleCupsHashMap.containsValue(o)){
        }else {
            singleCupsHashMap.put(name,o);
        }
        singleCupsPropertiseList = getCupsList();
        for (Cup cup:singleCupsPropertiseList){
            ArrayList<Property> listProperty = cup.getListProperty();
            if(cup.getCupName().equals(name)) {
                for (Property p : listProperty) {
                    String propertyRef = p.getPropertyRef();
                    String propertyRoot = (String) hashMap.get(propertyRef);

                    if (singleCupsHashMap.containsKey(propertyRef)) {
                        InjectUtils.enhance(singleCupsHashMap.get(name), singleCupsHashMap.get(propertyRef), propertyRef);
                    } else {
                        Object o1 = classInstance(propertyRoot);
                        InjectUtils.enhance(singleCupsHashMap.get(name), o1, propertyRef);
                        singleCupsHashMap.put(propertyRef, o1);
                    }
                }
            }
        }
        return singleCupsHashMap.get(name);
    }

    private HashMap<String,String> getCupsMap(){
        XmlReaderSupport xmlReaderSupport = null;
        try {
            xmlReaderSupport = new XmlReaderSupport();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return xmlReaderSupport.getCupMap();
    }

    private ArrayList<Cup> getCupsList(){
        XmlReaderSupport xmlReaderSupport = null;
        try{
            xmlReaderSupport = new XmlReaderSupport();
        }catch (DocumentException e){
            e.printStackTrace();
        }
        return xmlReaderSupport.getCupList();

    }

    private Object classInstance(String con){
        Class aClass = null;
        try {
            aClass = Class.forName(con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object instance = null;
        try {
            instance = aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
