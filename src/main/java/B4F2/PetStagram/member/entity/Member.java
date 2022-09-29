package B4F2.PetStagram.member.entity;

import B4F2.PetStagram.member.domain.SignInForm;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String email;
    private String phone;
    private LocalDateTime regDt;
    private boolean emailAuthYn;



    public Member(SignInForm form) {
        this.email = form.getEmail();
        this.password = form.getPassword();
    }

    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void emailVerifiedSuccess() {
        this.emailAuthYn = true;
    }

}
