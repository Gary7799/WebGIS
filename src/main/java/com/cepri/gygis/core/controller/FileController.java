package com.cepri.gygis.core.controller;

import com.cepri.gygis.core.dto.FileUploadRequest;
import com.cepri.gygis.core.mapper.FileUploadMapper;
import com.cepri.gygis.core.service.FileService;
import com.cepri.gygis.core.vo.FileUploadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/files")
public class FileController {

    FileService fileService;

    FileUploadMapper fileUploadMapper;

    @PostMapping("/upload/init")
    public FileUploadVo initUpload(@Validated @RequestBody FileUploadRequest fileUploadRequest) {
        return fileUploadMapper.toVo(fileService.initUpload(fileUploadRequest));
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setFileUploadMapper(FileUploadMapper fileUploadMapper) {
        this.fileUploadMapper = fileUploadMapper;
    }
}
