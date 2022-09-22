package B4F2.PetStagram.comment.model;

import B4F2.PetStagram.comment.entity.Comment;
import B4F2.PetStagram.feed.entity.FeedEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
    private String context;
    private LocalDateTime createdAt;
    private String email;
    private FeedEntity feedId;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.context = comment.getContext();
        this.createdAt = comment.getCreatedAt();
        this.email = comment.getEmail();
        this.feedId = comment.getFeed();
    }
}
