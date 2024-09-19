package com.github.automatix.eurofarma_application.repositories;

import com.github.automatix.eurofarma_application.models.EuroUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface EuroUserRepository extends JpaRepository<EuroUser, Long> {
    Optional<EuroUser> findByEmail(String username);


    @Transactional
    @Modifying
    @Query("UPDATE EuroUser e SET e.enabled = TRUE WHERE e.email = :email")
    int enableEuroUser(@Param("email") String email);
}
