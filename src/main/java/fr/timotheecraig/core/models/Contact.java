package fr.timotheecraig.core.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Contact {

    private int id;
    private String frTitle;
    private String enTitle;
    private String link;

    public Contact() {
    }

    public Contact(String frTitle, String enTitle, String link) {
        this.frTitle = frTitle;
        this.enTitle = enTitle;
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

    @Column(name = "link", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
