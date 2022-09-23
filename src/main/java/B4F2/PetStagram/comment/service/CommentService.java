package B4F2.PetStagram.comment.service;

import B4F2.PetStagram.comment.entity.CommentEntity;
import B4F2.PetStagram.comment.model.CommentSaveDto;
import B4F2.PetStagram.comment.repository.CommentRepository;
import B4F2.PetStagram.feed.repository.FeedRepository;
import B4F2.PetStagram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final FeedRepository feedRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public CommentEntity saveComment(Long feedId, CommentSaveDto commentSaveDto){

        return commentRepository.save(CommentEntity.from(commentSaveDto, feedId));
    }


    @Transactional
    public void commentDelete(Long id){
        commentRepository.deleteById(id);
    }

//    @Transactional
//    public Long saveComment(String email, Long feedId, CommentRequestDto dto){
//        Optional<Member> optionalMember = memberRepository.findByEmail(email);
//        Long feedId = feedRepository.findById(feedId).orElseThrow(
//                () -> new IllegalArgumentException("해당 게시물이 존재하지안습니다"));
//
//        dto.setEmail(email);
//        dto.setFeed(feed);
//
//        Comment comment = dto.toEntity();
//        commentRepository.save(comment);
//
//        return dto.getId();
//    }

//    public WriteComment.Response writeComment(WriteComment.Request writeComment, String memberId, String feedId){
//        Member member = memberRepository.findByEmail(memberId)
//                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
//
//        commentRepository.save(writeComment.toEntity(memberId, feedId));
//
//        return new WriteComment.Response(memberId, writeComment.getContext());
//    }
}
