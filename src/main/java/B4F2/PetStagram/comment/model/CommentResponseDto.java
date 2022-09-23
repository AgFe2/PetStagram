package B4F2.PetStagram.comment.model;

import B4F2.PetStagram.comment.entity.CommentEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
    private String context;
    private LocalDateTime createdAt;
    private String email;
    private Long feedId;

    public CommentResponseDto(CommentEntity commentEntity) {
        this.id = commentEntity.getCommentId();
        this.context = commentEntity.getContext();
        this.createdAt = commentEntity.getCreatedAt();
        this.email = commentEntity.getEmail();
        this.feedId = commentEntity.getFeedId();
    }
}
