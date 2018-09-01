package fr.timotheecraig.core.services.impl;

import fr.timotheecraig.core.controllers.ImagesController;
import fr.timotheecraig.core.models.Images;
import fr.timotheecraig.core.repositories.ImagesRepository;
import fr.timotheecraig.core.services.ImagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ImagesServiceImpl implements ImagesService {

    private ImagesRepository imagesRepository;

    private final Logger logger = LoggerFactory.getLogger(ImagesServiceImpl.class);

    /** Getters and Setters **/
    public ImagesRepository getImagesRepository() {
        return imagesRepository;
    }

    @Autowired
    public void setImagesRepository(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    /** Methods **/

    public List<Images> getImages() {
        return (List<Images>) imagesRepository.findAll();
    }

    public Images addImages(Images images) {
        return imagesRepository.save(images);
    }

    public Optional<Images> getImages(Integer id) {
        return imagesRepository.findById(id);
    }

    public void deleteImages(Images images) {
        try {
            File file = new File(ImagesController.UPLOADED_FOLDER + images.getPath());
            if(file.delete()) {
                logger.debug(file.getName() + " was succesfully deleted!");
            } else {
                logger.error("Error deleted file : " + file.getName() + ", at path : " + images.getPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        imagesRepository.delete(images);
    }

    public void saveUploadedFiles(List<MultipartFile> files, String uploadedFolder) throws IOException {
        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue;
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadedFolder + file.getOriginalFilename());
            Files.write(path, bytes);

        }
    }

    public Images saveImageToDb(Images images) {
        return imagesRepository.save(images);
    }
}
