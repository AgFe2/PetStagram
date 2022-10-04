package B4F2.PetStagram.file.controller;

import B4F2.PetStagram.file.domain.ResultDto;
import B4F2.PetStagram.file.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResultDto> uploadFile(MultipartFile file){

        return fileService.uploadFile(file);
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
