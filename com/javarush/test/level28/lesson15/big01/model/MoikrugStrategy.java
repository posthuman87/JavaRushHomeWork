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
 * Created by Администратор on 26.08.2016.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";


    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> list = new ArrayList<>();
        try{
            int pageNumber = 1;
            Document document;
            do{
                document = getDocument(searchString, pageNumber++);
                if (document==null) break;

                Elements elements = document.getElementsByClass("job");

                if(!elements.isEmpty()){
                    for (Element element : elements)
                    {
                        Vacancy vac = new Vacancy();
                        Element salaryElement = element.getElementsByAttributeValue("class", "salary").first();
                        String salary = "";
                        if (salaryElement != null){
                            salary = salaryElement.text();
                        }
                        vac.setSalary(salary);
                        vac.setCity(element.getElementsByAttributeValue("class","location").text());
                        vac.setCompanyName(element.getElementsByAttributeValue("class","company_name").text());
                        vac.setSiteName("https://moikrug.ru");
                        vac.setUrl("https://moikrug.ru" + element.getElementsByTag("a").first().attr("href"));
                        vac.setTitle(element.getElementsByAttributeValue("class","title").attr("title"));
                        list.add(vac);
                    }
                } else break;
            } while(true);
        }
        catch(IOException ex){}
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, page, searchString);
        Document document = null;
        try {
            document = Jsoup.connect("http://javarush.ru/testdata/big28data2.html")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36")
                    .referrer("http://javarush.ru/")
                    .get(); //Получаем документ по url.
        }
        catch (IOException e) {
        }
        return document;
    }
}
