package fr.timotheecraig.core.repositories;

import fr.timotheecraig.core.models.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
