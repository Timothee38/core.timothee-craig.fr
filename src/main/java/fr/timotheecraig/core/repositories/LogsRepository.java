package fr.timotheecraig.core.repositories;

import fr.timotheecraig.core.models.Logs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface LogsRepository extends CrudRepository<Logs, Long>, PagingAndSortingRepository<Logs, Long> {

    List<Logs> getAllByDateAfterAndLogtype(Date date, int logtype);

}
