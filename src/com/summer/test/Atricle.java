package com.summer.test;

public class Atricle {

    private Sb sb;

    public Sb getSb() {
        return sb;
    }

    public void setSb(Sb sb) {
        this.sb = sb;
    }

    public void a(){
        System.out.println("我属于atricle：这句话是我自己的");
        sb.sbs();
    }
}
