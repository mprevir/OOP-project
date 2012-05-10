package ua.dudeweather;

import ua.dudeweather.dressup.Dude;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 19.04.12
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws ClassNotFoundException, IOException {
        WeatherChanged weatherChanged1 = new WeatherChanged();
        Navigator navigator1 = new Navigator();
        Forecaster forecaster1 = new Forecaster();
        Location currentPos1 = new Location();
        Weather weather1 = new Weather(50, 15, 3, 760);

        Info info1 = new Info();
        try {
            info1.readWeatherInfo("D:\\weathersource3.ddw");
        } catch (IOException s) {
            return;
        }
        System.out.println(info1.getKnownPeriods().size());

        Dude dude = new Dude();

        int curDay = 6; int curHours = 13; int curMin = 0;
        Date curDate = new Date(2012, 5, curDay, curHours, curMin);
        SinglePeriod curPeriod;
        try {
            curPeriod = info1.getCurrentPeriod(info1.getKnownPeriods(), curDate);
        } catch (NoSuchPeriodException e) {
            System.out.println(e.toString());
            return;
        }
        dude.choose_cloth(info1.getKnownPeriods().get(curPeriod));
        dude.draw();

    }


    private Info info;
}
