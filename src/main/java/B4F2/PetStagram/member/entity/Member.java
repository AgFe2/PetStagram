package B4F2.PetStagram.member.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberId;
    private String name;
    private String password;
    private String phone;

    private LocalDate regDt;

    private boolean emailAuthYn;

    public void emailVerifiedSuccess() {
        this.emailAuthYn = true;
    }
}