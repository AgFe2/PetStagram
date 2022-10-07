package B4F2.PetStagram.feed.Like.repository;

import B4F2.PetStagram.feed.Like.Entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {

    Optional<LikeEntity> findByFeedIdAndUserId(Long feedId, String userId);
}
