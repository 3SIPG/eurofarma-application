package com.github.automatix.eurofarma_application.repositories;

import com.github.automatix.eurofarma_application.validators.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
}
