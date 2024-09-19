package com.github.automatix.eurofarma_application.controllers;

import com.github.automatix.eurofarma_application.repositories.RegisterRepository;
import com.github.automatix.eurofarma_application.requests.RegisterRequest;
import com.github.automatix.eurofarma_application.services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/eurofarma/v1/register")
@AllArgsConstructor
public class RegisterController {

        @Autowired
        RegisterService registerService;

        public String register(@RequestBody RegisterRequest request){
            return registerService.register(request);
        }


}
