package B4F2.PetStagram.comment.service;

import B4F2.PetStagram.comment.entity.Comment;
import B4F2.PetStagram.comment.model.CommentDto;
import B4F2.PetStagram.comment.model.CommentSaveDto;
import B4F2.PetStagram.comment.repository.CommentRepository;
import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.feed.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


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
    public boolean commentDelete(Long feedId, Long commentId, String email) {

        feedRepository.findById(feedId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        commentRepository.findById(commentId).orElseThrow(
                () -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));

        //todo 작성자 동일인 비교
        if (!email.equals(commentRepository.findByEmailAndCommentId(email,commentId).get().getEmail())) {
            throw new CustomException(ErrorCode.COMMENT_DELETE_UNAUTHORIZED);
        }

        commentRepository.deleteById(commentId);

        return true;
    }



    public Slice<Comment> findAll(Pageable pageable, Long feedId) {

     return commentRepository.findAllByFeedIdOrderByCommentIdDesc(feedId,pageable);
    }
}
