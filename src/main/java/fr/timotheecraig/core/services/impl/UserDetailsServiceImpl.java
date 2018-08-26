package fr.timotheecraig.core.services.impl;

import fr.timotheecraig.core.models.Admin;
import fr.timotheecraig.core.repositories.AdminRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AdminRepository adminRepository;

    public UserDetailsServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findAdminByUsername(username);
        if(admin == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(admin.getUsername(), admin.getPassword(), Collections.emptyList());
    }
}
