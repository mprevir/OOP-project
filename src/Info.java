package ua.dudeweather;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 19.04.12
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class Info {
    private Navigator navigator;
    private Map<SinglePeriod, Weather> knownPeriods;
    private Location favouritePlaces[];
    private Location currentPos;
    private WeatherChanged weatherChanged;
    private Forecaster forecaster;
    private ArrayList<SinglePeriod> timePeriods;


    public Info() {
        this.navigator = new Navigator();
        this.currentPos = new Location();
        this.favouritePlaces = new Location[6];
        this.favouritePlaces[0] = new Location();
        this.knownPeriods = new HashMap<SinglePeriod, Weather>();
        this.forecaster = new Forecaster();
        this.weatherChanged = new WeatherChanged();
        this.timePeriods = new ArrayList<SinglePeriod>();

        System.out.println("Everything's fine");
    }

    public Info(Location currentPos1,Weather weather1, WeatherChanged weatherChanged1, Navigator navigator1, Forecaster forecaster1) {
        this.currentPos = currentPos1;
        this.knownPeriods = new HashMap<SinglePeriod, Weather>();
        this.knownPeriods.put(new SinglePeriod(), weather1);
        this.weatherChanged = weatherChanged1;
        this.navigator = navigator1;
        this.forecaster = forecaster1;

        System.out.println("Information is stored, OK");
    }

    public Info(Navigator navigator, Location currentPos, Location[] favouritePlaces, Map<SinglePeriod, Weather> knownPeriods, Forecaster forecaster, WeatherChanged weatherChanged) {
        this.navigator = navigator;
        this.currentPos = currentPos;
        this.favouritePlaces = favouritePlaces;
        this.knownPeriods = knownPeriods;
        this.forecaster = forecaster;
        this.weatherChanged = weatherChanged;
    }

    public ArrayList<SinglePeriod> getTimePeriods() {
        return this.timePeriods;
    }

    public Map<SinglePeriod, Weather> getKnownPeriods() {
        return this.knownPeriods;
    }

    public void readWeatherInfo(String weathersource) throws IOException, ClassNotFoundException{
        File f = new File(weathersource);
        boolean concat = true;
        boolean firstIteration = true;
        double readHumidity;
        double readTemperature;
        double readWindSpeed;
        double readPressure;
        Weather.Precipitation readPrecipitation;
        Weather.Cloudiness readCloudiness;
        SinglePeriod singlePeriod = new SinglePeriod();
        Weather weather = new Weather();

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (fis.available() != 0)   {

            Date readTime1 = (Date) ois.readObject();
            Date readTime2 = (Date) ois.readObject();
            readHumidity = ois.readDouble();
            readTemperature = ois.readDouble();
            readWindSpeed = ois.readDouble();
            readPressure = ois.readDouble();

            readPrecipitation = (Weather.Precipitation) ois.readObject();
            readCloudiness = (Weather.Cloudiness) ois.readObject();

            Weather prevWeather = this.knownPeriods.get(singlePeriod);
            if (!firstIteration) {
                if (weatherChanged.getDeltaPrecipitation() && readPrecipitation != prevWeather.getPrecipitation())
                    concat = false;
                if (weatherChanged.getDeltaCloudiness() && readCloudiness != prevWeather.getCloudiness())
                    concat = false;
                if (Math.abs(readTemperature - prevWeather.getTemperature()) > weatherChanged.getDeltaTemperature())
                    concat = false;

            } else concat = false;

            if (concat) {
                this.knownPeriods.remove(singlePeriod);
                this.timePeriods.remove(singlePeriod);
                singlePeriod.setTimeEnd(readTime2);
                this.knownPeriods.put(singlePeriod, prevWeather);
                this.timePeriods.add(singlePeriod);
                firstIteration = false;
            } else {    
                weather = new Weather(readHumidity, readTemperature, readWindSpeed, readPressure, readPrecipitation, readCloudiness);
                singlePeriod = new SinglePeriod(readTime1, readTime2);
                this.knownPeriods.put(singlePeriod, weather);
                this.timePeriods.add(singlePeriod);
                firstIteration = false;
                concat = true;
            }    
        }
    }

}
