package B4F2.PetStagram.comment.model;

import B4F2.PetStagram.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Long commentId;
    private String context;
    private String email;
    private LocalDateTime createdAt;

    public static CommentDto toDto(Comment comment) {
        return new CommentDto(
                comment.getCommentId(),
                comment.getContext(),
                comment.getEmail(),
                comment.getCreatedAt()
        );
    }
}
