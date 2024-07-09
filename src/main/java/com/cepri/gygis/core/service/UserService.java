package com.cepri.gygis.core.service;

import com.cepri.gygis.core.dto.TokenCreateRequest;
import com.cepri.gygis.core.dto.UserCreateRequest;
import com.cepri.gygis.core.dto.UserDto;
import com.cepri.gygis.core.dto.UserUpdateRequest;
import com.cepri.gygis.core.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    UserDto create(UserCreateRequest userCreateRequest);

    @Override
    User loadUserByUsername(String username) throws UsernameNotFoundException;

    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    Page<UserDto> search(Pageable pageable);

    String createToken(TokenCreateRequest tokenCreateRequest);

    UserDto getCurrentUser();
}
