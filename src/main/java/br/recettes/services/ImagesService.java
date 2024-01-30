package br.recettes.services;

import br.recettes.entities.ImagesEntity;
import br.recettes.repositories.ImagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ImagesService {
    private final ImagesRepository imagesRepository;

    private final String relativePath = "/uploads/recettes_images";
    private final String upload_dir = System.getProperty("user.dir") + relativePath;

    public String uploadImage(MultipartFile file, Long id) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath =  Paths.get(upload_dir, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());

        ImagesEntity image = new ImagesEntity();
        image.setImage(relativePath +'/'+ fileNames);
        image.setRecettesId(id);

        imagesRepository.save(image);

        return (fileNames.toString());
    }
}
