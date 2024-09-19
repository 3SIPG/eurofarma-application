package com.github.automatix.eurofarma_application.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime expires;

    private LocalDateTime confirmed;

    @ManyToOne
    @JoinColumn(nullable = false, name = "euro_user_id")
    private EuroUser euroUser;


    public ConfirmationToken(String token, LocalDateTime created, LocalDateTime expires, LocalDateTime confirmed, EuroUser euroUser) {
        this.token = token;
        this.created = created;
        this.expires = expires;
        this.confirmed = confirmed;
        this.euroUser = euroUser;
    }
}
