package B4F2.PetStagram.comment.entity;

import B4F2.PetStagram.comment.model.CommentSaveDto;
import B4F2.PetStagram.feed.entity.FeedEntity;
import B4F2.PetStagram.member.entity.Member;
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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;

    private Long feedId;

//    @ManyToOne
//    @JoinColumn(name = "feed_id")
//    private FeedEntity feedEntity;

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
