package B4F2.PetStagram.feed.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hashtag {

    @Id
    private Long hashtagId;

    private Long feedId;
    private String hashtagContext;
    private String hashtagFeedCount;

}
