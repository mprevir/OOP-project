package ua.dudeweather;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 19.04.12
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
public class SinglePeriod {
    private Location pos;
    private Date timeBegin;      //it would be better to use our own Date class
    private Date timeEnd;

    public SinglePeriod() {
        this.pos = new Location();
        this.timeBegin = new Date();
        this.timeEnd = new Date();
    }
    
    public SinglePeriod(Date timeBegin, Date timeEnd) {
        pos = new Location();
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
    }

    public Date getTimeBegin() {
        return this.timeBegin;
    }
    
    public void setTimeBegin(Date newTimeBegin) {
        this.timeBegin = newTimeBegin;
    }

    public Date getTimeEnd() {
        return this.timeEnd;
    }
    
    public void setTimeEnd(Date newTimeEnd) {
        this.timeEnd = newTimeEnd;
    }

    public Location getPos() {
        return this.pos;
    }
}
