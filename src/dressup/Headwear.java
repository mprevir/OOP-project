package ua.dudeweather.dressup;

import ua.dudeweather.Weather;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 10.05.12
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class Headwear extends Clothes{
    public static Headwear createNone(){
        Headwear headwear = new Headwear();

        headwear.lowTemperature = 10;
        headwear.highTemperature = 50;
        headwear.suitsAnyPrecip = false;
        headwear.suitsPrecip = new ArrayList<Weather.Precipitation>();
        headwear.suitsPrecip.add(Weather.Precipitation.NONE);
        headwear.suitsPrecip.add(Weather.Precipitation.DRIZZLE);
        headwear.suitsPrecip.add(Weather.Precipitation.RAIN);
        headwear.suitsAnyCloud = false;
        headwear.suitsCloud = new ArrayList<Weather.Cloudiness>();
        headwear.suitsCloud.add(Weather.Cloudiness.OVC);
        headwear.suitsCloud.add(Weather.Cloudiness.BKN);
        headwear.suitsCloud.add(Weather.Cloudiness.FEW);
        headwear.s = "Dude not wearing cap";

        return headwear;
    }

    public static Headwear createCap(){
        Headwear headwear = new Headwear();

        headwear.lowTemperature = 10;
        headwear.highTemperature = 50;
        headwear.suitsAnyPrecip = false;
        headwear.suitsPrecip = new ArrayList<Weather.Precipitation>();
        headwear.suitsPrecip.add(Weather.Precipitation.NONE);
        headwear.suitsPrecip.add(Weather.Precipitation.DRIZZLE);
        headwear.suitsPrecip.add(Weather.Precipitation.RAIN);
        headwear.suitsAnyCloud = false;
        headwear.suitsCloud = new ArrayList<Weather.Cloudiness>();
        headwear.suitsCloud.add(Weather.Cloudiness.SKC);
        headwear.suitsCloud.add(Weather.Cloudiness.FEW);
        headwear.s = "Dude wearing cap";

        return headwear;
    }

    public static Headwear createWarmHat(){
        Headwear headwear = new Headwear();

        headwear.lowTemperature = -20;
        headwear.highTemperature = 10;
        headwear.suitsAnyPrecip = true;
        headwear.suitsAnyCloud = true;
        headwear.s = "Dude wearing warm hat";

        return headwear;
    }
}
