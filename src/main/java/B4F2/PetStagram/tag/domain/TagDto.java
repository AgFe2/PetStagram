package B4F2.PetStagram.tag.domain;

import B4F2.PetStagram.tag.entity.TagEntity;
import lombok.*;

public class TagDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    public static class regisTagDto {

        public TagEntity toEntity(String tag, Long feedId) {
            return TagEntity.builder()
                    .tagTitle(tag)
                    .tagInFeed(feedId)
                    .build();
        }
    }
}
