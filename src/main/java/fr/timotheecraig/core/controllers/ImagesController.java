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
@RequestMapping("/api")
public class ImagesController {

    @Autowired
    ImagesService imagesService;

    private final Logger logger = LoggerFactory.getLogger(ImagesController.class);

    private static String UPLOADED_FOLDER = "C://Temp//"; // TODO : Must change when I put this on my Linux VPS :)

    @GetMapping("/images")
    public Images getRandomImage() {
        List<Images> images = imagesService.getImages();
        int index = ThreadLocalRandom.current().nextInt(images.size());
        return images.get(index);
    }

    @PostMapping("/images")
    public ResponseEntity<?> uploadImages(@RequestParam("file") MultipartFile file) {
        logger.debug("Uploading 1 single file: " + file.getName());
        if(file.isEmpty()) {
            return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
        }

        try {
            imagesService.saveUploadedFiles(Arrays.asList(file), UPLOADED_FOLDER);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Images images = new Images(UPLOADED_FOLDER + file.getOriginalFilename());
        return new ResponseEntity("Successfully uploaded - " + file.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/images/{id}")
    public ResponseEntity<?> deleteImages(@PathVariable(value = "id") Integer id) {
        Images images = imagesService.getImages(id).orElseThrow(() -> new RessourceNotFoundException("Images", "id", id));
        imagesService.deleteImages(images);
        return ResponseEntity.ok().build();
    }

}
