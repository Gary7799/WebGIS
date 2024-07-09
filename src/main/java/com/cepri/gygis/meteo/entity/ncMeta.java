package com.cepri.gygis.meteo.entity;


import java.util.ArrayList;
import java.util.List;

public class ncMeta {

    private float la1;//经度min
    private float la2;//经度max
    private float lo1;//纬度max
    private float lo2;//纬度min

    private int nx;//经度方向格网数
    private int ny;//纬度方向格网数
    private float dx;//经度步长
    private float dy;//纬度步长

    //变量集合
    private List<ncVariable> variables;

    public float getLa1() {
        return la1;
    }

    public void setLa1(float value) {
        la1 = value;
    }



    public float getLa2() {
        return la2;
    }

    public void setLa2(float value) {
        la2 = value;
    }



    public float getLo1() {
        return lo1;
    }

    public void setLo1(float value) {
        lo1 = value;
    }



    public float getLo2() {
        return lo2;
    }

    public void setLo2(float value) {
        lo2 = value;
    }



    public float getDx() {
        return dx;
    }

    public void setDx(float value) {
        dx = value;
    }



    public float getDy() {
        return dy;
    }

    public void setDy(float value) {
        dy = value;
    }



    public int getNx() {
        return nx;
    }

    public void setNx(int value) {
        nx = value;
    }



    public int getNy() {
        return ny;
    }

    public void setNy(int value) {
        ny = value;
    }



    public List<ncVariable> getVariables() {
        return variables;
    }

    public void setVariables(List<ncVariable> value) {
        variables = value;
    }
}
