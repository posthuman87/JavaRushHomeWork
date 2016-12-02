package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 21.08.2016.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> list = new ArrayList<>();
        try{
            int pageNumber = 0;
            Document document;
            do{
                document = getDocument(searchString, pageNumber++);
                if (document==null) break;

                Elements elements = document.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy");

                if(!elements.isEmpty()){
                    for (Element element : elements)
                    {
                        Vacancy vac = new Vacancy();
                        String salary=element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
                        vac.setCity(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-address").text());
                        vac.setCompanyName(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-employer").text());
                        vac.setSalary(salary != null ? salary : "");
                        vac.setSiteName("http://hh.ua");
                        vac.setUrl(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-title").attr("href"));
                        vac.setTitle(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-title").text());
                        list.add(vac);
                    }
                } else break;
            } while(true);
        }
        catch(IOException ex){}
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException{
        String url = String.format(URL_FORMAT,searchString,page);
        Document document = Jsoup.connect(url).userAgent("Chrome/47.0.2526.80").referrer("http://hh.ua").get();
        return document;
    }
}
