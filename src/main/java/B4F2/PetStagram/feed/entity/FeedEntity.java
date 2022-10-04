package B4F2.PetStagram.feed.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Feed")
public class FeedEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String mainText;

    private String userId;

    private LocalDateTime updateDit;

    private Long fileId;

    private Long likeCnt;

//    차후 comment 파트와 함께 merge 되면 추가
//    @JsonIgnoreProperties({"feed"})
//    @OneToMany(mappedBy = "feed", fetch = FetchType.EAGER)
//    @OrderBy("id desc")
//    private List<CommentEntity> comments;

    // 업로드 사진
}

