package fr.timotheecraig.core.objects;

import java.util.Date;

public class LogCreation {
    private Date date;
    private String lang;
    private int logType;
    private String link;

    public LogCreation() {
    }

    public LogCreation(Date date, String lang, int logType, String link) {
        this.date = date;
        this.lang = lang;
        this.logType = logType;
        this.link = link;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getLogType() {
        return logType;
    }

    public void setLogType(int logType) {
        this.logType = logType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
