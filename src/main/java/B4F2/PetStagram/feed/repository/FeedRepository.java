package B4F2.PetStagram.feed.repository;

import B4F2.PetStagram.feed.domain.FeedDto;
import B4F2.PetStagram.feed.entity.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedRepository extends JpaRepository<FeedEntity, Long> {

    List<FeedEntity> findTop2ByUserIdOrderByUpdateDitDesc(String email);

    Optional<FeedEntity> findByUserId(String userId);

    List<FeedEntity> findTop10AllByOrderByLikeCntDesc();

}
