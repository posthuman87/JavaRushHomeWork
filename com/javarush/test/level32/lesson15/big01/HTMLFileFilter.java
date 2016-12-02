package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Администратор on 21.10.2016.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File f)
    {
        if (f.isDirectory())
            return true;
        else
        {
            String s = f.getName().toLowerCase();
            if(s.endsWith(".html")||s.endsWith(".htm"))
                return true;
            else
                return false;
        }
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
