package fr.timotheecraig.core.services;

import fr.timotheecraig.core.models.Contact;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public interface ContactService {

    public List<Contact> getContacts();

    public Contact addContact(Contact contact);

    public Contact updateContact(Contact contactToUpdate, Contact contactDetails);

    public void deleteContact(Contact contact);

    public Optional<Contact> findContactById(Integer id);
}
