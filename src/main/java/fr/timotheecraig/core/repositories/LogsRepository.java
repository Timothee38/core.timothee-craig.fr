package fr.timotheecraig.core.repositories;

import fr.timotheecraig.core.models.Logs;
import fr.timotheecraig.core.objects.LogsCountObject;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface LogsRepository extends CrudRepository<Logs, Long>, PagingAndSortingRepository<Logs, Long> {

    List<Logs> getAllByDateAfterAndLogtype(Date date, int logtype);

    @Query(nativeQuery = true, value = "SELECT l.logtype, Date(l.date) as DateOnly, COUNT(l.id) FROM logs l WHERE l.logtype=?1 GROUP BY DateOnly")
    List<Object[]> countByLogtypeGroupByDate(int logtype);
}
