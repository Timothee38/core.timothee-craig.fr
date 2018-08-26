package fr.timotheecraig.core.services;

import fr.timotheecraig.core.models.Frontpage;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public interface FrontpageService {

    public Optional<Frontpage> getFrontpageData();

}
