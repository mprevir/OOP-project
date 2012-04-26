package ua.dudeweather;

import ua.dudeweather.dressup.Coat;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 19.04.12
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        WeatherChanged weatherChanged1 = new WeatherChanged();
        Navigator navigator1 = new Navigator();
        Forecaster forecaster1 = new Forecaster();
        Location currentPos1 = new Location();

        Info info1 = new Info(currentPos1, weatherChanged1, navigator1, forecaster1);

        Coat coat1 = new Coat();
        coat1.draw();
    }

    private Info info;
}
