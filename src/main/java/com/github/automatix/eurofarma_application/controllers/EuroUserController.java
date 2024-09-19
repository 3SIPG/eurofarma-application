package com.github.automatix.eurofarma_application.controllers;

import com.github.automatix.eurofarma_application.models.ConfirmationToken;
import com.github.automatix.eurofarma_application.models.EuroUser;
import com.github.automatix.eurofarma_application.requests.RegisterRequest;
import com.github.automatix.eurofarma_application.services.ConfirmationTokenService;
import com.github.automatix.eurofarma_application.services.EuroUserService;
import com.github.automatix.eurofarma_application.services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/eurofarma/v1/users")
@AllArgsConstructor
public class EuroUserController {

    private final EuroUserService euroUserService;

    @GetMapping
    public List<EuroUser> findAll() {
        return euroUserService.findAll();
    }

}
