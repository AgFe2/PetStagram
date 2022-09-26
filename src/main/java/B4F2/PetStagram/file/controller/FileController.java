package B4F2.PetStagram.file.controller;

import B4F2.PetStagram.file.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam Long feedId , MultipartFile file) throws IOException{

        fileService.uploadFile(feedId, file);

        return null;
    }

    @GetMapping("/list")
    public ResponseEntity<byte[]> listUpFile(@RequestParam Long feedId) {

        return fileService.getFile(feedId);
    }

    @DeleteMapping("/delete")
    public void deleteFile(@RequestParam Long feedId) {

        fileService.deleteFile(feedId);
    }

}
