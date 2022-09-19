package B4F2.PetStagram.follow.repository;

import B4F2.PetStagram.follow.entity.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingRepository extends JpaRepository<Following, Long> {
}
