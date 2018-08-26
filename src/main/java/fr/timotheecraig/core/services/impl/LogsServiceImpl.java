package fr.timotheecraig.core.services.impl;

import fr.timotheecraig.core.models.Logs;
import fr.timotheecraig.core.repositories.LogsRepository;
import fr.timotheecraig.core.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.Calendar;
import java.util.List;

@Service
public class LogsServiceImpl implements LogsService {

    private LogsRepository logsRepository;

    /** Getters and Setters **/
    public LogsRepository getLogsRepository() {
        return logsRepository;
    }

    @Autowired
    public void setLogsRepository(LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }

    /** Methods **/
    public List<Logs> getLastDayLogs(int logtype) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return logsRepository.getAllByDateAfterAndLogtype(calendar.getTime(), logtype);
    }

    public Logs addLogs(Logs logs) {
        return logsRepository.save(logs);
    }

}
