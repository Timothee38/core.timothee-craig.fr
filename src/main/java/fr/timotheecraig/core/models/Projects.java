package fr.timotheecraig.core.models;

import javax.persistence.*;

@Entity
@Table(name="projects")
public class Projects {

    private int id;
    private String frTitle;
    private String enTitle;
    private String frDesc;
    private String enDesc;
    private String link;

    // Default CTOR
    public Projects() {
    }

    public Projects(String frTitle, String enTitle, String frDesc, String enDesc, String link) {
        this.frTitle = frTitle;
        this.enTitle = enTitle;
        this.frDesc = frDesc;
        this.enDesc = enDesc;
        this.link = link;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "fr_title", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
    public String getFrTitle() {
        return frTitle;
    }

    public void setFrTitle(String frTitle) {
        this.frTitle = frTitle;
    }

    @Column(name = "en_title", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
    }

    @Column(name = "fr_desc", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
    public String getFrDesc() {
        return frDesc;
    }

    public void setFrDesc(String frDesc) {
        this.frDesc = frDesc;
    }

    @Column(name = "en_desc", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
    public String getEnDesc() {
        return enDesc;
    }

    public void setEnDesc(String enDesc) {
        this.enDesc = enDesc;
    }

    @Column(name = "link", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
