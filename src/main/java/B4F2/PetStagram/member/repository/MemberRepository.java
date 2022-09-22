package B4F2.PetStagram.member.repository;

import B4F2.PetStagram.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    //todo
    Optional<Member> findByIdAndEmail(String email, Long id);


    boolean existsByEmail(String email);

    List<Member> findAllByEmailContains(String email);


}
