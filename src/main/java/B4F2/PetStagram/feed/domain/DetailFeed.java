package B4F2.PetStagram.feed.domain;

import lombok.*;
public class DetailFeed {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {

        private Long feedId;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long feedId;
        private String userId;
        private String mainText;
        //private String[] comment 차후 댓글 기능

        public static DetailFeed.Response form(FeedDto feedDto) {
            return DetailFeed.Response.builder()
                    .feedId(feedDto.getFeedId())
                    .userId(feedDto.getUserId())
                    .mainText(feedDto.getMainText())
                    .build();
        }

    }
}
