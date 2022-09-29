package B4F2.PetStagram.follow.controller;

import B4F2.PetStagram.follow.entity.Follow;
import B4F2.PetStagram.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class FollowController {

    private final FollowService followService;

    // 팔로우 실행
    @PostMapping("/follow")
    public ResponseEntity<String> follow(@RequestBody String followEmail,
                                         HttpServletRequest request) {

        String email = request.getAttribute("email").toString();

        Follow follow = Follow.builder()
                .email(email)
                .followEmail(followEmail)
                .build();

        return ResponseEntity.ok(followService.doFollow(follow));
    }

    // 팔로잉 회원 목록
    @GetMapping("/following")
    public List<String> showFollowing(HttpServletRequest request) {

        String email = request.getAttribute("email").toString();

        return followService.checkFollowing(email);
    }

    // 팔로워 회원 목록
    @GetMapping("/follower")
    public List<String> showFollower(HttpServletRequest request) {

        String email = request.getAttribute("email").toString();

        return followService.checkFollower(email);
    }
}
