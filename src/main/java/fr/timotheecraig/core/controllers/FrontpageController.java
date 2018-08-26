package fr.timotheecraig.core.controllers;

import fr.timotheecraig.core.exceptions.RessourceNotFoundException;
import fr.timotheecraig.core.models.Frontpage;
import fr.timotheecraig.core.services.FrontpageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FrontpageController {

    @Autowired
    FrontpageService frontpageService;

    @GetMapping("/frontpage")
    public Frontpage getFrontpageData() {
        return frontpageService.getFrontpageData().orElseThrow(() -> new RessourceNotFoundException("Frontpage", "data", "get front page date"));
    }

}
