package com.javarush.test.level34.lesson08.bonus01;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (!cache.containsKey(key)){
           cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));//TODO add your code here
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        try
        {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);

            cache.put((K)method.invoke(obj), obj);
            return cache.containsKey((K)method.invoke(obj));
        }
        catch(Exception ignore){}//TODO add your code here
        return false;
    }

    public int size() {
        return cache.size();
    }
}
