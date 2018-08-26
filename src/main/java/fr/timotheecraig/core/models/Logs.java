package fr.timotheecraig.core.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="logs")
public class Logs {

    private long id;
    private Date date;
    private String lang;
    private String ip;
    private String country;
    private String link;
    /** LOGTYPES:
     * 1: onJoinLogs
     * 2: onLinkClickLogs
     * 3: onLangChangeLogs
     * **/
    private int logtype;

    public Logs() { }

    public Logs(Date date, String lang, String ip, String country, String link, int logtype) {
        this.date = date;
        this.lang = lang;
        this.ip = ip;
        this.country = country;
        this.link = link;
        this.logtype = logtype;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "date", unique = false, nullable = false, insertable = true, updatable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "lang", unique = false, nullable = false, insertable = true, updatable = true, length = 45)
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Column(name = "ip", unique = false, nullable = false, insertable = true, updatable = true, length = 45)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "country", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "link", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Column(name = "logtype", unique = false, nullable = false, insertable = true, updatable = true)
    public int getLogtype() {
        return logtype;
    }

    public void setLogtype(int logtype) {
        this.logtype = logtype;
    }
}
