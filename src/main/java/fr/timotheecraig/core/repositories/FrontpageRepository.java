package fr.timotheecraig.core.repositories;

import fr.timotheecraig.core.models.Frontpage;
import org.springframework.data.repository.CrudRepository;

public interface FrontpageRepository extends CrudRepository<Frontpage, String> {
}
