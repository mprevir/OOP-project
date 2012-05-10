package ua.dudeweather;

import ua.dudeweather.dressup.Coat;
import ua.dudeweather.dressup.Dude;

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
        info1.readWeatherInfo("D:\\weathersource2.ddw");
        //TODO: iterator
        System.out.println(info1.getKnownPeriods().size());

        Dude dude = new Dude();

        int curDay = 6; int curHours = 15; int curMin = 0;
        Date curDate = new Date(2012, 5, curDay, curHours, curMin);
        dude.choose_cloth(info1.getKnownPeriods().get(curDate));

    }

    public SinglePeriod getCurrentPeriod(Map<SinglePeriod, Weather> knownPeriods, Date curDate) {
        Iterator it = knownPeriods.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            SinglePeriod chkPeriod = (SinglePeriod) pairs.getKey();
            if (curDate.after(chkPeriod.getTimeBegin()) && curDate.before(chkPeriod.getTimeEnd()))
                return chkPeriod;
        }

        //TODO: throw exeption AllouYobaNetuInfy
        return null;
    }

    private Info info;
}
