package fr.timotheecraig.core.services;

import fr.timotheecraig.core.models.Logs;
import fr.timotheecraig.core.objects.LogsCountObject;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public interface LogsService {

    public List<Logs> getLastDayLogs(int logtype);

    @Transactional(readOnly = false)
    public Logs addLogs(Logs logs);

    public List<LogsCountObject> getLogsCountByType(int logtype);
}
