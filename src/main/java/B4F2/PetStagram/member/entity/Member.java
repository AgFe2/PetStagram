package B4F2.PetStagram.member.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
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

    public void emailVerifiedSuccess() {
        this.emailAuthYn = true;
    }
}
