package ua.dudeweather.dressup;

import ua.dudeweather.Weather;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 19.04.12
 * Time: 19:18
 * To change this template use File | Settings | File Templates.
 */
public class Clothes {
    double lowTemperature;
    double highTemperature;
    boolean suitsAnyPrecip;
    boolean suitsAnyCloud;
    ArrayList<Weather.Precipitation> suitsPrecip;
    ArrayList<Weather.Cloudiness> suitsCloud;
    String s;

    public void setMessage(String newS) {
        this.s = newS;
    }

    public void draw() {
        System.out.println(s);
    }
    
    public boolean fits(Weather weather) {
        return ((weather.getTemperature() >= this.lowTemperature) &&
                 (weather.getTemperature() <= this.highTemperature)) &&
               (this.suitsAnyCloud ||
                (this.suitsCloud.contains(weather.getCloudiness()))) &&
               (this.suitsAnyPrecip ||
                (this.suitsPrecip.contains(weather.getPrecipitation())));
    }
}
