package B4F2.PetStagram.feed.domain;

import B4F2.PetStagram.feed.entity.FeedEntity;
import lombok.*;

import java.time.LocalDateTime;

public class UpdateFeed {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {

        private String mainText;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long feedId;
        private String mainText;

        public static Response form(FeedDto feedDto) {
            return Response.builder()
                    .feedId(feedDto.getFeedId())
                    .mainText(feedDto.getMainText())
                    .build();
        }

    }

}
