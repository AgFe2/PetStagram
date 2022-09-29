package B4F2.PetStagram.follow.service;

import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.follow.entity.Follow;
import B4F2.PetStagram.follow.entity.FollowerCount;
import B4F2.PetStagram.follow.entity.FollowingCount;
import B4F2.PetStagram.follow.repository.FollowRepository;
import B4F2.PetStagram.follow.repository.FollowerCountRepository;
import B4F2.PetStagram.follow.repository.FollowingCountRepository;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;
    private final FollowingCountRepository followingCountRepository;
    private final FollowerCountRepository followerCountRepository;
    private final MemberRepository memberRepository;

    /**
     * 팔로우
     */
    public void addFollow(Follow follow) {
        followRepository.save(follow);
        increaseFollowerCount(follow.getFollowEmail());
        increaseFollowingCount(follow.getEmail());
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
        decreaseFollowerCount(follow.getFollowEmail());
        decreaseFollowingCount(follow.getEmail());
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
        if (!memberRepository.existsByEmail(follow.getFollowEmail())) {
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

    /**
     * follower, following count 테이블 생성
     */
    public void createFollowCount(Member member) {
        FollowerCount followerCount = FollowerCount.builder()
                .email(member.getEmail())
                .followerCount(0)
                .build();
        followerCountRepository.save(followerCount);

        FollowingCount followingCount = FollowingCount.builder()
                .email(member.getEmail())
                .followingCount(0)
                .build();
        followingCountRepository.save(followingCount);
    }

    /**
     * 팔로우 인원 증가
     */
    public void increaseFollowerCount(String followEmail) {
        Optional<Member> optionalMember = memberRepository.findByEmail(followEmail);

        if (!optionalMember.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        FollowerCount followerCount = followerCountRepository.findByEmail(optionalMember.get().getEmail());
        followerCount.setFollowerCount(followerCount.getFollowerCount() + 1);
        followerCountRepository.save(followerCount);
    }

    /**
     * 팔로잉 인원 증가
     */
    public void increaseFollowingCount(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);

        if (!optionalMember.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        FollowingCount followingCount = followingCountRepository.findByEmail(optionalMember.get().getEmail());
        followingCount.setFollowingCount(followingCount.getFollowingCount() + 1);
        followingCountRepository.save(followingCount);
    }

    /**
     * 팔로워 인원 감소
     */
    public void decreaseFollowerCount(String followEmail) {
        Optional<Member> optionalMember = memberRepository.findByEmail(followEmail);

        if (!optionalMember.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        FollowerCount followerCount = followerCountRepository.findByEmail(optionalMember.get().getEmail());
        followerCount.setFollowerCount(followerCount.getFollowerCount() - 1);
        followerCountRepository.save(followerCount);
    }

    /**
     * 팔로잉 인원 감소
     */
    public void decreaseFollowingCount(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);

        if (!optionalMember.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        FollowingCount followingCount = followingCountRepository.findByEmail(optionalMember.get().getEmail());
        followingCount.setFollowingCount(followingCount.getFollowingCount() - 1);
        followingCountRepository.save(followingCount);
    }
}
