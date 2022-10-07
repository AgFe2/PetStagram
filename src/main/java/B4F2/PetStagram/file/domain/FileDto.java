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

        private String filename;
        private String fileUrl;

        public FileEntity form(String filename, String fileUrl) {
            return FileEntity.builder()
                    .filename(filename)
                    .fileUrl(fileUrl)
                    .build();
        }

    }

}
