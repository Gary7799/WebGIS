package com.cepri.gygis.core.entity;

import com.cepri.gygis.core.enums.FileStatus;
import com.cepri.gygis.core.enums.FileType;
import com.cepri.gygis.core.enums.Storage;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class File extends BaseEntity {
    private String name;

    private String ext;

    private String key;

    private Integer size;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    @Enumerated(EnumType.STRING)
    private Storage storage;

    @Enumerated(EnumType.STRING)
    private FileStatus fileStatus;
}
