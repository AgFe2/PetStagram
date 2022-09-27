package B4F2.PetStagram.comment.repository;

import B4F2.PetStagram.comment.entity.Comment;
import B4F2.PetStagram.comment.model.CommentDto;
import B4F2.PetStagram.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Member> findByEmailAndCommentId(String email, Long commentId);


    Slice<Comment> findAllByFeedIdOrderByCommentIdDesc(Long feedId, Pageable pageable);
//    Slice<Comment> findAllByFeedIdOrderByCommentIdDesc(@Param("feedId") Long feedId, Pageable pageable);


}
