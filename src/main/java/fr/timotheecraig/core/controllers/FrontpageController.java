package fr.timotheecraig.core.controllers;

import fr.timotheecraig.core.exceptions.RessourceNotFoundException;
import fr.timotheecraig.core.models.Frontpage;
import fr.timotheecraig.core.services.FrontpageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FrontpageController {

    @Autowired
    FrontpageService frontpageService;

    @GetMapping("/frontpage")
    public Frontpage getFrontpageData() {
        return frontpageService.getFrontpageData().orElseThrow(() -> new RessourceNotFoundException("Frontpage", "data", "get front page date"));
    }

    @PutMapping("/frontpage/{bigTitle}")
    public Frontpage updateFrontPageData(@PathVariable(value = "bigTitle") String bigTitle, @Valid @RequestBody Frontpage frontpageDetails) {
        Frontpage frontpage = frontpageService.getFrontpageDataByTitle(bigTitle).orElseThrow(() -> new RessourceNotFoundException("Frontpage", "bigTitle", bigTitle));
        return frontpageService.updateFrontPageData(frontpage, frontpageDetails);
    }

}
