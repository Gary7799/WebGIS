package com.cepri.gygis.meteo.entity;

import lombok.Data;

@Data
public class ncVariable {
    private String standardName;

    private String longName;

    private String units;

    private String tiffPath;

    private double valueMax;

    private double valueMin;

}
