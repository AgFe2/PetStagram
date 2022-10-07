package B4F2.PetStagram.board.service;

import B4F2.PetStagram.feed.domain.FeedDto;
import B4F2.PetStagram.feed.entity.FeedEntity;
import B4F2.PetStagram.feed.repository.FeedRepository;
import B4F2.PetStagram.follow.entity.Follow;
import B4F2.PetStagram.follow.repository.FollowRepository;
import B4F2.PetStagram.member.repository.MemberRepository;
import B4F2.PetStagram.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final FeedRepository feedRepository;

    private final MemberRepository memberRepository;

    private final FollowRepository followRepository;

    private final TagService tagService;

    public List<FeedEntity> myList(String userId, Pageable pageable) {
        return feedRepository.findByUserId(userId, pageable);
    }



    public List<FeedEntity> followingList(String email, Pageable pageable) {
        List<Follow> follows = followRepository.findByEmail(email, pageable);
        List<FeedEntity> result = new ArrayList<>();
        List<FeedEntity> feeds = new ArrayList<>();
        for (int i = 0; i < follows.size(); i++) {
            feeds = feedRepository.findByUserIdAndUpdateDitAfterOrderByUpdateDitDesc(follows.get(i).getFollowEmail(), LocalDateTime.now().minusDays(1));
            result.addAll(feeds);
        }
        return result;
    }

    public  List<FeedEntity> bestList(Pageable pageable) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime threeDays = now.minusDays(4);
        return feedRepository.findTop10AllByUpdateDitAfterOrderByLikeCntDesc(pageable, now);
    }
}
