package B4F2.PetStagram.comment.service;

import B4F2.PetStagram.comment.entity.Comment;
import B4F2.PetStagram.comment.model.CommentRequestDto;
import B4F2.PetStagram.comment.model.CommentSaveDto;
import B4F2.PetStagram.comment.repository.CommentRepository;
import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.feed.entity.Feed;
import B4F2.PetStagram.feed.repository.FeedRepository;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import B4F2.PetStagram.member.util.domainChanger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

//    private final CommentRepository commentRepository;
//    private final MemberRepository memberRepository;
//    private final FeedRepository feedRepository;

//    @Transactional(isolation = Isolation.SERIALIZABLE)
//    public Comment saveComment(CommentSaveDto commentSaveDto){
//
//        return commentRepository.save(Comment.from(commentSaveDto));
//    }

//    @Transactional
//    public Long saveComment(String email, Long id, CommentRequestDto dto){
//        Optional<Member> optionalMember = memberRepository.findByEmail(email);
//        Feed feed = feedRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("해당 게시물이 존재하지안습니다"));
//
//        Member member = domainChanger.optionalMemberToMember(optionalMember);
//
//        dto.setEmail(email);
//        dto.setFeed(feed);
//
//        Comment comment = dto.toEntity();
//        commentRepository.save(comment);
//
//        return dto.getId();
        //여길 String saveComment로 바꾸고 redirecct:/?
        //그럼 멤버랑 피드 id가...
    }

//    public WriteComment.Response writeComment(WriteComment.Request writeComment, String memberId, String feedId){
//        Member member = memberRepository.findByEmail(memberId)
//                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
//
//        commentRepository.save(writeComment.toEntity(memberId, feedId));
//
//        return new WriteComment.Response(memberId, writeComment.getContext());
//
//    }
}
