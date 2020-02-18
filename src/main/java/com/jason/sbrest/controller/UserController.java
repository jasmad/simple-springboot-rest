package com.jason.sbrest.controller;

import com.jason.sbrest.model.User;
import com.jason.sbrest.model.UserBody;
import com.jason.sbrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> userDetailsList (Pageable pageable) {
        return userService.getUserDetailsList(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User userDetailsList (@PathVariable("id") long userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<User> createUser (@RequestBody @Valid UserBody user) {
        User createdUser = userService.saveUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}
