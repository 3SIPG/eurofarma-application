package com.github.automatix.eurofarma_application.services;

import com.github.automatix.eurofarma_application.models.EuroUser;
import com.github.automatix.eurofarma_application.repositories.EuroUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EuroUserService implements UserDetailsService {

    @Autowired
    private EuroUserRepository euroUserRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final String USER_NOT_FOUND_MESSAGE = "User not found with email address: %s";

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return euroUserRepository.findByEmail(s).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, s)));
    }

    public String signUp(EuroUser user) {
        boolean userExists = euroUserRepository.findByEmail(user.getEmail()).isPresent();

        if (userExists) {
            throw new IllegalStateException("User with this email already exists");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        euroUserRepository.save(user);
        //TODO: send confirmation token

        return "working signup";

    }

    public List<EuroUser> findAll(){
        return euroUserRepository.findAll();
    }
}
