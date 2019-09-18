package com.summer.support;

import com.summer.entity.Cup;
import com.summer.entity.Property;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class XmlReaderSupport implements XmlReader{

    /**
     * 获取读到的cups，并且提供get方法他处调用
     */
    private HashMap cupMap;
    private ArrayList<Cup> cupList;

    public ArrayList getCupList() {
        return cupList;
    }
    private void setCupList(ArrayList cupList) {
        this.cupList = cupList;
    }

    public HashMap getCupMap() {
        return cupMap;
    }
    private void setCupMap(HashMap cupMap) {
        this.cupMap = cupMap;
    }

    /**
     * 构造器调用时对cupMap进行初始化
     * @throws DocumentException
     */
    public XmlReaderSupport() throws DocumentException {
        setCupMap(readXml());
        setCupList(propertyRead());
    }


    @Override
    public HashMap cupsRead(String xmlRoot) {
        return null;
    }

    @Override
    public HashMap cupsRead() throws DocumentException {
        return this.readXml();
    }

    @Override
    public ArrayList<Cup> propertyRead() throws DocumentException {
        Element root = null;
        ArrayList<Cup> cupList = new ArrayList<>();
        try {
            root = fileRead();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        List<Element> cup = root.elements("cup");
        for (Element c :cup){
            String cupName = c.attributeValue(XmlConstant.CUP_NAME);
            Cup MyCup = new Cup();
            MyCup.setCupName(cupName);
            if (c.element("property")!=null) {
                ArrayList<Property> properties = new ArrayList<>();
                List<Element> property = c.elements("property");
                for (Element p:property) {
                    String propertyName = p.attributeValue(XmlConstant.PROPERTY_NAME);
                    String propertyRef = p.attributeValue(XmlConstant.PPROPERTY_REF);
                    Property cupProperty = new Property(propertyName, propertyRef);
                    properties.add(cupProperty);
                }
                MyCup.setListProperty(properties);
                cupList.add(MyCup);

            }
            else {
                cupList.add(MyCup);
            }
        }
        return cupList;
    }

    private HashMap readXml() throws DocumentException {
        Element root = fileRead();
        HashMap<String, String> cupHashMap = new HashMap<>();
        try {
            for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
                Element element = (Element) iterator.next();
                String s = element.attributeValue(XmlConstant.CUP_NAME);
                String classRoot = element.attributeValue(XmlConstant.CUP_CLASS);
                cupHashMap.put(s,classRoot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cupHashMap;
    }


    private Element fileRead() throws DocumentException {
        File file = new File("summer/src/com/summer/test/cup.xml");
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element root = document.getRootElement();
        return root;
    }
}
