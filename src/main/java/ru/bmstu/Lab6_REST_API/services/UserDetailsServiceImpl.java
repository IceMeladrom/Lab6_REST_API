package ru.bmstu.Lab6_REST_API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.bmstu.Lab6_REST_API.entity.AuthUser;
import ru.bmstu.Lab6_REST_API.repository.AuthUserRepository;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserRepository.findByUsername(username);
        if (authUser == null)
            throw new UsernameNotFoundException("User not found");
        return new User(authUser.getUsername(), authUser.getPassword(), new ArrayList<>());
    }
}
