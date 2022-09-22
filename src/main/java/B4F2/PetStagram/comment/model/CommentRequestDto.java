package B4F2.PetStagram.comment.model;

import B4F2.PetStagram.comment.entity.Comment;
import B4F2.PetStagram.feed.entity.Feed;
import B4F2.PetStagram.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    private Long id;
    private String context;
    private LocalDateTime createdAt;
    private String email;
    private Feed feed;

    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(id)
                .context(context)
                .createdAt(LocalDateTime.now())
                .email("email")
                .feed(feed)
                .build();

        return comments;
    }
}
