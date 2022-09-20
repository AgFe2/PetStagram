package B4F2.PetStagram.feed.service;

import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.feed.domain.WriteFeed;
import B4F2.PetStagram.feed.entity.FeedEntity;
import B4F2.PetStagram.feed.repository.FeedRepository;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;

    private final MemberRepository memberRepository;
    public WriteFeed.Response writeFeed(WriteFeed.Request writeFeed, String userId) {

        Member member = memberRepository.findByEmail(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        feedRepository.save(writeFeed.toEntity(userId));

        return new WriteFeed.Response(userId, writeFeed.getMainText());
    }

    public boolean likeFeed(Long feedId) {
        FeedEntity feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        Long likeCnt = feed.getLike() + 1L;

        feedRepository.likeFeed(likeCnt,feedId);

        return true;
    }

    public boolean unLikeFeed(Long feedId) {

        FeedEntity feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD));

        Long likeCnt;

        if (feed.getLike() < 0) {
            throw  new CustomException(ErrorCode.WRONG_APPROACH);
        } else {
            likeCnt = feed.getLike() - 1L;
        }

        feedRepository.unLikeFeed(likeCnt,feedId);

        return true;
    }
}