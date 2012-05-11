package ua.dudeweather.dressup;

import ua.dudeweather.Weather;

import java.util.ArrayList;
import java.util.Iterator;

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
        Headwear cap = Headwear.createCap();
        Headwear none = Headwear.createNone();
        Headwear warmHat = Headwear.createWarmHat();
        ArrayList<Headwear> listHeadwear = new ArrayList<>();
        listHeadwear.add(cap); listHeadwear.add(none); listHeadwear.add(warmHat);
        headwear = chooseFromList(listHeadwear, currentWeather);

        Bodywear coat = Bodywear.createCoat();
        Bodywear jacket = Bodywear.createJacket();
        Bodywear winterJacket = Bodywear.createWinterJacket();
        ArrayList<Bodywear> listBodywear = new ArrayList<>();
        listBodywear.add(coat); listBodywear.add(jacket); listBodywear.add(winterJacket);
        bodywear = chooseFromList(listBodywear, currentWeather);

        Legswear pants = Legswear.createPants();
        Legswear shorts = Legswear.createShorts();
        ArrayList<Legswear> listLegswear = new ArrayList<>();
        listLegswear.add(pants); listLegswear.add(shorts);
        legswear = chooseFromList(listLegswear, currentWeather);

        Footwear boots = Footwear.createBoots();
        Footwear sandals = Footwear.createSandals();
        Footwear sneakers = Footwear.createSneakers();
        ArrayList<Footwear> listFootwear = new ArrayList<>();
        listFootwear.add(boots); listFootwear.add(sandals); listFootwear.add(sneakers);
        footwear = chooseFromList(listFootwear, currentWeather);

        Accessories sunglasses = Accessories.createSunglasses();
        Accessories umbrella = Accessories.createUmbrella();
        ArrayList<Accessories> listAccessories = new ArrayList<>();
        listAccessories.add(sunglasses); listAccessories.add(umbrella);
        accessories = chooseFromList(listAccessories, currentWeather);
    }

    private <T extends Clothes> T chooseFromList(ArrayList<T> list, Weather weather) {
        for (T currCloth : list) {
            if (currCloth.fits(weather)) {
                return currCloth;
            }
        }
        if (list.get(0) instanceof Accessories)
            return (T) Accessories.noAccessories();
        return list.get(0);
    }
}
