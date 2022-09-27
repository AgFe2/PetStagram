package B4F2.PetStagram.member.repository;

import B4F2.PetStagram.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    Optional<Member> findByEmail(String email);

    //todo
    Optional<Member> findByIdAndEmail(String email, Long id);


    boolean existsByEmail(String email);



/*    String subStringQuery = "DECLARE @str VARCHAR(255) SELECT SUBSTRING(@str, CHARINDEX('@', @str) + 1, LEN(@str)) as email from Member";

    List<String> subStringResult = em.createQuery(subStringQuery, String.class).getResultList();

    for(String s : subStringResult) {
        System.out.println("s = "+s);
    }*/


    List<Member> findAllByEmailContains(String email);

    List<Member> searchByEmail(String keyword);


}
