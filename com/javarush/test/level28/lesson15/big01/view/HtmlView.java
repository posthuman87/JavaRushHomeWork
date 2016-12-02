package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

/**
 * Created by Администратор on 24.08.2016.
 */
public class HtmlView implements View
{
    private Controller controller;
    private final String filePath = "./src/"+this.getClass().getPackage().getName().replace(".","/")+"/vacancies.html";
    @Override
    public void update(List<Vacancy> vacancies)
    {
        try { updateFile(getUpdatedFileContent(vacancies)); } catch (Exception e) { e.printStackTrace(); System.out.println("Some exception occurred"); }
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Kiev");
    }

    private String getUpdatedFileContent(List<Vacancy> vacanses){
        String fileContent = null;
        try
        {
            Document document = getDocument();
            Element elementOrig = document.getElementsByClass("template").first();
            Element elementCopy = elementOrig.clone();
            elementCopy.removeClass("template").removeAttr("style");

            document.select("tr[class=vacancy]").remove();

            for (Vacancy vacanse : vacanses)
            {
                Element teg = elementCopy.clone();
                teg.getElementsByAttributeValue("class", "city").get(0).text(vacanse.getCity());
                teg.getElementsByAttributeValue("class", "companyName").get(0).text(vacanse.getCompanyName());
                teg.getElementsByAttributeValue("class", "salary").get(0).text(vacanse.getSalary());
                Element link = teg.getElementsByTag("a").get(0);
                link.text(vacanse.getTitle());
                link.attr("href", vacanse.getUrl());
                elementOrig.before(teg.outerHtml());
            }
            fileContent = document.html();
        }
        catch(IOException e){
            e.printStackTrace();
            fileContent = "Some exception occurred";
        }
        return fileContent;
    }

    private void updateFile(String fil)throws IOException{
        try {
            BufferedWriter fWriter = new BufferedWriter(new FileWriter(filePath));
            fWriter.write(fil);
            fWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException{
        File file = new File(filePath);
        Document doc = Jsoup.parse(file, "UTF-8");
        return doc;
    }
}
