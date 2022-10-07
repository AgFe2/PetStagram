package B4F2.PetStagram.feed.repository;

import B4F2.PetStagram.feed.Like.Entity.LikeEntity;
import B4F2.PetStagram.feed.entity.FeedEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FeedRepository extends JpaRepository<FeedEntity, Long> {

    List<FeedEntity> findTop2ByUserIdOrderByUpdateDitDesc(String email);

    List<FeedEntity> findByUserId(String userId, Pageable pageable);

    List<FeedEntity> findTop10AllByUpdateDitAfterOrderByLikeCntDesc(Pageable pageable, LocalDateTime threeDays);

    List<FeedEntity> findByUserIdAndUpdateDitAfterOrderByUpdateDitDesc(String userId,LocalDateTime yesterday);
}
