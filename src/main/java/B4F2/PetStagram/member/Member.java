package B4F2.PetStagram.member;

import lombok.*;

import javax.persistence.Entity;
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
    private String memberId;

    private String name;
    private String password;
    private String phone;

    private LocalDate regDt;

    private String followingList;
    private String followerList;

    private String emailAuthKey;
    private boolean emailAuthYn;
}