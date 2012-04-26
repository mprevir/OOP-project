package ua.dudeweather;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 19.04.12
 * Time: 19:07
 * To change this template use File | Settings | File Templates.
 */
public class Weather {
    private double humidity;
    private double temperature;
    private double windSpeed;
    private double pressure;
    //TODO: declare enum types for _precipitation_ and _cloudiness_

    public Weather(double humidity1, double temperature1, double windSpeed1, double  pressure1){
        this.humidity = humidity1;
        this.temperature = temperature1;
        this.windSpeed = windSpeed1;
        this.pressure = pressure1;
    }
}
