package B4F2.PetStagram.feed.repository;

import B4F2.PetStagram.feed.model.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    Optional<Hashtag> findAllByHashtagContext(String hashtagContext);
}
