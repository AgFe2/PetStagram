package B4F2.PetStagram.follow.service;

import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.follow.entity.Follow;
import B4F2.PetStagram.follow.repository.FollowRepository;
import B4F2.PetStagram.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;
    private final MemberService memberService;

    /**
     * 팔로우
     */
    public void addFollow(Follow follow) {
        followRepository.save(follow);
        memberService.increaseFollowerCount(follow.getFollowEmail());
        memberService.increaseFollowingCount(follow.getEmail());
    }

    /**
     * 팔로우가 되어 있는지 확인
     */
    public boolean isFollowed(Follow follow) {
        return followRepository.existsByEmailAndFollowEmail(follow.getEmail(), follow.getFollowEmail());
    }

    /**
     * 팔로우 취소
     */
    public void UnFollow(Follow follow) {
        Follow findDeleteFollow = followRepository.findByEmailAndFollowEmail(follow.getEmail(), follow.getFollowEmail());
        followRepository.delete(findDeleteFollow);
        memberService.decreaseFollowerCount(follow.getFollowEmail());
        memberService.decreaseFollowingCount(follow.getEmail());
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

    /**
     * 팔로우 기능 실행
     * 팔로우 안했으면 팔로우
     * 팔로우 되어있으면 언팔로우
     */
    public String doFollow(Follow follow) {
        // 상대가 가입된 회원인지 확인
        if (!memberService.isMember(follow.getFollowEmail())) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        // 이미 팔로우가 되어 있다면 취소
        if (isFollowed(follow)) {
            UnFollow(follow);
            return "팔로우 취소 완료";
        }

        // 팔로우가 안되어 있다면 등록
        addFollow(follow);
        return "팔로우 완료";
    }
}
