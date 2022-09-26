package B4F2.PetStagram.comment.entity;

import B4F2.PetStagram.comment.model.CommentSaveDto;
import B4F2.PetStagram.feed.entity.FeedEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String context;

    private String email;

    private Long feedId;

    private LocalDateTime createdAt;


    public static Comment from(CommentSaveDto commentSaveDto, Long feedId, String email){
        return Comment.builder()
                .context(commentSaveDto.getContext())
                .email(commentSaveDto.getEmail())
                .feedId(feedId)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
