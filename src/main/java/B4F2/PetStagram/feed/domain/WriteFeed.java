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

        public FeedEntity toEntity(String userId) {
            return FeedEntity.builder()
                    .userId(userId)
                    .mainText(mainText)
                    .updateDit(LocalDateTime.now())
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private String userId;
        private String mainText;

        public Response form(String userId, String mainText){
            return Response.builder()
                    .userId(userId)
                    .mainText(mainText)
                    .build();
        }
    }

}
