package B4F2.PetStagram.feed.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WriteFeedRes {

    private String userId;
    private String mainText;
    private LocalDateTime updateDit;

    public static WriteFeedRes form(FeedDto feedDto){
        return WriteFeedRes.builder()
                .userId(feedDto.getUserId())
                .mainText(feedDto.getMainText())
                .updateDit(feedDto.getUpdateDit())
                .build();
    }
}
