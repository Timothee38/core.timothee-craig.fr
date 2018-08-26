package fr.timotheecraig.core.repositories;

import fr.timotheecraig.core.models.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, String> {
    Admin findAdminByUsername(String username);
}
