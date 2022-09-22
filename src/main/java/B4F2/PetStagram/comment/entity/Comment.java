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

    //작성자
//    @ManyToOne
//    @JoinColumn(name = "member_id")
    private String email; // todo member쪽에서 이메일 땡겨오기?

    //SELECT * FROM 'comment' c INNER JOIN 'member' m ON c.mid = m.id WHERE feed_id=?
//    private String mid;

    //게시물
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private FeedEntity feed;

    private LocalDateTime createdAt;


    public static Comment from(CommentSaveDto commentSaveDto){
        return Comment.builder()
                .context(commentSaveDto.getContext())
//                .member(commentSaveDto.getMemberId())
//                .feed(commentSaveDto.getFeedId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
