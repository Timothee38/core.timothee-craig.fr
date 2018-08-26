package fr.timotheecraig.core.services;

import fr.timotheecraig.core.models.Logs;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public interface LogsService {

    public List<Logs> getLastDayLogs(int logtype);

    @Transactional(readOnly = false)
    public Logs addLogs(Logs logs);

}
