package fr.timotheecraig.core.models;

import javax.persistence.*;

@Entity
@Table(name="images")
public class Images {

    private int id;
    private String path;

    public Images() {
    }

    public Images(String path) {
        this.path = path;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "path", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
