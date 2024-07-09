package com.cepri.gygis.core.mapper;

import com.cepri.gygis.core.dto.FileUploadDto;
import com.cepri.gygis.core.vo.FileUploadVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileUploadMapper {
    FileUploadVo toVo(FileUploadDto fileUploadDto);
}
