package com.jason.sbrest.security;

import com.jason.sbrest.model.User;
import com.jason.sbrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            return userService.getUserByEmail(s);
        } catch (ResponseStatusException e) {
            throw new UsernameNotFoundException(e.getMessage(), e);
        }
    }
}
