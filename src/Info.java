package ua.dudeweather;

import java.util.ArrayList;
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


    public Info() {
        this.navigator = new Navigator();
        this.currentPos = new Location();
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
}
