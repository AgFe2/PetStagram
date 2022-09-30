package B4F2.PetStagram.follow.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
//@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class FollowingCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String email;
    Integer followingCount;
}
