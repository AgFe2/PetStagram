package B4F2.PetStagram.comment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentSaveDto {

    private String context;
    private long memberId;
    private long feedId;
    private LocalDateTime createdAt;

}
