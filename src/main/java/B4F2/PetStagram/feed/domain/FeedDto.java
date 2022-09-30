package B4F2.PetStagram.feed.domain;

import B4F2.PetStagram.feed.entity.FeedEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedDto {

    private Long feedId;
    private String mainText;
    private String userId;

    private LocalDateTime updateDit;

    private Long likeCnt;

//    차후 comment 파트와 함께 merge 되면 추가
//    @OneToMany
//    private List<CommentEntity> comments;

    // 업로드 사진

    public static FeedDto fromEntity(FeedEntity feed) {

        return  FeedDto.builder()
                .feedId(feed.getFeedId())
                .mainText(feed.getMainText())
                .likeCnt(feed.getLikeCnt())
                .updateDit(feed.getUpdateDit())
                .userId(feed.getUserId())
                .build();
    }
}
