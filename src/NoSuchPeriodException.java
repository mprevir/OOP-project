package ua.dudeweather;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 11.05.12
 * Time: 1:09
 * To change this template use File | Settings | File Templates.
 */
public class NoSuchPeriodException extends Exception{
    private Date date;
    
    public NoSuchPeriodException(Date date1) {
        this.date = date1;
    }

    public String toString() {
        return "No weather info on " + date.getHours() + ":" + date.getMinutes() + " " + date.getDay() + "." + date.getMonth() + "." + date.getYear();
    }
}
