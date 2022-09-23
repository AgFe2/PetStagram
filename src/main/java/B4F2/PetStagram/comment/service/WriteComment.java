package B4F2.PetStagram.comment.service;

import B4F2.PetStagram.comment.entity.CommentEntity;
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

        public CommentEntity toEntity(String email, Long feedId) {
            return CommentEntity.builder()
                    .email(email)
                    .feedId(feedId)
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

        private String email;
        private String context;
        private Long feedId;

        public Response form(String email, String context, Long feedId){
            return Response.builder()
                    .email(email)
                    .feedId(feedId)
                    .context(context)
                    .build();
        }
    }
}
