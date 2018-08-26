package fr.timotheecraig.core.repositories;

import fr.timotheecraig.core.models.Logs;
import org.springframework.data.repository.CrudRepository;

public interface LogsRepository extends CrudRepository<Logs, Long> {
}
