package B4F2.PetStagram.comment.controller;

import B4F2.PetStagram.comment.application.CommentSaveApplication;
import B4F2.PetStagram.comment.entity.Comment;
import B4F2.PetStagram.comment.model.CommentSaveDto;
import B4F2.PetStagram.comment.repository.CommentRepository;
import B4F2.PetStagram.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentSaveApplication commentSaveApplication;
    private final CommentService commentService;
    private final CommentRepository commentRepository;


//    @PostMapping("feed/save-comment/{feedId}")
    @PostMapping("feed/save-comment")
    public ResponseEntity<?> commentSave(@RequestParam("feedId") Long feedId, @RequestBody CommentSaveDto commentSaveDto, HttpServletRequest request){

//        return ResponseEntity.ok(commentSaveApplication.commentSave(feedId, commentSaveDto, (String) request.getAttribute("email")));
        return ResponseEntity.ok(commentService.saveComment(feedId, commentSaveDto, (String) request.getAttribute("email")));
    }


    @DeleteMapping("feed/delete-comment")
    public boolean deleteFeed(@RequestParam(value = "feedId") Long feedId, @RequestParam(value = "commentId") Long commentId, HttpServletRequest request) {

        return commentService.commentDelete(feedId, commentId, (String) request.getAttribute("email"));
    }


    @GetMapping("feed/show-comments")
    public ResponseEntity<Slice<Comment>> getComments(@RequestParam(value = "feedId") Long feedId, @PageableDefault(size = 5) Pageable pageable) {

        return ResponseEntity.ok(commentRepository.findAllByFeedIdOrderByCommentIdDesc(feedId, pageable));
    }

    // todo EMAIL TEST
    @GetMapping("/")
    public String getEmailTest(HttpServletRequest request) {

        System.out.println("controller email test: " + request.getAttribute("email"));

        return (String) request.getAttribute("email");
//        return request.getAttribute("email").toString();
    }

}


