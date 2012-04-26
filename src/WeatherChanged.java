package ua.dudeweather;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 19.04.12
 * Time: 19:46
 * To change this template use File | Settings | File Templates.
 */
public class WeatherChanged {
    private double deltaHumidity;
    private double deltaTemperature;
    private double deltaWindSpeed;
    private double deltaPressure;
    private boolean deltaPrecipitation;
    private boolean deltaCloudiness;

    public WeatherChanged() {
        deltaHumidity = 10;
        deltaTemperature = 5;
        deltaWindSpeed = 10;
        deltaPressure = 20;
        deltaPrecipitation = true;
        deltaCloudiness = false;

        System.out.println("object WeatherChanged created");
    }
}
