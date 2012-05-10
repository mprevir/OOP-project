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
        deltaTemperature = 3;
        deltaWindSpeed = 10;
        deltaPressure = 20;
        deltaPrecipitation = true;
        deltaCloudiness = false;

        System.out.println("object WeatherChanged created");
    }

    public double getDeltaTemperature() {
        return this.deltaTemperature;
    }

    public boolean getDeltaPrecipitation() {
        return this.deltaPrecipitation;
    }

    public boolean getDeltaCloudiness() {
        return this.deltaCloudiness;
    }
}
