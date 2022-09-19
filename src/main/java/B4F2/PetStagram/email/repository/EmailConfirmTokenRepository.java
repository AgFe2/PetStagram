package B4F2.PetStagram.email.repository;

import B4F2.PetStagram.email.entity.EmailConfirmToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface EmailConfirmTokenRepository extends JpaRepository<EmailConfirmToken,String> {
    Optional<EmailConfirmToken> findByIdAndExpirationDateAfterAndExpired(String emailConfirmTokenId, LocalDateTime now, boolean expired);
}