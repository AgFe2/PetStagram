package B4F2.PetStagram.feed.service;

import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.feed.domain.WriteFeed;
import B4F2.PetStagram.feed.entity.FeedEntity;
import B4F2.PetStagram.feed.repository.FeedRepository;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import B4F2.PetStagram.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;

    private final MemberRepository memberRepository;

    private final TagService tagService;

    public WriteFeed.Response writeFeed(WriteFeed.Request writeFeed, String userId) {

        Member member = memberRepository.findByEmail(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        FeedEntity feed = feedRepository.save(writeFeed.toEntity(userId));

        tagService.regisTag(feed);

        return new WriteFeed.Response(userId, writeFeed.getMainText());
    }

    public boolean deleteFeed(Long feedId, String name) {

        feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        feedRepository.deleteById(feedId);

        return true;
    }

    public boolean likeFeed(Long feedId) {
        FeedEntity feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

       feed.setLike(feed.getLike() + 1L);

        feedRepository.save(feed);

        return true;
    }

    public boolean unLikeFeed(Long feedId) {

        FeedEntity feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        Long likeCnt;

        if (feed.getLike() < 0) {
            throw  new CustomException(ErrorCode.WRONG_APPROACH);
        } else {
            feed.setLike(feed.getLike() - 1L);
        }

       feedRepository.save(feed);

        return true;
    }
}
