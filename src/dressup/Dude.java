package ua.dudeweather.dressup;

import ua.dudeweather.Weather;

import javax.swing.*;
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

    public void draw(JTextArea textArea){
        textArea.setText("");
        textArea.append(headwear.getString()+"\n");
        textArea.append(bodywear.getString()+"\n");
        textArea.append(legswear.getString()+"\n");
        textArea.append(footwear.getString()+"\n");
        textArea.append(accessories.getString()+"\n");
    }

    public void choose_cloth(Weather currentWeather) {
        Headwear cap = Headwear.createCap();
        Headwear none = Headwear.createNone();
        Headwear warmHat = Headwear.createWarmHat();
        ArrayList<Headwear> listHeadwear = new ArrayList<Headwear>();
        listHeadwear.add(cap); listHeadwear.add(none); listHeadwear.add(warmHat);
        headwear = chooseFromList(listHeadwear, currentWeather);

        Bodywear coat = Bodywear.createCoat();
        Bodywear jacket = Bodywear.createJacket();
        Bodywear winterJacket = Bodywear.createWinterJacket();
        Bodywear tshirt = Bodywear.createTshirt();
        ArrayList<Bodywear> listBodywear = new ArrayList<Bodywear>();
        listBodywear.add(coat); listBodywear.add(jacket); listBodywear.add(winterJacket); listBodywear.add(tshirt);
        bodywear = chooseFromList(listBodywear, currentWeather);

        Legswear pants = Legswear.createPants();
        Legswear shorts = Legswear.createShorts();
        ArrayList<Legswear> listLegswear = new ArrayList<Legswear>();
        listLegswear.add(pants); listLegswear.add(shorts);
        legswear = chooseFromList(listLegswear, currentWeather);

        Footwear boots = Footwear.createBoots();
        Footwear sandals = Footwear.createSandals();
        Footwear sneakers = Footwear.createSneakers();
        ArrayList<Footwear> listFootwear = new ArrayList<Footwear>();
        listFootwear.add(boots); listFootwear.add(sandals); listFootwear.add(sneakers);
        footwear = chooseFromList(listFootwear, currentWeather);

        Accessories sunglasses = Accessories.createSunglasses();
        Accessories umbrella = Accessories.createUmbrella();
        ArrayList<Accessories> listAccessories = new ArrayList<Accessories>();
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
