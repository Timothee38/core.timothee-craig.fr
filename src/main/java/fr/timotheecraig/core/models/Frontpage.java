package fr.timotheecraig.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="frontpage")
public class Frontpage {

    private String bigTitle;
    private String frDesc;
    private String enDesc;

    @Id
    @Column(name = "bigtitle", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
    public String getBigTitle() {
        return bigTitle;
    }

    public void setBigTitle(String bigTitle) {
        this.bigTitle = bigTitle;
    }

    @Column(name = "fr_desc", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
    public String getFrDesc() {
        return frDesc;
    }

    public void setFrDesc(String frDesc) {
        this.frDesc = frDesc;
    }

    @Column(name = "en_desc", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
    public String getEnDesc() {
        return enDesc;
    }

    public void setEnDesc(String enDesc) {
        this.enDesc = enDesc;
    }

}
