package fr.timotheecraig.core.controllers;

import fr.timotheecraig.core.exceptions.RessourceNotFoundException;
import fr.timotheecraig.core.models.Images;
import fr.timotheecraig.core.models.Projects;
import fr.timotheecraig.core.services.ImagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class ImagesController {

    @Autowired
    ImagesService imagesService;

    @Autowired
    private Environment env;

    private final Logger logger = LoggerFactory.getLogger(ImagesController.class);

    @GetMapping("/images")
    public Images getRandomImage() {
        List<Images> images = imagesService.getImages();
        int index = images != null? ThreadLocalRandom.current().nextInt(images.size()) : -1;
        return index >= 0 ? images.get(index) : null;
    }

    @GetMapping("/all-images")
    public List<Images> getAllImages() {
        return imagesService.getImages();
    }

    @PostMapping("/images")
    public Images uploadImages(@RequestParam("file") MultipartFile file) {
        logger.debug("Uploading 1 single file: " + file.getName());
        if(file.isEmpty()) {
            return null;
        }

        try {
            imagesService.saveUploadedFiles(Arrays.asList(file), env.getProperty("timotheecraig.img.path"));
        } catch (IOException e) {
            return null;
        }
        Images images = new Images(file.getOriginalFilename());
        return imagesService.saveImageToDb(images);
    }

    @DeleteMapping("/images/{id}")
    public ResponseEntity<?> deleteImages(@PathVariable(value = "id") Integer id) {
        Images images = imagesService.getImages(id).orElseThrow(() -> new RessourceNotFoundException("Images", "id", id));
        imagesService.deleteImages(images, env.getProperty("timotheecraig.img.path"));
        return ResponseEntity.ok().build();
    }

}
