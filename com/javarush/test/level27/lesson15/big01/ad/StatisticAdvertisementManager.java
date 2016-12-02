package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Администратор on 12.08.2016.
 */
public class StatisticAdvertisementManager
{
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    public static StatisticAdvertisementManager getInstance()
    {
        return ourInstance;
    }

    private StatisticAdvertisementManager()
    {
    }

    public Map<String,Integer> getVideos(){
        Map<String, Integer> result = new TreeMap<String, Integer>(new Comparator(){
            @Override
            public int compare(Object o1, Object o2)
            {
                if (o1.toString().toLowerCase().compareTo(o2.toString().toLowerCase()) != 0)
                    return o1.toString().toLowerCase().compareTo(o2.toString().toLowerCase());
                    else
                        return o1.toString().compareTo(o2.toString());
            }
        });

        for (Advertisement advertisement : advertisementStorage.list()){
            result.put(advertisement.getName(),advertisement.getHits());
        }

        return result;
    }

}
