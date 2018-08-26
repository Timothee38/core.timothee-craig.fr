package fr.timotheecraig.core.services;

import fr.timotheecraig.core.models.Frontpage;

import java.util.Optional;

public interface FrontpageService {

    public Optional<Frontpage> getFrontpageData();

}
