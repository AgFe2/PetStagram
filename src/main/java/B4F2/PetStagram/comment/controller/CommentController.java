package B4F2.PetStagram.comment.controller;

import B4F2.PetStagram.comment.application.CommentSaveApplication;
import B4F2.PetStagram.comment.model.CommentRequestDto;
import B4F2.PetStagram.comment.model.CommentSaveDto;
import B4F2.PetStagram.comment.service.CommentService;
import B4F2.PetStagram.comment.service.WriteComment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class CommentController {

    private final CommentSaveApplication commentSaveApplication;
    private final CommentService commentService;


    @PostMapping("/{feedId}/create-comment")
    public ResponseEntity<String> commentSave(@RequestParam Long feedId, @RequestBody CommentSaveDto commentSaveDto){

        return ResponseEntity.ok(commentSaveApplication.commentSave(feedId, commentSaveDto));
    }


//    @PostMapping("/{feedId}/create-comment")
//    public ResponseEntity commentSave(@PathVariable Long id,@RequestBody CommentRequestDto dto){
//
//        return ResponseEntity.ok(commentService.saveComment(/*이메일가져와야함*/ id, dto));
//    }

//    @PostMapping("/{feedId}/create-comment")
//    public ResponseEntity<?> writeComment(@RequestBody WriteComment.Request writeComment, Authentication auth){
//
//        return ResponseEntity.ok(commentService.writeComment(writeComment, auth.getName()));
//    }


}


