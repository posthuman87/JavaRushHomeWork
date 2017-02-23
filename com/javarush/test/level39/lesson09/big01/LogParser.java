package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.IPQuery;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery{
    private Path logDir;
    private List<String> list;

    public LogParser(Path logDir)
    {
        this.logDir = logDir;
        list = fileStrings();
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before)
    {
        Set<String> ips = getUniqueIPs(after, before);
        return ips.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before)
    {
        return null;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before)
    {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before)
    {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before)
    {
        return null;
    }

    private Set<String> getAllIp(String str, Date after, Date before){
        if (list == null)
            return null;
        Pattern pattern = Pattern.compile("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}");
        for (String s : list)
        {
            if (s.contains(str)){
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()){
                    String ip = matcher.group();
                }
            }
        }
        return null;
    }

    private List<String> fileStrings(){
        //Список строк во всех логах
        List<String> result = new ArrayList<>();
        File dir = logDir.toFile();
        List<File> files = listFilesForFolder(dir);

        for (File file : files)
        {
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                while(reader.ready()){
                    result.add(reader.readLine());
                }
            }
            catch(IOException e){e.printStackTrace();}
        }
        return result;
    }

    private List<File> listFilesForFolder(final File folder)
    {
        List<File> resultList = new ArrayList<>();
        for (final File fileEntry : folder.listFiles())
        {
            if (fileEntry.isDirectory())
            {
                listFilesForFolder(fileEntry);
            } else
            {
                if (fileEntry.getName().endsWith(".log"))
                    resultList.add(fileEntry);
            }
        }
        return resultList;
    }
}
