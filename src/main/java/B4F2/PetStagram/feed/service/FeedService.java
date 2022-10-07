package B4F2.PetStagram.feed.service;

import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.feed.Like.Entity.LikeEntity;
import B4F2.PetStagram.feed.Like.repository.LikeRepository;
import B4F2.PetStagram.feed.domain.DetailFeedRes;
import B4F2.PetStagram.feed.domain.FeedDto;
import B4F2.PetStagram.feed.domain.UpdateFeedReq;
import B4F2.PetStagram.feed.entity.FeedEntity;
import B4F2.PetStagram.feed.repository.FeedRepository;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import B4F2.PetStagram.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;
    private final LikeRepository likeRepository;
    private final MemberRepository memberRepository;

    private final TagService tagService;

    public FeedDto writeFeed(String text, String userId, Long fileId) {

        Member member = memberRepository.findByEmail(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        FeedDto feedDto = FeedDto.fromEntity(
                feedRepository.save(FeedEntity.builder()
                        .fileId(fileId)
                        .userId(userId)
                        .mainText(text)
                        .updateDit(LocalDateTime.now())
                        .likeCnt(0L)
                        .build())
        );

        tagService.regisTag(feedDto);

        return feedDto;

    }

    public boolean deleteFeed(Long feedId, String name) {

        FeedEntity feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        //validation
        if (!name.equals(feed.getUserId())) {
            throw new CustomException(ErrorCode.UN_MATCH_ID);
        }

        feedRepository.deleteById(feedId);

        return true;
    }

    public boolean likeFeed(Long feedId, HttpServletRequest request) {
        FeedEntity feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        feed.setLikeCnt(feed.getLikeCnt() + 1L);

        feedRepository.save(feed);
        likeRepository.save(LikeEntity.builder()
                .feedId(feedId)
                .userId((String) request.getAttribute("email"))
                .build());

        return true;
    }

    public boolean unLikeFeed(Long feedId, HttpServletRequest request) {

        FeedEntity feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        LikeEntity likeEntity = likeRepository.findByFeedIdAndUserId(feedId,
                        (String) request.getAttribute("email"))
                .orElseThrow(() -> new CustomException(ErrorCode.WRONG_APPROACH));
        //validation
        if (feed.getLikeCnt() < 0) {
            throw new CustomException(ErrorCode.WRONG_APPROACH);
        } else {
            feed.setLikeCnt(feed.getLikeCnt() - 1L);
        }

        likeRepository.delete(likeEntity);
        feedRepository.save(feed);

        return true;
    }

    public FeedDto updateFeed(UpdateFeedReq request, Long feedId, String email) {

        FeedEntity feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        if (!feed.getUserId().equals(email)) {
            throw new CustomException(ErrorCode.UN_MATCH_ID);
        }

        feed.setMainText(request.getMainText());
        feed.setUpdateDit(LocalDateTime.now());

        feedRepository.save(feed);

        return FeedDto.fromEntity(feed);

    }

    public DetailFeedRes detailFeed(Long feedId, HttpServletRequest request) {
        boolean likeCheck = false;

        FeedEntity feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        Optional<LikeEntity> likeEntity = likeRepository.findByFeedIdAndUserId(feedId,
                (String) request.getAttribute("email"));

        if (likeEntity.isPresent()) {
            likeCheck = true;
        }

        return DetailFeedRes.form(FeedDto.fromEntity(feed), likeCheck);
    }
}
