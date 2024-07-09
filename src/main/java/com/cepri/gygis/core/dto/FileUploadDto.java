package com.cepri.gygis.core.dto;

import lombok.Data;

@Data
public class FileUploadDto {
    private String secretId;
    private String secretKey;
    private String sessionToken;
    private String bucket;
    private String region;
    private String key;
}
