package B4F2.PetStagram.tag.repository;

import B4F2.PetStagram.tag.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {

    List<TagEntity> findAllByTagTitleContains(String tagTitle);

}
