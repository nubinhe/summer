package com.summer.test;


import com.summer.support.XmlReaderSupport;
import org.dom4j.DocumentException;

public class XmlReaderSupportTest {

    public void propertyRead() throws DocumentException {
        XmlReaderSupport xmlReaderSupport = new XmlReaderSupport();
        xmlReaderSupport.propertyRead();

    }

    public static void main(String[] args) throws DocumentException {
        XmlReaderSupport xmlReaderSupport = new XmlReaderSupport();
        xmlReaderSupport.propertyRead();
    }
}
