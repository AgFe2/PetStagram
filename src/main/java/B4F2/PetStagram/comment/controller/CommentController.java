package B4F2.PetStagram.comment.controller;

import B4F2.PetStagram.comment.application.CommentSaveApplication;
import B4F2.PetStagram.comment.model.CommentSaveDto;
import B4F2.PetStagram.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
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


    @PostMapping("/create-comment")
    public ResponseEntity<String> commentSave(@RequestParam Long feedId, @RequestBody CommentSaveDto commentSaveDto, HttpServletRequest request){

        return ResponseEntity.ok(commentSaveApplication.commentSave(feedId, commentSaveDto, (String) request.getAttribute("email")));
    }



    @DeleteMapping("/delete/{commentId}")
    public boolean deleteFeed(@RequestParam Long commentId, HttpServletRequest request) {

        return commentService.commentDelete(commentId, (String) request.getAttribute("email"));
    }
}


