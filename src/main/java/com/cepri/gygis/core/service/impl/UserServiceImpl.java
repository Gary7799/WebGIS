package com.cepri.gygis.core.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cepri.gygis.core.config.SecurityConfig;
import com.cepri.gygis.core.dto.TokenCreateRequest;
import com.cepri.gygis.core.dto.UserCreateRequest;
import com.cepri.gygis.core.dto.UserDto;
import com.cepri.gygis.core.dto.UserUpdateRequest;
import com.cepri.gygis.core.entity.User;
import com.cepri.gygis.core.exception.BizException;
import com.cepri.gygis.core.exception.ExceptionType;
import com.cepri.gygis.core.mapper.UserMapper;
import com.cepri.gygis.core.repository.UserRepository;
import com.cepri.gygis.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserMapper mapper;

    PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(UserCreateRequest userCreateRequest) {
        checkUserName(userCreateRequest.getUsername());
        User user = mapper.createEntity(userCreateRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto get(String id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return mapper.toDto(user.get());
    }

    @Override
    public UserDto update(String id, UserUpdateRequest userUpdateRequest) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return mapper.toDto(userRepository.save(mapper.updateEntity(user.get(), userUpdateRequest)));
    }

    @Override
    public void delete(String id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        userRepository.delete(user.get());
    }

    @Override
    public Page<UserDto> search(Pageable pageable) {
        return userRepository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public String createToken(TokenCreateRequest tokenCreateRequest) {
        User user = loadUserByUsername(tokenCreateRequest.getUsername());
        if (!passwordEncoder.matches(tokenCreateRequest.getPassword(), user.getPassword())) {
            throw new BizException(ExceptionType.USER_PASSWORD_NOT_MATCH);
        }
        if (!user.isEnabled()) {
            throw new BizException(ExceptionType.USER_NOT_ENABLED);
        }
        if (!user.isAccountNonLocked()) {
            throw new BizException(ExceptionType.USER_LOCKED);
        }

        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes()));
    }

    @Override
    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = loadUserByUsername(authentication.getName());
        return mapper.toDto(currentUser);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }

    private void checkUserName(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }

    @Autowired
    private void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private void setUserMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    private void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
