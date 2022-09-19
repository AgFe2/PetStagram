package B4F2.PetStagram.feed.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    private Long memberId;

    private String name;
    private String password;
    private String email;
    private String followingList;
    private String followerList;
    private LocalDateTime regDt;

}
