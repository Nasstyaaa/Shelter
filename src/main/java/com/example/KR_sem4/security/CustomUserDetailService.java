package com.example.KR_sem4.security;

import com.example.KR_sem4.entity.User;
import com.example.KR_sem4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(username);

        return user.map(CustomUserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + "There is not such user in REPO"));
    }
}