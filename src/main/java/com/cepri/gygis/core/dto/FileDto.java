package com.cepri.gygis.core.dto;

import com.cepri.gygis.core.enums.FileStatus;
import com.cepri.gygis.core.enums.FileType;
import com.cepri.gygis.core.enums.Storage;
import lombok.Data;

import java.util.Date;

@Data
public class FileDto {
    private String id;

    private String name;

    private String ext;

    private Integer size;

    private String key;

    private FileType fileType;

    private Storage storage;

    private FileStatus fileStatus;

    private Date createdTime;

    private Date updatedTime;
}
