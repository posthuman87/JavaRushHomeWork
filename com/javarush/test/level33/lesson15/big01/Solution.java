package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 03.11.2016.
 */
public class Solution
{
    public static void main(String[] args)
    {
        StorageStrategy storageStrategy = new HashMapStorageStrategy();
        testStrategy(storageStrategy,1000);
        StorageStrategy biMapStrategy = new OurHashBiMapStorageStrategy();
        testStrategy(biMapStrategy,1000);
        StorageStrategy hashBiMap = new HashBiMapStorageStrategy();
        testStrategy(hashBiMap, 1000);
        StorageStrategy dualBidiMap = new DualHashBidiMapStorageStrategy();
        testStrategy(dualBidiMap,1000);
        StorageStrategy myStategy = new OurHashMapStorageStrategy();
        testStrategy(myStategy,1000);
        StorageStrategy myFileStrategy = new FileStorageStrategy();
        testStrategy(myFileStrategy,1000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> ids = new HashSet<>();
        for (String string : strings)
        {
            ids.add(shortener.getId(string));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> strings = new HashSet<>();
        for (Long key : keys)
        {
            strings.add(shortener.getString(key));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++)
        {
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        long t1 = new Date().getTime();
        Set<Long> ids = getIds(shortener,strings);
        Helper.printMessage(String.valueOf(new Date().getTime() - t1));
        long t2 = new Date().getTime();
        Set<String> str = getStrings(shortener,ids);
        Helper.printMessage(String.valueOf(new Date().getTime() - t2));
        if (str.equals(strings)){
            Helper.printMessage("Тест пройден.");
        } else
        {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
