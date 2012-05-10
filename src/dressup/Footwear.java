package ua.dudeweather.dressup;

import ua.dudeweather.Weather;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 10.05.12
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */
public class Footwear extends Clothes{
    public static Footwear createBoots(){
        Footwear footwear = new Footwear();

        footwear.lowTemperature = -20;
        footwear.highTemperature = 18;
        footwear.suitsAnyPrecip = true;
        footwear.suitsAnyCloud = true;

        footwear.s = "Dude wearing boots";

        return footwear;
    }

    public static Footwear createSneakers(){
        Footwear footwear = new Footwear();

        footwear.lowTemperature = 15;
        footwear.highTemperature = 50;
        footwear.suitsAnyPrecip = false;
        footwear.suitsPrecip = new ArrayList<Weather.Precipitation>();
        footwear.suitsPrecip.add(Weather.Precipitation.NONE);
        footwear.suitsPrecip.add(Weather.Precipitation.DRIZZLE);
        footwear.suitsPrecip.add(Weather.Precipitation.RAIN);
        footwear.suitsAnyCloud = true;
        footwear.s = "Dude wearing sneakers";

        return footwear;
    }

    public static Footwear createSandals(){
        Footwear footwear = new Footwear();

        footwear.lowTemperature = 20;
        footwear.highTemperature = 50;
        footwear.suitsAnyPrecip = false;
        footwear.suitsPrecip = new ArrayList<Weather.Precipitation>();
        footwear.suitsPrecip.add(Weather.Precipitation.NONE);
        footwear.suitsPrecip.add(Weather.Precipitation.DRIZZLE);
        footwear.suitsAnyCloud = true;
        footwear.s = "Dude wearing sandals";

        return footwear;
    }
}
