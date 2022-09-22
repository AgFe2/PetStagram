package B4F2.PetStagram.feed.controller;

import B4F2.PetStagram.feed.domain.WriteFeed;
import B4F2.PetStagram.feed.service.FeedService;
import B4F2.PetStagram.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;


    @PostMapping("/write")
    public ResponseEntity<?> writeFeed(@RequestBody WriteFeed.Request writeFeed, HttpServletRequest request){

        return ResponseEntity.ok(feedService.writeFeed(writeFeed,(String)request.getAttribute("email")));

    }

    @DeleteMapping("/delete")
    public boolean deleteFeed(@RequestParam Long feedId, HttpServletRequest request) {

        return feedService.deleteFeed(feedId, (String)request.getAttribute("email"));
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
