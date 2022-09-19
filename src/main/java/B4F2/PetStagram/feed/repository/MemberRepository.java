package B4F2.PetStagram.feed.repository;

import B4F2.PetStagram.feed.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findAllByMemberId(Long memberId);

    List<Member> findByMemberIdStartingWithIgnoreCase(Long memberId);
}
