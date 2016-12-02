package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 07.11.2016.
 */
public class SpeedTest
{
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        long t1 = new Date().getTime();
        for (String string : strings)
        {
            ids.add(shortener.getId(string));
        }
        return new Date().getTime() - t1;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        long t1 = new Date().getTime();
        for (Long id : ids)
        {
            strings.add(shortener.getString(id));
        }
        return new Date().getTime() - t1;
    }

    @Test
    public void testHashMapStorage(){
        Set<String> origStrings = new HashSet<>();
        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();

        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        for (int i = 0; i < 10000; i++)
        {
            origStrings.add(Helper.generateRandomString());
        }

        long t1 = getTimeForGettingIds(shortener1,origStrings,ids1);
        long t2 = getTimeForGettingIds(shortener2,origStrings,ids2);

        Assert.assertTrue(t1 > t2);

        long t3 = getTimeForGettingStrings(shortener1, ids1, new HashSet<String>());
        long t4 = getTimeForGettingStrings(shortener2, ids2, new HashSet<String>());

        Assert.assertEquals(t3,t4,5);
    }
}
