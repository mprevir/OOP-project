package ua.dudeweather.dressup;

import ua.dudeweather.Weather;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 10.05.12
 * Time: 21:50
 * To change this template use File | Settings | File Templates.
 */
public class Bodywear extends Clothes{
    public static Bodywear createJacket(){
        Bodywear bodywear = new Bodywear();

        bodywear.lowTemperature = 10;
        bodywear.highTemperature = 22;
        bodywear.suitsAnyPrecip = true;
        bodywear.suitsAnyCloud = true;

        return bodywear;
    }

    public static Bodywear createCoat(){
        Bodywear bodywear = new Bodywear();

        bodywear.lowTemperature = 5;
        bodywear.highTemperature = 15;
        bodywear.suitsAnyPrecip = false;
        bodywear.suitsPrecip = new ArrayList<Weather.Precipitation>();
        bodywear.suitsPrecip.add(Weather.Precipitation.NONE);
        bodywear.suitsPrecip.add(Weather.Precipitation.DRIZZLE);
        bodywear.suitsPrecip.add(Weather.Precipitation.RAIN);
        bodywear.suitsAnyCloud = true;

        return bodywear;
    }

    public static Bodywear createWinterJacket(){
        Bodywear bodywear = new Bodywear();

        bodywear.lowTemperature = -20;
        bodywear.highTemperature = 5;
        bodywear.suitsAnyPrecip = true;
        bodywear.suitsAnyCloud = true;

        return bodywear;
    }
}
