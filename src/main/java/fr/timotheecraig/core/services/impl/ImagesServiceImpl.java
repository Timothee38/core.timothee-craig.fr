package fr.timotheecraig.core.services.impl;

import fr.timotheecraig.core.models.Images;
import fr.timotheecraig.core.repositories.ImagesRepository;
import fr.timotheecraig.core.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagesServiceImpl implements ImagesService {

    private ImagesRepository imagesRepository;

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
        return null;
    }

    public Images addImages(Images images) {
        return imagesRepository.save(images);
    }

    public Optional<Images> getImages(Integer id) {
        return imagesRepository.findById(id);
    }

    public Images updateImages(Images imagesToUpdate, Images imagesDetail) {
        imagesToUpdate.setPath(imagesDetail.getPath());
        return imagesRepository.save(imagesToUpdate);
    }

    public void deleteImages(Images images) {
        // TODO: delete image at path in images.getPath
        imagesRepository.delete(images);
    }
}
