package fr.timotheecraig.core.controllers;

import fr.timotheecraig.core.models.Admin;
import fr.timotheecraig.core.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/admin")
    public Admin createAdmin(@Valid @RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }


}
