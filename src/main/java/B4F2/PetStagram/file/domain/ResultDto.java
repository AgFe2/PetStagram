package B4F2.PetStagram.file.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResultDto implements Serializable {

    private String fileName;

    private Long feedId;

    private String uuid;

    private String folderPath;

}
