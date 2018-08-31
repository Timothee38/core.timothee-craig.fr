package fr.timotheecraig.core.services;

import fr.timotheecraig.core.models.Frontpage;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public interface FrontpageService {

    public Optional<Frontpage> getFrontpageData();

    public Optional<Frontpage> getFrontpageDataByTitle(String bigTitle);

    @Transactional(readOnly = false)
    public Frontpage updateFrontPageData(Frontpage frontpage, Frontpage frontpageDetails);
}
