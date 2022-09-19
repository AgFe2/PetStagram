package B4F2.PetStagram.follow.repository;

import B4F2.PetStagram.follow.entity.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {
}
