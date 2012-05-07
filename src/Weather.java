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



    public enum Precipitation {NONE, DRIZZLE, RAIN, HAIL, SNOW}
    private Precipitation precipitation;
    public enum Cloudiness {SKC, FEW, BKN, OVC} /* SKC - clear sky
                                                *  FEW - minor cloudiness
                                                *  BKN - considerable cloudiness
                                                *  OVC - solid cloudiness
                                                */
    private Cloudiness cloudiness;

    public Weather() {
        this(0.0, 20.0, 3.0, 760.0);
    }

    public Weather(double humidity1, double temperature1, double windSpeed1, double  pressure1){
        this.humidity = humidity1;
        this.temperature = temperature1;
        this.windSpeed = windSpeed1;
        this.pressure = pressure1;
    }

    public Weather(double humidity1, double temperature1, double windSpeed1, double  pressure1, Precipitation precipitation1, Cloudiness cloudiness1){
        this(humidity1, temperature1, windSpeed1, pressure1);
        this.precipitation = precipitation1;
        this.cloudiness = cloudiness1;
    }

    public double getHumidity() {
        return this.humidity;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double newTemparature) {
        this.temperature = newTemparature;
    }

    public double getWindSpeed() {
        return this.windSpeed;
    }

    public double getPressure() {
        return this.pressure;
    }

    public Precipitation getPrecipitation() {
        return this.precipitation;
    }

    public void setPrecipitation(Precipitation newPrecipitation) {
        this.precipitation = newPrecipitation;
    }

    public Cloudiness getCloudiness() {
        return this.cloudiness;
    }
}
