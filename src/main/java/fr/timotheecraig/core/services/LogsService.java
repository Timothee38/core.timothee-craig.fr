package fr.timotheecraig.core.services;

import fr.timotheecraig.core.models.Logs;

import java.util.List;

public interface LogsService {

    public List<Logs> getLastDayLogs(int logtype);

    public Logs addLogs(Logs logs);

}
