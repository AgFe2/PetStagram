package B4F2.PetStagram.comment.repository;

import B4F2.PetStagram.comment.entity.Comment;
import B4F2.PetStagram.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Member> findByEmailAndCommentId(String email, long commentId);

    //todo feed에 넘겨줄 리스트 & 댓글 조회시 사용..에러
//    @Query(value = "select comment c from c where c.feed_id = :id")
//    List<Comment> findCommentsByFeedId(@Param("id") Long feedId);


}
