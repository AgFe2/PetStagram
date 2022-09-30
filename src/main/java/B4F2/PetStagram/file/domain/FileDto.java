package B4F2.PetStagram.file.domain;

import B4F2.PetStagram.file.entity.FileEntity;
import lombok.*;


public class FileDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class fileDto {

        private Long feedId;
        private String filename;
        private String fileUrl;

        public FileEntity form(Long feedId, String filename, String fileUrl) {
            return FileEntity.builder()
                    .feedId(feedId)
                    .filename(filename)
                    .fileUrl(fileUrl)
                    .build();
        }

    }

}
