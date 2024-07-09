package com.cepri.gygis.core.service;

import com.cepri.gygis.core.dto.FileUploadDto;
import com.cepri.gygis.core.dto.FileUploadRequest;

public interface FileService {
    FileUploadDto initUpload(FileUploadRequest fileUploadRequest);
}
