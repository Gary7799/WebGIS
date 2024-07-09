package com.cepri.gygis.repository;

import com.cepri.gygis.core.entity.User;
import com.cepri.gygis.core.enums.Gender;
import com.cepri.gygis.core.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByUsername() {
        User user = new User();
        user.setUsername("gy");
        user.setNickname("gary79");
        user.setPassword("123456");
        user.setEnabled(true);
        user.setLocked(false);
        user.setGender(Gender.FEMALE);

        user.setLastLoginIp("127.0.0.1");
        user.setLastLoginTime(new Date());

        User save = userRepository.save(user);

        System.out.println(save.toString());
    }
}