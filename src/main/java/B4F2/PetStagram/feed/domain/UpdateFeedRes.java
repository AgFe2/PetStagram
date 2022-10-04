package B4F2.PetStagram.feed.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateFeedRes {

    private Long feedId;
    private String mainText;

    public static UpdateFeedRes form(FeedDto feedDto) {
        return UpdateFeedRes.builder()
                .feedId(feedDto.getFeedId())
                .mainText(feedDto.getMainText())
                .build();
    }
}
