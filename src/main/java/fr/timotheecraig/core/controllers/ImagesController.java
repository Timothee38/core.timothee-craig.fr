package fr.timotheecraig.core.controllers;

import fr.timotheecraig.core.exceptions.RessourceNotFoundException;
import fr.timotheecraig.core.models.Images;
import fr.timotheecraig.core.models.Projects;
import fr.timotheecraig.core.services.ImagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final Logger logger = LoggerFactory.getLogger(ImagesController.class);

    public static String UPLOADED_FOLDER = "/Users/timotheecraig/Documents/development/timotheecraig.fr/timothee-craig.fr/public/img/"; // TODO : Must change when I put this on my Linux VPS :)

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
            imagesService.saveUploadedFiles(Arrays.asList(file), UPLOADED_FOLDER);
        } catch (IOException e) {
            return null;
        }
        Images images = new Images(file.getOriginalFilename());
        return imagesService.saveImageToDb(images);
    }

    @DeleteMapping("/images/{id}")
    public ResponseEntity<?> deleteImages(@PathVariable(value = "id") Integer id) {
        Images images = imagesService.getImages(id).orElseThrow(() -> new RessourceNotFoundException("Images", "id", id));
        imagesService.deleteImages(images);
        return ResponseEntity.ok().build();
    }

}
