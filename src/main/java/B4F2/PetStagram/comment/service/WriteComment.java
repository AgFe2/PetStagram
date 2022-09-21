package B4F2.PetStagram.comment.service;

import B4F2.PetStagram.comment.entity.Comment;
import lombok.*;

import java.time.LocalDateTime;

public class WriteComment {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private String context;

        public Comment toEntity(String memberId, String feedId) {
            return Comment.builder()
//                    .memberId(memberId)
//                    .feedId(feedId)
                    .context(context)
                    .createdAt(LocalDateTime.now())
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private String memberId;
        private String context;

        public Response form( /*String feedId,*/String memberId, String context){
            return Response.builder()
                    .memberId(memberId)
//                    .feedId(feedId)
                    .context(context)
                    .build();
        }
    }
}
