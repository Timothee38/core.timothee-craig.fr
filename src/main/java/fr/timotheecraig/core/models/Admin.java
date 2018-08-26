package fr.timotheecraig.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

    private String username;
    private String password;

    public Admin() { }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    @Column(name = "username", unique = false, nullable = false, insertable = true, updatable = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", unique = false, nullable = false, insertable = true, updatable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
