package com.github.automatix.eurofarma_application.controllers;

import com.github.automatix.eurofarma_application.models.EuroUser;
import com.github.automatix.eurofarma_application.repositories.RegisterRepository;
import com.github.automatix.eurofarma_application.requests.RegisterRequest;
import com.github.automatix.eurofarma_application.services.EuroUserService;
import com.github.automatix.eurofarma_application.services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/eurofarma/v1/register")
@AllArgsConstructor
public class RegisterController {


        RegisterService registerService;

        EuroUserService euroUserService;

        @PostMapping
        public String register(@RequestBody RegisterRequest request){
            return registerService.register(request);
        }

        @GetMapping
        public List<EuroUser> findAll(){
                return euroUserService.findAll();
        }


}
