package com.leafmaple.androidtraining.bean;

public class BarBean {

    private LineBean lineBean1;
    private LineBean lineBean2;

    public BarBean(LineBean lineBean1, LineBean lineBean2) {
        this.lineBean1 = lineBean1;
        this.lineBean2 = lineBean2;
    }

    public LineBean getLineBean1() {
        return lineBean1;
    }

    public void setLineBean1(LineBean lineBean1) {
        this.lineBean1 = lineBean1;
    }

    public LineBean getLineBean2() {
        return lineBean2;
    }

    public void setLineBean2(LineBean lineBean2) {
        this.lineBean2 = lineBean2;
    }
}
