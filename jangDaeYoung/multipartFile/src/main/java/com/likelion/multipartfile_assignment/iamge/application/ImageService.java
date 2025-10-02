package com.likelion.multipartfile_assignment.iamge.application;


import com.likelion.multipartfile_assignment.iamge.domain.Image;
import com.likelion.multipartfile_assignment.iamge.domain.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    @Value("${file.dir}") // application.yml에서 설정한 경로 주입
    private String uploadDir;

    @Transactional
    public Image saveImage(MultipartFile imageFile) {
        if (imageFile.isEmpty()) {
            return null;
        }

        String originalFileName = imageFile.getOriginalFilename();
        String savedFileName = UUID.randomUUID().toString() + "_" + originalFileName;
        File file = new File(uploadDir, savedFileName);

        try {
            imageFile.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException("이미지 저장에 실패했습니다.", e);
        }

        Image image = Image.builder()
                .originalFileName(originalFileName)
                .savedFileName(savedFileName)
                .savedPath(file.getAbsolutePath())
                .build();

        return imageRepository.save(image);
    }
}