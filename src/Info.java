package ua.dudeweather;

import java.util.ArrayList;
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
        this.navigator = null;
        this.currentPos = null;
        this.favouritePlaces = null;
        this.knownPeriods = null;
        this.forecaster = null;
        this.weatherChanged = null;

        System.out.println("Everything's fine");
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
