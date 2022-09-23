package B4F2.PetStagram.comment.model;

import B4F2.PetStagram.comment.entity.CommentEntity;
import B4F2.PetStagram.feed.entity.FeedEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    private Long id;
    private String context;
    private LocalDateTime createdAt;
    private String email;
    private FeedEntity feed;

    public CommentEntity toEntity() {

        CommentEntity commentEntity = CommentEntity.builder()
                .commentId(id)
                .context(context)
                .createdAt(LocalDateTime.now())
                .email("email") //todo 댓글작성자 이메일 뽑아오기
                .feedId(feed.getFeedId())
                .build();

        return commentEntity;
    }
}
