package ua.dudeweather;

import java.io.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 06.05.12
 * Time: 21:42
 * To change this template use File | Settings | File Templates.
 */
public class WriteBinFile {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        File f = new File("/media/sdb4/weathersource2.ddw");
        /*if (!f.exists())
            f.createNewFile();
        FileOutputStream fos = new FileOutputStream(f, true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Date timeBegin = new Date(2012, 5, 6, 12, 0);
        Date timeEnd = new Date(2012, 5, 6, 14, 0);

        double humidity = 60;
        double temperature = 0;
        double windSpeed = 5;
        double pressure =760;
        Weather weather = new Weather(humidity, temperature, windSpeed, pressure, Weather.Precipitation.NONE, Weather.Cloudiness.BKN);
        SinglePeriod singlePeriod = new SinglePeriod(timeBegin, timeEnd);

        writeToFile(weather, singlePeriod, oos);
        timeBegin = new Date(2012, 5, 6, 14, 0);
        timeEnd = new Date(2012, 5, 6, 16, 0);
        singlePeriod = new SinglePeriod(timeBegin, timeEnd);
        weather.setTemperature(-1);
        writeToFile(weather, singlePeriod, oos);

        timeBegin = new Date(2012, 5, 6, 16, 0);
        timeEnd = new Date(2012, 5, 6, 17, 30);
        singlePeriod = new SinglePeriod(timeBegin, timeEnd);
        weather.setTemperature(2);
        weather.setPrecipitation(Weather.Precipitation.SNOW);
        writeToFile(weather, singlePeriod, oos);

        oos.close();
        fos.close();
                                 */
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (fis.available() != 0) {
            Date readTime = (Date) ois.readObject();
            Date readTime2 = (Date) ois.readObject();
            double readHumidity = ois.readDouble();
            double readTemperature = ois.readDouble();
            double readWindSpeed = ois.readDouble();
            double readPressure = ois.readDouble();
    
            Weather.Precipitation readPrecipitation = (Weather.Precipitation) ois.readObject();
            Weather.Cloudiness readCloudiness = (Weather.Cloudiness) ois.readObject();
            System.out.println(readTime.getDate() + " of " + readTime.getMonth() + ", " + readTime.getYear());
            System.out.println(readTime.getHours() + "hrs " + readTime.getMinutes() + "min - " + readTime2.getHours() + "hrs " + readTime2.getMinutes() + "min");
            System.out.print("Temperature: " + readTemperature + "C\n");
            System.out.println("Precipitation:" + readPrecipitation.toString() + "\nCloudiness: " + readCloudiness.toString() + '\n');
        }
        fis.close();
        ois.close();
    }

                        /*
}
    public static void writeToFile(Weather weather, SinglePeriod singlePeriod, ObjectOutputStream oos) throws IOException{
        oos.writeObject(singlePeriod.getTimeBegin());
        oos.writeObject(singlePeriod.getTimeEnd());
        oos.writeDouble(weather.getHumidity());
        oos.writeDouble(weather.getTemperature());
        oos.writeDouble(weather.getWindSpeed());
        oos.writeDouble(weather.getPressure());
        oos.writeObject(weather.getPrecipitation());
        oos.writeObject(weather.getCloudiness());
    }                 */
}


