package fr.timotheecraig.core.controllers;

import fr.timotheecraig.core.models.Logs;
import fr.timotheecraig.core.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LogsController {

    @Autowired
    LogsService logsService;

    @GetMapping("/logs/{logtype}")
    public List<Logs> getLogsByType(@PathVariable(value = "logtype") int logtype) {
        return logsService.getLastDayLogs(logtype);
    }

    @PostMapping("/logs")
    public Logs addLogs(@Valid @RequestBody Logs logs) {
        return logsService.addLogs(logs);
    }

}
