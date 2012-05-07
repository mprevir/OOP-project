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
    public Map<SinglePeriod, Weather> knownPeriods;
    private Location favouritePlaces[];
    private Location currentPos;
    private WeatherChanged weatherChanged;
    private Forecaster forecaster;


    public Info() {
        this.navigator = new Navigator();
        this.currentPos = new Location();
        this.favouritePlaces = new Location[6];
        this.favouritePlaces[0] = new Location();
        this.knownPeriods = new HashMap<SinglePeriod, Weather>();
        this.forecaster = new Forecaster();
        this.weatherChanged = new WeatherChanged();

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

    public void readWeatherInfo() throws IOException, ClassNotFoundException{
        File f = new File("D:\\weathersource.ddw");
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
            boolean firstIteration = true;

            Date readTime1 = (Date) ois.readObject();
            Date readTime2 = (Date) ois.readObject();
            readHumidity = ois.readDouble();
            readTemperature = ois.readDouble();
            readWindSpeed = ois.readDouble();
            readPressure = ois.readDouble();

            readPrecipitation = (Weather.Precipitation) ois.readObject();
            readCloudiness = (Weather.Cloudiness) ois.readObject();

            if (!firstIteration)
                if (readPrecipitation == this.knownPeriods.get(singlePeriod).getPrecipitation()) {
                    if (Math.abs(readTemperature - weather.getTemperature()) <= weatherChanged.getDeltaTemperature()){
                        this.knownPeriods.remove(singlePeriod);
                        singlePeriod.setTimeEnd(readTime2);
                        this.knownPeriods.put(singlePeriod, weather);

                        continue;
                    }
                }

            weather = new Weather(readHumidity, readTemperature, readWindSpeed, readPressure, readPrecipitation, readCloudiness);
            singlePeriod = new SinglePeriod(readTime1, readTime2);
            this.knownPeriods.put(singlePeriod, weather);
            firstIteration = false;
        }

    }

}
