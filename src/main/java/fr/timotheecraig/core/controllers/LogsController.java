package fr.timotheecraig.core.controllers;

import fr.timotheecraig.core.api.IpStackAPI;
import fr.timotheecraig.core.models.Logs;
import fr.timotheecraig.core.objects.LogCreation;
import fr.timotheecraig.core.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class LogsController {

    @Autowired
    LogsService logsService;

    @GetMapping("/logs/{logtype}")
    public List<Logs> getLogsByType(@PathVariable(value = "logtype") int logtype) {
        return logsService.getLastDayLogs(logtype);
    }

    @PostMapping("/logs")
    public Logs addLogs(HttpServletRequest request, @Valid @RequestBody LogCreation log) {
        String country = "localhost";
        if(!request.getRemoteAddr().equals("0:0:0:0:0:0:0:1") && !request.getRemoteAddr().equals("127.0.0.1")) {
            country = IpStackAPI.getCountryFromIp(request.getRemoteAddr());
        }
        Logs logs = new Logs(log.getDate(), log.getLang(), request.getRemoteAddr(), country, log.getLink(), log.getLogType());
        return logsService.addLogs(logs);
    }

}
