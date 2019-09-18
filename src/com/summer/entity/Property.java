package com.summer.entity;

public class Property {
    private String propertyName;
    private String propertyRef;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyRef() {
        return propertyRef;
    }

    public void setPropertyRef(String propertyRef) {
        this.propertyRef = propertyRef;
    }

    public Property(String propertyName, String propertyRef) {
        this.propertyName = propertyName;
        this.propertyRef = propertyRef;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyName='" + propertyName + '\'' +
                ", propertyRef='" + propertyRef + '\'' +
                '}';
    }
}
