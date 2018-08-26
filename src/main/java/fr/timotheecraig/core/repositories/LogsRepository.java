package fr.timotheecraig.core.repositories;

import fr.timotheecraig.core.models.Logs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LogsRepository extends CrudRepository<Logs, Long>, PagingAndSortingRepository<Logs, Long> {
}
