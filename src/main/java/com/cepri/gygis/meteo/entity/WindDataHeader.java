package com.cepri.gygis.meteo.entity;

public class WindDataHeader {
    private String parameterUnit;
    public String getParameterUnit() {
        return parameterUnit;
    }
    public void setParameterUnit(String unit){
        this.parameterUnit=unit;
    }

    private Integer parameterNumber;
    public Integer getParameterNumber() {
        return parameterNumber;
    }
    public void setParameterNumber(Integer parameterNumber) {
        this.parameterNumber = parameterNumber;
    }

    private float dx;
    public float getDx() {
        return dx;
    }
    public void setDx(float dx) {
        this.dx = dx;
    }

    private float dy;
    public float getDy() {
        return dy;
    }
    public void setDy(float dy) {
        this.dy = dy;
    }

    private String parameterNumberName;
    public String getParameterNumberName() {
        return parameterNumberName;
    }
    public void setParameterNumberName(String parameterNumberName) {
        this.parameterNumberName = parameterNumberName;
    }

    private float la1;
    public float getLa1() {
        return la1;
    }
    public void setLa1(float la1) {
        this.la1 = la1;
    }

    private float la2;
    public float getLa2() {
        return la2;
    }
    public void setLa2(float la2) {
        this.la2 = la2;
    }

    private Integer parameterCategory;
    public Integer getParameterCategory() {
        return parameterCategory;
    }
    public void setParameterCategory(Integer parameterCategory) {
        this.parameterCategory = parameterCategory;
    }

    private float lo1;
    public float getLo1() {
        return lo1;
    }
    public void setLo1(float lo1) {
        this.lo1 = lo1;
    }

    private float lo2;
    public float getLo2() {
        return lo2;
    }
    public void setLo2(float lo2) {
        this.lo2 = lo2;
    }

    private Integer nx;
    public Integer getNx() {
        return nx;
    }
    public void setNx(Integer nx) {
        this.nx = nx;
    }

    private Integer ny;
    public Integer getNy() {
        return ny;
    }
    public void setNy(Integer ny) {
        this.ny = ny;
    }

    private String refTime;
    public String getRefTime() {
        return refTime;
    }
    public void setRefTime(String refTime) {
        this.refTime = refTime;
    }
}
