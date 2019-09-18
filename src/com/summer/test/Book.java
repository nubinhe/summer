package com.summer.test;

public class Book {

    private Atricle atricle;
    private Sb sb;

    public void setAtricle(Atricle atricle) {
        this.atricle = atricle;
    }

    public Atricle getAtricle() {
        return atricle;
    }

    public void setSb(Sb sb) {
        this.sb = sb;
    }

    public void t(){
        System.out.println("我属于Book对象 ：这句话是我自己的");
        sb.sbs();
    }
}
