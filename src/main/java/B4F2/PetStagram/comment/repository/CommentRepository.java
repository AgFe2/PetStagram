package B4F2.PetStagram.comment.repository;

import B4F2.PetStagram.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    //todo feed에 넘겨줄 리스트..에러 & 댓글 조회시 사용
//    @Query(value = "select comment c from c where c.feed_id = :id")
//    List<Comment> findCommentsFeedId(@Param("id") Long feedId);

//    @Query("select c from comment c where c.email = :email")
//    String findCommentsEmail(@Param("email") String email);


}
