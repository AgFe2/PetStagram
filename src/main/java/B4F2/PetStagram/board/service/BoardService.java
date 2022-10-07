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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final FeedRepository feedRepository;

    private final MemberRepository memberRepository;

    private final FollowRepository followRepository;

    private final TagService tagService;



    public Optional<FeedEntity> myList(String userId) {
        return feedRepository.findByUserId(userId);
    }



    public List<FeedEntity> followingList(String email) {
        List<Follow> follows = followRepository.findByEmail(email);
        List<FeedEntity> result = new ArrayList<>();
        List<FeedEntity> feeds = new ArrayList<>();
        for (int i = 0; i < follows.size(); i++) {
            feeds = feedRepository.findTop2ByUserIdOrderByUpdateDitDesc(follows.get(i).getFollowEmail());
            result.addAll(feeds);
        }
        return result;
    }

    public  List<FeedEntity> bestList() {
        return feedRepository.findTop10AllByOrderByLikeCntDesc();
    }
}
