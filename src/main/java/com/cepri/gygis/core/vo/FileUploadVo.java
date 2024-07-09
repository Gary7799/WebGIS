package com.cepri.gygis.core.vo;

import lombok.Data;

@Data
public class FileUploadVo {
    private String secretId;
    private String secretKey;
    private String sessionToken;
    private String bucket;
    private String region;
    private String key;
}
