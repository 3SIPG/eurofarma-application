package com.github.automatix.eurofarma_application.services;

import com.github.automatix.eurofarma_application.repositories.EuroUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EuroUserService implements UserDetailsService {

    @Autowired
    private EuroUserRepository userRepository;

    private final String USER_NOT_FOUND_MESSAGE = "User not found with email address: %s";

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, s)));
    }
}
