package ua.dudeweather;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 19.04.12
 * Time: 19:43
 * To change this template use File | Settings | File Templates.
 */
public class Location {
    private double longitude;
    private double latitude;
    private String placeName;

    public Location(){
        longitude = 0;
        latitude = 0;
        placeName = "the Gulf of Guinea";

        System.out.println("object Location created");
    }
}
