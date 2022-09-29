package B4F2.PetStagram.feed.controller;

import B4F2.PetStagram.feed.domain.DetailFeed;
import B4F2.PetStagram.feed.domain.UpdateFeed;
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
    public WriteFeed.Response writeFeed(@RequestBody WriteFeed.Request writeFeed,
                                       HttpServletRequest request){

        return WriteFeed.Response.form(feedService.writeFeed(
                writeFeed.getMainText(),
                (String) request.getAttribute("email")
        ));

    }

    @DeleteMapping("/delete")
    public boolean deleteFeed(@RequestParam("feedId") Long feedId,
                              HttpServletRequest request) {

        return feedService.deleteFeed(feedId,
                (String)request.getAttribute("email"));
    }

    @PutMapping("/update")
    public UpdateFeed.Response updateFeed(@RequestParam("feedId") Long feedId,
                                        @RequestBody UpdateFeed.Request updateRequest,
                                        HttpServletRequest request) {

        return UpdateFeed.Response.form(
                feedService.updateFeed(updateRequest,
                        feedId,
                        (String)request.getAttribute("email"))
        );
    }

    @GetMapping("/detail")
    public DetailFeed.Response detailFeed(@RequestParam("feedId") Long feedId) {

        return DetailFeed.Response.form(
                feedService.detailFeed(feedId)
        );
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
