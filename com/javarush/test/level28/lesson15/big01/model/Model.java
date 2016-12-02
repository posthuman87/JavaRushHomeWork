package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 24.08.2016.
 */
public class Model
{
    private View view;
    private Provider[] providers;

    public Model(View view, Provider...providers)
    {
        if (view==null) throw new IllegalArgumentException();
        if (providers==null||providers.length==0) throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city){
        List<Vacancy> vacanses = new ArrayList<>();
        for (Provider provider : providers)
        {
            for (Vacancy vacancy : provider.getJavaVacancies(city))
            {
                vacanses.add(vacancy);
            }
        }
        view.update(vacanses);
    }
}
