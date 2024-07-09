package com.cepri.gygis.core.mapper;

import com.cepri.gygis.core.dto.UserCreateRequest;
import com.cepri.gygis.core.dto.UserDto;
import com.cepri.gygis.core.dto.UserUpdateRequest;
import com.cepri.gygis.core.entity.User;
import com.cepri.gygis.core.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateRequest);

    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
