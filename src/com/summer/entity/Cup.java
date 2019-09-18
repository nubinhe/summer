package com.summer.entity;

import java.util.ArrayList;

public class Cup {
    private String cupName;
    private ArrayList<Property> listProperty;

    public String getCupName() {
        return cupName;
    }

    public void setCupName(String cupName) {
        this.cupName = cupName;
    }

    public ArrayList<Property> getListProperty() {
        return listProperty;
    }

    public void setListProperty(ArrayList<Property> listProperty) {
        this.listProperty = listProperty;
    }

    public Cup(String cupName, ArrayList<Property> listProperty) {
        this.cupName = cupName;
        this.listProperty = listProperty;
    }

    public Cup() {
    }

    @Override
    public String toString() {
        return "Cup{" +
                "cupName='" + cupName + '\'' +
                ", listProperty=" + listProperty +
                '}';
    }
}
