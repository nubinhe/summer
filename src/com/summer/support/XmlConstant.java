package com.summer.support;

public interface XmlConstant {
    /**
     * xml文件里读取的根节点
     */
    public final String CUPS_ROOT = "cups";

    /**
     * 遍历读取的子节点,类似于spring里的bean
     */
    public final String CUP = "cup";
    /**
     * cup下name
     */
    public final String CUP_NAME = "name";
    /**
     * cup下class
     */
    public final String CUP_CLASS = "class";

    /**
     * property name
     */
    public final String PROPERTY_NAME = "name";
    /**
     * property ref
     */
    public final String PPROPERTY_REF = "ref";
}
