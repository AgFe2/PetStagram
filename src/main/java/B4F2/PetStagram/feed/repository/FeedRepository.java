package B4F2.PetStagram.feed.repository;

import B4F2.PetStagram.feed.entity.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends JpaRepository<FeedEntity, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Feed f set f.like = :likeCnt where f.id = :feedId")
    void likeFeed(Long likeCnt, Long feedId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Feed f set f.like = :likeCnt where f.id = :feedId")
    void unLikeFeed(Long likeCnt, Long feedId);
}
