package B4F2.PetStagram.email.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailConfirmToken  {

    private static final long EMAIL_TOKEN_EXPIRATION_TIME_VALUE = 5L;	//토큰 만료 시간

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    @Column
    private LocalDateTime expirationDate;

    @Column
    private boolean expired;

    //일부러 FK 사용 안함
    @Column
    private String email;

    /**
     * 이메일 인증 토큰 생성
     */
    public static EmailConfirmToken createEmailConfirmationToken(String email){
        EmailConfirmToken emailConfirmToken = new EmailConfirmToken();
        emailConfirmToken.expirationDate = LocalDateTime.now().plusMinutes(EMAIL_TOKEN_EXPIRATION_TIME_VALUE); // 5분후 만료
        emailConfirmToken.email = email;
        emailConfirmToken.expired = false;
        return emailConfirmToken;
    }

    /**
     * 토큰 사용으로 인한 만료
     */
    public void useToken(){
        expired = true;
    }
}