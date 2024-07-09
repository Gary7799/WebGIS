package com.cepri.gygis.meteo.entity;


public class jsonMeta {
    public jsonMeta() {
        resultCode = 0;
        jsonPath = null;
    }

    private int resultCode;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int value) {
        this.resultCode = value;
    }

    private String jsonPath;

    public String getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(String value) {
        this.jsonPath = value;
    }
}
