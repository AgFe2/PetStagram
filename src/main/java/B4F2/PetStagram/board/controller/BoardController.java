package B4F2.PetStagram.board.controller;

import B4F2.PetStagram.board.service.BoardService;
import B4F2.PetStagram.feed.domain.FeedDto;
import B4F2.PetStagram.feed.entity.FeedEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/myList")
    public ResponseEntity<List<FeedEntity>> myList(@RequestParam String email
            , @PageableDefault(sort = "feedId", direction = Sort.Direction.DESC) Pageable pageable) {
        List<FeedEntity> feed = boardService.myList(email, pageable);
        return ResponseEntity.ok(feed);
    }

    @GetMapping("/followList")
    public ResponseEntity<List<FeedEntity>> followList(@RequestParam String email
            , @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        List<FeedEntity> feed = boardService.followingList(email, pageable);

        return ResponseEntity.ok(feed);
    }

    @GetMapping("/bestList")
    public ResponseEntity<List<FeedEntity>> bestList(
            @PageableDefault(sort = "feedId", direction = Sort.Direction.DESC) Pageable pageable) {
        List<FeedEntity> feed = boardService.bestList(pageable);

        return ResponseEntity.ok(feed);
    }

}
