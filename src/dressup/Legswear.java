package ua.dudeweather.dressup;

import ua.dudeweather.Weather;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 10.05.12
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class Legswear extends Clothes{
    public static Legswear createPants(){
        Legswear legswear = new Legswear();

        legswear.lowTemperature = -20;
        legswear.highTemperature = 20;
        legswear.suitsAnyPrecip = true;
        legswear.suitsAnyCloud = true;

        return legswear;
    }

    public static Legswear createShorts(){
        Legswear legswear = new Legswear();

        legswear.lowTemperature = 20;
        legswear.highTemperature = 50;
        legswear.suitsAnyPrecip = false;
        legswear.suitsPrecip.add(Weather.Precipitation.NONE);
        legswear.suitsPrecip.add(Weather.Precipitation.DRIZZLE);
        legswear.suitsAnyCloud = true;

        return legswear;
    }
}
