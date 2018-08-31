package fr.timotheecraig.core.objects;

import java.util.Date;


public class LogsCountObject {

    private int logtype;
    private Date date;
    private long count;

    public LogsCountObject(int logtype, Date date, long count) {
        this.logtype = logtype;
        this.date = date;
        this.count = count;
    }

    public int getLogtype() {
        return logtype;
    }

    public void setLogtype(int logtype) {
        this.logtype = logtype;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
