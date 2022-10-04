package B4F2.PetStagram.file.service;

import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.feed.repository.FeedRepository;
import B4F2.PetStagram.file.domain.FileDto;
import B4F2.PetStagram.file.domain.ResultDto;
import B4F2.PetStagram.file.entity.FileEntity;
import B4F2.PetStagram.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.apache.catalina.util.ToStringUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {

    @Value("${upload.path}")
    String uploadPath;

    private final FileRepository fileRepository;

    private final FeedRepository feedRepository;

//    @Transactional
//    public void uploadFile(Long feedId, MultipartHttpServletRequest request) throws IOException {
//
//        MultipartFile file = request.getFile("file");
//
//        File fileDir = new File(uploadPath);
//
//        if (!fileDir.exists()) {
//            fileDir.mkdir();
//        }
//
//        String fileName = RandomStringUtils.randomAlphabetic(32);
//
//        long time = System.currentTimeMillis();
//
//        //확장자 명
//        String fileExtensions = FilenameUtils.getExtension(file.getOriginalFilename());
//
//        //저장 파일명 생성(중복 최소화)
//        String saveFileName = String.format("%s_%s", time, fileName + "." + fileExtensions);
//
//        File saveFile = new File(uploadPath, saveFileName);
//        file.transferTo(saveFile);
//
//        if (saveFile.exists()) {
//            log.info(saveFileName + " 파일 저장");
//        }
//
//        fileRepository.save(new FileDto.fileDto().form(feedId, saveFileName, uploadPath));
//
//    }

    @Transactional
    public void deleteFile(Long feedId) {
        Long fileId = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD))
                .getFileId();

        FileEntity file = fileRepository.findById(fileId)
                .orElseThrow(() -> new CustomException(ErrorCode.WRONG_APPROACH));

        fileRepository.deleteById(file.getFileId());

    }

    @Transactional
    public ResponseEntity<ResultDto> uploadFile(MultipartFile file) {

        if(!file.getContentType().startsWith("image")) {
            log.warn("this file is not image type");
            return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        ResultDto resultDto = new ResultDto(null, null, null, null);

        //파일명 (경로포함)
        String originalName = file.getOriginalFilename();
        //저장경로 마지막 폴더 이름
        String fileName = originalName.substring(originalName.lastIndexOf("//")+1);

        log.info("fileName" + fileName);

        //날짜 폴더 생성
        String folderPath = makeFolder();
        //UUID
        String uuid = UUID.randomUUID().toString();
        //저장할 파일 이름 중간에 "_"를 이용하여 구분
        String saveName = uploadPath + File.separator + folderPath +File.separator + uuid + "_" + fileName;

        Path savePath = Paths.get(saveName);
        //Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)

        FileEntity save = fileRepository.save(new FileDto.fileDto().form(saveName, uploadPath));

        try{
            file.transferTo(savePath);
            resultDto = new ResultDto(fileName,uuid,folderPath,save.getFileId());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(resultDto, HttpStatus.OK);

    }
    private String makeFolder(){

        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        String folderPath = str.replace("/", File.separator);

        File uploadPathFolder = new File(uploadPath, folderPath);


        if(!uploadPathFolder.exists()){
            uploadPathFolder.mkdirs();
            //mkdirs : 해당 상위 디렉토리까지 전부 생성
        }
        return folderPath;
    }

    public ResponseEntity<byte[]> getFile(Long feedId) {

        ResponseEntity<byte[]> result;

        Long fileId = feedRepository.findById(feedId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_BOARD))
                .getFileId();

        FileEntity fileEntity = fileRepository.findById(fileId)
                .orElseThrow(() -> new CustomException(ErrorCode.WRONG_APPROACH));

        try{
            String srcFileName = URLDecoder.decode(fileEntity.getFilename(),"UTF-8");
            log.info("filename : "+srcFileName);
            File file = new File(File.separator + srcFileName);
            log.info("file : "+file);
            HttpHeaders header = new HttpHeaders();

            //MIME 타입 처리
            header.add("Content-Type", Files.probeContentType(file.toPath()));

//            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),HttpStatus.OK);

        }catch (IOException e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return result;

    }
}
