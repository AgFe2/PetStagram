package B4F2.PetStagram.feed.service;

import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeedService {

/*    private final FeedRepository feedRepository;
    private final FollowRepository followRepository;

    public Optional<Feed> myList(String email) {
        return feedRepository.findByEmail(email);
    }

    public Optional<Feed> followingList(String email) {
        Optional<Follow> follows = followRepository.findFollowIdByEmail(email);
        return feedRepository.findByFollowId(follows);
    }

    public Optional<Feed> bestList() {

    }*/

}
