package com.leafmaple.androidtraining.bean;

public class LineBean {

    private String year;
    private int salaries;

    public LineBean(String year, int salaries) {
        this.year = year;
        this.salaries = salaries;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getSalaries() {
        return salaries;
    }

    public void setSalaries(int salaries) {
        this.salaries = salaries;
    }
}
