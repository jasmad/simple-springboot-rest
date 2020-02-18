package com.jason.sbrest.service.impl;

import com.jason.sbrest.model.User;
import com.jason.sbrest.model.UserBody;
import com.jason.sbrest.repository.UserRepository;
import com.jason.sbrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUserDetailsList(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not found user " + userId));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not found user " + email));
    }

    @Override
    public User saveUser(UserBody user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());

        newUser.setPassword(encoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        return userRepository.save(newUser);
    }


}
