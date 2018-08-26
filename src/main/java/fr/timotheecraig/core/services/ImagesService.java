package fr.timotheecraig.core.services;

import fr.timotheecraig.core.models.Images;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public interface ImagesService {

    public List<Images> getImages();

    @Transactional(readOnly = false)
    public Images addImages(Images images);

    public Optional<Images> getImages(Integer id);

    @Transactional(readOnly = false)
    public void deleteImages(Images images);

    public void saveUploadedFiles(List<MultipartFile> asList, String uploadedFolder) throws IOException;
}
