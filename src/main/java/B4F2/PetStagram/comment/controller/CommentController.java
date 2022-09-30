package B4F2.PetStagram.comment.controller;

import B4F2.PetStagram.comment.application.CommentSaveApplication;
import B4F2.PetStagram.comment.entity.Comment;
import B4F2.PetStagram.comment.model.CommentSaveDto;
import B4F2.PetStagram.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class CommentController {

    private final CommentSaveApplication commentSaveApplication;
    private final CommentService commentService;


    @PostMapping("{feedId}/save-comment")
    public ResponseEntity<?> commentSave(@RequestParam Long feedId, @RequestBody CommentSaveDto commentSaveDto, HttpServletRequest request){

        return ResponseEntity.ok(commentSaveApplication.commentSave(feedId, commentSaveDto, (String) request.getAttribute("email")));
//        return ResponseEntity.ok(commentService.saveComment(feedId, commentSaveDto, (String) request.getAttribute("email")));
    }


    @DeleteMapping("{feedId}/delete/{commentId}")
    public boolean deleteFeed(@RequestParam Long feedId, Long commentId, HttpServletRequest request) {

        return commentService.commentDelete(feedId, commentId, (String) request.getAttribute("email"));
    }


    @GetMapping("/{feedId}/comments")
    public Slice<Comment> getComments(@RequestParam Long feedId, @PageableDefault(size = 20) Pageable pageable) {

        return commentService.findAll(pageable, feedId);
    }


}


