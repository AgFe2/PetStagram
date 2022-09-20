package B4F2.PetStagram.follow.service;

import B4F2.PetStagram.follow.entity.Follow;
import B4F2.PetStagram.follow.repository.FollowRepository;
import B4F2.PetStagram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;
    private final MemberRepository memberRepository;

    /**
     * 팔로우
     */
    public void addAndDeleteFollow(String email, String followEmail) {
        // 상대가 가입된 회원인지 확인
        if (!memberRepository.existsByEmail(followEmail)) {
            return;
        }

        // 이미 팔로우 되어 있다면 취소
        if (followRepository.existsByEmailAndFollowEmail(email, followEmail)) {
            deleteFollow(email, followEmail);
            return;
        }

        Follow follow = Follow.builder()
                .email(email)
                .followEmail(followEmail)
                .build();

        followRepository.save(follow);
    }

    /**
     * 팔로우 취소
     */
    private void deleteFollow(String email, String followEmail) {
        Follow follow = followRepository.findByEmailAndFollowEmail(email, followEmail);

        followRepository.delete(follow);
    }

    /**
     * 팔로잉 회원 리스트
     */
    public List<String> checkFollowing(String email) {
        List<String> result = new ArrayList<>();
        followRepository.findByEmail(email).forEach(e -> result.add(e.getFollowEmail()));
        return result;
    }

    /**
     * 팔로워 회원 리스트
     */
    public List<String> checkFollower(String email) {
        List<String> result = new ArrayList<>();
        followRepository.findByFollowEmail(email).forEach(e -> result.add(e.getEmail()));
        return result;
    }
}
