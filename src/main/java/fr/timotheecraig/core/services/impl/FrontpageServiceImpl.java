package fr.timotheecraig.core.services.impl;

import fr.timotheecraig.core.models.Frontpage;
import fr.timotheecraig.core.repositories.FrontpageRepository;
import fr.timotheecraig.core.services.FrontpageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FrontpageServiceImpl implements FrontpageService {

    private final String FRONTPAGE_TITLE="Timothée Craig"; // This should never change.

    private FrontpageRepository frontpageRepository;

    /** Getters and Setters **/
    public FrontpageRepository getFrontpageRepository() {
        return frontpageRepository;
    }

    @Autowired
    public void setFrontpageRepository(FrontpageRepository frontpageRepository) {
        this.frontpageRepository = frontpageRepository;
    }

    /** Methods **/
    public Optional<Frontpage> getFrontpageData() {
        return frontpageRepository.findById(FRONTPAGE_TITLE);
    }
}
