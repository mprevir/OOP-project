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
        ArrayList<Headwear> listHeadwear = new ArrayList<Headwear>();
        listHeadwear.add(cap); listHeadwear.add(none); listHeadwear.add(warmHat);
        int watchSize = listHeadwear.size();
        headwear = chooseFromListHead(listHeadwear, currentWeather);

        Bodywear coat = Bodywear.createCoat();
        Bodywear jacket = Bodywear.createJacket();
        Bodywear winterJacket = Bodywear.createWinterJacket();
        ArrayList<Bodywear> listBodywear = new ArrayList<Bodywear>();
        listBodywear.add(coat); listBodywear.add(jacket); listBodywear.add(winterJacket);
        bodywear = chooseFromListBody(listBodywear, currentWeather);

        Legswear pants = Legswear.createPants();
        Legswear shorts = Legswear.createShorts();
        ArrayList<Legswear> listLegswear = new ArrayList<Legswear>();
        listLegswear.add(pants); listLegswear.add(shorts);
        legswear = chooseFromListLegs(listLegswear, currentWeather);

        Footwear boots = Footwear.createBoots();
        Footwear sandals = Footwear.createSandals();
        Footwear sneakers = Footwear.createSneakers();
        ArrayList<Footwear> listFootwear = new ArrayList<Footwear>();
        listFootwear.add(boots); listFootwear.add(sandals); listFootwear.add(sneakers);
        footwear = chooseFromListFoot(listFootwear, currentWeather);

        Accessories sunglasses = Accessories.createSunglasses();
        Accessories umbrella = Accessories.createUmbrella();
        ArrayList<Accessories> listAccessories = new ArrayList<Accessories>();
        listAccessories.add(sunglasses); listAccessories.add(umbrella);
        accessories = chooseFromListAcc(listAccessories, currentWeather);
    }

    private Headwear chooseFromListHead(ArrayList<Headwear> list, Weather weather) {
        Iterator<Headwear> it = list.iterator();
        while (it.hasNext()) {
            Headwear currCloth = it.next();
            if (currCloth.fits(weather)) return currCloth;
        }
        return list.get(0);
    }

    private Bodywear chooseFromListBody(ArrayList<Bodywear> list, Weather weather) {
        Iterator<Bodywear> it = list.iterator();
        while (it.hasNext()) {
            Bodywear currCloth = it.next();
            if (currCloth.fits(weather)) return currCloth;
        }
        return list.get(0);
    }
    
    private Legswear chooseFromListLegs(ArrayList<Legswear> list, Weather weather) {
        Iterator<Legswear> it = list.iterator();
        while (it.hasNext()) {
            Legswear currCloth = it.next();
            if (currCloth.fits(weather)) return currCloth;
        }
        return list.get(0);
    }

    private Footwear chooseFromListFoot(ArrayList<Footwear> list, Weather weather) {
        Iterator<Footwear> it = list.iterator();
        while (it.hasNext()) {
            Footwear currCloth = it.next();
            if (currCloth.fits(weather)) return currCloth;
        }
        return list.get(0);
    }

    private Accessories chooseFromListAcc(ArrayList<Accessories> list, Weather weather) {
        Iterator<Accessories> it = list.iterator();
        while (it.hasNext()) {
            Accessories currCloth = it.next();
            if (currCloth.fits(weather)) return currCloth;
        }
        return Accessories.noAccessories();
    }

}
