package com.github.automatix.eurofarma_application.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender{


    private final JavaMailSender mailSender;

    private static final Logger LOGGER = Logger.getLogger(EmailService.class.getName());


    @Override
    public void send(String to, String email) {

    }


}
