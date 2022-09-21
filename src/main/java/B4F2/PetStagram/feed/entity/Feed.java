package B4F2.PetStagram.feed.entity;

import B4F2.PetStagram.comment.entity.Comment;
import B4F2.PetStagram.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "feed")
@Entity
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String feed_content;

    //=====작성자=====
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    //commentEntity는 연관관계의 주인이 아니다(FK가 아니다), db에 컬럼 만들지마라
//    @OneToMany(mappedBy = "feedEntity", fetch = FetchType.LAZY) //댓글 더보기 같은거 눌렀을때, 필요할때만 commentEntity 들고온다
    @OneToMany(mappedBy = "feed", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"feed"}) //무한참조 방지
    @OrderBy("id desc")
    private List<Comment> comments;

}
