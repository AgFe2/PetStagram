package B4F2.PetStagram.member.entity;

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

    private Integer followerCount;
    private Integer followingCount;

    public void emailVerifiedSuccess() {
        this.emailAuthYn = true;
    }

}
