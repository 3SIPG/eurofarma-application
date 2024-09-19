package com.github.automatix.eurofarma_application.services;

import com.github.automatix.eurofarma_application.repositories.RegisterRepository;
import com.github.automatix.eurofarma_application.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    public String register(RegisterRequest request) {

        return "working";
    }

}
