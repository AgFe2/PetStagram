package B4F2.PetStagram.follow.controller;

import B4F2.PetStagram.follow.entity.Follow;
import B4F2.PetStagram.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FollowController {

    private final FollowService followService;

    // 팔로우 실행
    @PostMapping("/follow")
    public ResponseEntity<String> follow(@RequestBody Follow follow) {
        return ResponseEntity.ok(followService.doFollow(follow));
    }

    // 팔로잉 확인
    @GetMapping("/following")
    public List<String> showFollowing(@RequestBody Follow follow) {
        return followService.checkFollowing(follow.getEmail());
    }

    // 팔로워 확인
    @GetMapping("/follower")
    public List<String> showFollower(@RequestBody Follow follow) {
        return followService.checkFollower(follow.getEmail());
    }
}
