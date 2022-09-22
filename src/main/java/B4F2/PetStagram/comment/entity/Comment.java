package B4F2.PetStagram.comment.entity;

import B4F2.PetStagram.comment.model.CommentSaveDto;
import B4F2.PetStagram.feed.entity.FeedEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "comment")
@Entity
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String context;

    private String email; //todo member쪽에서 이메일 땡겨오기?

    //게시물
    private Long feedId;

    private LocalDateTime createdAt;


    public static Comment from(CommentSaveDto commentSaveDto, Long feedId){
        return Comment.builder()
                .context(commentSaveDto.getContext())
                .email(commentSaveDto.getEmail())
                .feedId(feedId)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
