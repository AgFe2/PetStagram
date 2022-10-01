package B4F2.PetStagram.feed.repository;

import B4F2.PetStagram.feed.Like.Entity.LikeEntity;
import B4F2.PetStagram.feed.entity.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepository extends JpaRepository<FeedEntity, Long> {
}
