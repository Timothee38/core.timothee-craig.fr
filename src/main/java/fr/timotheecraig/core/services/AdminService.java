package fr.timotheecraig.core.services;

import fr.timotheecraig.core.models.Admin;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public interface AdminService {
    @Transactional(readOnly = false)
    public Admin createAdmin(Admin admin);

}
