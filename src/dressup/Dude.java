package ua.dudeweather.dressup;

import ua.dudeweather.Weather;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 19.04.12
 * Time: 19:18
 * To change this template use File | Settings | File Templates.
 */
public class Dude {
    private Headwear headwear;
    private Bodywear bodywear;
    private Legswear legswear;
    private Footwear footwear;
    private Accessories accessories;

    public void draw(){
        //TODO: draw dude
        headwear.draw();
        bodywear.draw();
        legswear.draw();
        footwear.draw();
        accessories.draw();
    }

    public void choose_cloth(Weather currentWeather) {

    }
}
