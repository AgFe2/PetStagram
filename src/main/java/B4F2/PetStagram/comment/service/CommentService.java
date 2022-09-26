package B4F2.PetStagram.comment.service;

import B4F2.PetStagram.comment.entity.Comment;
import B4F2.PetStagram.comment.model.CommentSaveDto;
import B4F2.PetStagram.comment.repository.CommentRepository;
import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.feed.entity.FeedEntity;
import B4F2.PetStagram.feed.repository.FeedRepository;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final FeedRepository feedRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Comment saveComment(Long feedId, CommentSaveDto commentSaveDto, String email) {
        feedRepository.findById(feedId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        return commentRepository.save(Comment.from(commentSaveDto, feedId, email));
    }


    @Transactional
    public boolean commentDelete(Long commentId, String email) {

        commentRepository.findById(commentId).orElseThrow(
                () -> new CustomException(ErrorCode.COMMENT_NOT_FOUND)).getEmail().equals(email);

        commentRepository.deleteById(commentId);

        return true;
    }

}
