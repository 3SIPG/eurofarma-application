package com.github.automatix.eurofarma_application.controllers;

import com.github.automatix.eurofarma_application.requests.RegisterRequest;
import com.github.automatix.eurofarma_application.services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/eurofarma/v1/register")
@AllArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping
    public String register(@RequestBody RegisterRequest request) {
        return registerService.register(request);
    }


    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registerService.confirmToken(token);
    }

}
