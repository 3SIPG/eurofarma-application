package com.github.automatix.eurofarma_application.services;

import com.github.automatix.eurofarma_application.models.EuroUser;
import com.github.automatix.eurofarma_application.requests.RegisterRequest;
import com.github.automatix.eurofarma_application.validators.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {

    private EuroUserService euroUserService;

    private EmailValidator emailValidator;

    public String register(RegisterRequest request) {

        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("Invalid email");
        }

        return euroUserService.signUp(new EuroUser(request));
    }

}
