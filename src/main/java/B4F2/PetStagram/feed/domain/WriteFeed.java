package B4F2.PetStagram.feed.domain;

import B4F2.PetStagram.feed.entity.FeedEntity;
import lombok.*;

import java.time.LocalDateTime;

public class WriteFeed {

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

        private String userId;
        private String mainText;
        private LocalDateTime updateDit;

        public static Response form(FeedDto feedDto){
            return Response.builder()
                    .userId(feedDto.getUserId())
                    .mainText(feedDto.getMainText())
                    .updateDit(feedDto.getUpdateDit())
                    .build();
        }
    }

}
