package B4F2.PetStagram.follow.repository;

import B4F2.PetStagram.follow.entity.FollowerCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerCountRepository extends JpaRepository<FollowerCount, Long> {
    FollowerCount findByEmail(String email);
}
