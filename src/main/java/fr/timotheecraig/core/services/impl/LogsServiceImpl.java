package fr.timotheecraig.core.services.impl;

import fr.timotheecraig.core.models.Logs;
import fr.timotheecraig.core.objects.LogsCountObject;
import fr.timotheecraig.core.repositories.LogsRepository;
import fr.timotheecraig.core.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    public List<LogsCountObject> getLogsCountByType(int logtype) {
        List<LogsCountObject> ret = new ArrayList<>();
        List<Object[]> objects = logsRepository.countByLogtypeGroupByDate(logtype);
        for(Object[] object: objects) {
            ret.add(new LogsCountObject((int) object[0], (Date)object[1], ((BigInteger)object[2]).longValue()));
        }
        return ret;
    }

}
