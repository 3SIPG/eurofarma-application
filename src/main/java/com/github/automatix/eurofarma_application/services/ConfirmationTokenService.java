package com.github.automatix.eurofarma_application.services;

import com.github.automatix.eurofarma_application.models.ConfirmationToken;
import com.github.automatix.eurofarma_application.repositories.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    @Autowired
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }

    public List<ConfirmationToken> getConfirmationTokens(){
        return confirmationTokenRepository.findAll();
    }

    public Optional<ConfirmationToken> getConfirmationToken(String token){
        return confirmationTokenRepository.findByToken(token);
    }

    public void setConfirmed(String token){
        confirmationTokenRepository.setConfirmed(LocalDateTime.now(), token);

    }
}
