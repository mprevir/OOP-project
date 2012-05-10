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
        if (weather.getTemperature() < lowTemperature || weather.getTemperature() > highTemperature) return false;
        if (!suitsAnyCloud && !(suitsCloud.contains(weather.getCloudiness()))) return false;
        if (!suitsAnyPrecip && !(suitsPrecip.contains(weather.getPrecipitation()))) return false;
        return true;
    }
}
