package B4F2.PetStagram.follow.repository;

import B4F2.PetStagram.follow.entity.FollowingCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingCountRepository extends JpaRepository<FollowingCount, Long> {
    FollowingCount findByEmail(String email);
}
