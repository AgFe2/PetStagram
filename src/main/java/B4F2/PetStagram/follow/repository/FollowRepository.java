package B4F2.PetStagram.follow.repository;

import B4F2.PetStagram.follow.entity.Follow;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    boolean existsByEmailAndFollowEmail(String email, String followEmail);

    Follow findByEmailAndFollowEmail(String email, String followEmail);

    List<Follow> findByEmail(String email, Pageable pageable);

    List<Follow> findByEmail(String email);

    List<Follow> findByFollowEmail(String email);

}
