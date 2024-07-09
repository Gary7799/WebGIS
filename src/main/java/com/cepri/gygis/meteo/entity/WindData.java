package com.cepri.gygis.meteo.entity;

import lombok.Data;

@Data
public class WindData {
    private WindDataHeader header;

    private float[] data;

}
