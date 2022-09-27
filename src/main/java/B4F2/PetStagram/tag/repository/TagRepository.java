package B4F2.PetStagram.tag.repository;

import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.tag.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {

    List<TagEntity> findAllByTagTitleContains(String tagTitle);


}
