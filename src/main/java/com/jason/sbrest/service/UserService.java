package com.jason.sbrest.service;

import com.jason.sbrest.model.User;
import com.jason.sbrest.model.UserBody;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getUserDetailsList(Pageable pageable);

    User getUserById(Long userId);
    User getUserByEmail(String email);

    User saveUser(UserBody user);
}
