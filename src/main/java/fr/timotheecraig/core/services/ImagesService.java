package fr.timotheecraig.core.services;

import fr.timotheecraig.core.models.Images;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public interface ImagesService {

    public List<Images> getImages();

    @Transactional(readOnly = false)
    public Images addImages(Images images);

    public Optional<Images> getImages(Integer id);

    @Transactional(readOnly = false)
    public Images updateImages(Images imagesToUpdate, Images imagesDetail);

    @Transactional(readOnly = false)
    public void deleteImages(Images images);

}
