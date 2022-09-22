package B4F2.PetStagram.comment.model;

import B4F2.PetStagram.feed.entity.FeedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentSaveDto {

    private String context;

    private String email;
    private FeedEntity feedId;

    private LocalDateTime createdAt;

}
