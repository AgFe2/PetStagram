package B4F2.PetStagram.comment.model;

import B4F2.PetStagram.comment.entity.Comment;
import B4F2.PetStagram.feed.entity.Feed;
import B4F2.PetStagram.member.entity.Member;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class CommentResponseDto {
    private Long id;
    private String context;
    private LocalDateTime createdAt;
    private String email;
    private Long feedId;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.context = comment.getContext();
        this.createdAt = comment.getCreatedAt();
        this.email = comment.getMember().getEmail();
        this.feedId = comment.getFeed().getId();
    }
}
