package com.github.automatix.eurofarma_application.services;

import com.github.automatix.eurofarma_application.models.ConfirmationToken;
import com.github.automatix.eurofarma_application.models.EuroUser;
import com.github.automatix.eurofarma_application.requests.RegisterRequest;
import com.github.automatix.eurofarma_application.validators.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegisterService {

    private final ConfirmationTokenService confirmationTokenService;
    private EuroUserService euroUserService;

    private EmailValidator emailValidator;

    public String register(RegisterRequest request) {

        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("Invalid email");
        }

        return euroUserService.signUp(new EuroUser(request));
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getConfirmationToken(token).orElseThrow(() -> new IllegalStateException("Invalid token"));

        if(confirmationToken.getConfirmed() != null){
            throw new IllegalStateException("Confirmation token is already confirmed");
        }

        LocalDateTime expiresAt = confirmationToken.getExpires();

        if(expiresAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Confirmation token is expired");
        }

        confirmationTokenService.setConfirmed(token);
        euroUserService.enableEuroUser(confirmationToken.getEuroUser());
        return "confirmed";

    }

}
