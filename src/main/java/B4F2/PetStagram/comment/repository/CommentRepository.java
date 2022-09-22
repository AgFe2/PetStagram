package B4F2.PetStagram.comment.repository;

import B4F2.PetStagram.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    //피드아이디 기준으로 피드에딸려있는 코멘트 리스트 불러오는 쿼리문
}
