package ua.dudeweather.dressup;

import ua.dudeweather.Weather;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 10.05.12
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
public class Accessories extends Clothes{
    public static Accessories createUmbrella(){
        Accessories accessories = new Accessories();

        accessories.lowTemperature = 0;
        accessories.highTemperature = 50;
        accessories.suitsAnyPrecip = false;
        accessories.suitsPrecip.add(Weather.Precipitation.RAIN);
        accessories.suitsAnyCloud = true;

        return accessories;
    }

    public static Accessories createSunglasses(){
        Accessories accessories = new Accessories();

        accessories.lowTemperature = -50;
        accessories.highTemperature = 50;
        accessories.suitsAnyPrecip = true;
        accessories.suitsPrecip.add(Weather.Precipitation.DRIZZLE);
        accessories.suitsPrecip.add(Weather.Precipitation.NONE);
        accessories.suitsAnyCloud = false;
        accessories.suitsCloud.add(Weather.Cloudiness.SKC);
        accessories.suitsCloud.add(Weather.Cloudiness.FEW);

        return accessories;
    }
}
