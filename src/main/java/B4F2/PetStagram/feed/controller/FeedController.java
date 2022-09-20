package B4F2.PetStagram.feed.controller;

import B4F2.PetStagram.feed.domain.WriteFeed;
import B4F2.PetStagram.feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @PostMapping("/write")
    public ResponseEntity<?> writeFeed(@RequestBody WriteFeed.Request writeFeed, Authentication auth){

        return ResponseEntity.ok(feedService.writeFeed(writeFeed, auth.getName()));

    }

    @DeleteMapping("/delete")
    public boolean deleteFeed(@RequestParam Long feedId, Authentication auth) {

        return feedService.deleteFeed(feedId, auth.getName());
    }

    @GetMapping("/like")
    public boolean likeFeed(@RequestParam Long feedId) {

        return feedService.likeFeed(feedId);
    }

    @GetMapping("/unlike")
    public boolean unLikeFeed(@RequestParam Long feedId) {

        return feedService.unLikeFeed(feedId);
    }

}
