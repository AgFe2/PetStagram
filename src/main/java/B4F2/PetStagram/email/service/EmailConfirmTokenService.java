package B4F2.PetStagram.email.service;

import B4F2.PetStagram.email.entity.EmailConfirmToken;
import B4F2.PetStagram.email.repository.EmailConfirmTokenRepository;
import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmailConfirmTokenService {
    private final EmailConfirmTokenRepository emailConfirmTokenRepository;
    private final EmailService emailService;

    /**
     * 이메일 인증 토큰 생성
     */
    public String createEmailConfirmationToken(String userId) {

        Assert.hasText(userId, "userId는 필수 입니다.");

        EmailConfirmToken emailConfirmToken = EmailConfirmToken.createEmailConfirmationToken(userId);
        emailConfirmTokenRepository.save(emailConfirmToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userId);
        mailMessage.setSubject("회원가입 이메일 인증");
        mailMessage.setText("http://localhost:8080/confirm-email?token=" + emailConfirmToken.getId());
        emailService.sendEmail(mailMessage);

        return emailConfirmToken.getId();
    }

    /**
     * 유효한 토큰 가져오기
     */
    public EmailConfirmToken findByIdAndExpirationDateAfterAndExpired(String confirmationTokenId) {
        Optional<EmailConfirmToken> optionalEmailConfirmToken =
                emailConfirmTokenRepository.findByIdAndExpirationDateAfterAndExpired(confirmationTokenId, LocalDateTime.now(), false);
        if (!optionalEmailConfirmToken.isPresent()) {
            throw new CustomException(ErrorCode.EMAIL_AUTH_FAIL);
        }
        
        return optionalEmailConfirmToken.get();
        
    }


    /**
     * 토큰 사용으로 인한 만료
     */
    public void expireToken(EmailConfirmToken emailConfirmToken) {
        emailConfirmToken.useToken();
        emailConfirmTokenRepository.save(emailConfirmToken);
    }
}
