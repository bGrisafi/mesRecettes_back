package br.recettes.controllers;

import br.recettes.services.ImagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImagesController {
    private final ImagesService imagesService;

    @PostMapping("upload/{id}")
    public String uploadImage (@RequestParam ("image")MultipartFile file, @PathVariable Long id) throws IOException {
        return imagesService.uploadImage(file, id);
    }
}

