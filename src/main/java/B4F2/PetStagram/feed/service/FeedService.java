package B4F2.PetStagram.feed.service;

import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
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

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;

    private final MemberRepository memberRepository;

    private final TagService tagService;

    public FeedDto writeFeed(String text, String userId) {

        Member member = memberRepository.findByEmail(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        FeedDto feedDto = FeedDto.fromEntity(
                feedRepository.save(FeedEntity.builder()
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

    public boolean likeFeed(Long feedId) {
        FeedEntity feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

       feed.setLikeCnt(feed.getLikeCnt() + 1L);


        feedRepository.save(feed);

        return true;
    }

    public boolean unLikeFeed(Long feedId) {

        FeedEntity feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        Long likeCnt;

        //validation
        if (feed.getLikeCnt() < 0) {
            throw  new CustomException(ErrorCode.WRONG_APPROACH);
        } else {
            feed.setLikeCnt(feed.getLikeCnt() - 1L);
        }

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

    public FeedDto detailFeed(Long feedId) {

        FeedEntity feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        return FeedDto.fromEntity(feed);
    }
}
