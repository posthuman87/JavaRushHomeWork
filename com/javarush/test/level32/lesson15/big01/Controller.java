package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Администратор on 11.10.2016.
 */
public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public static void main(String[] args)
    {
        View view1 = new View();
        Controller controller = new Controller(view1);
        view1.setController(controller);
        view1.init();
        controller.init();

    }

    public void resetDocument(){
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text){
        resetDocument();
        StringReader stringReader = new StringReader(text);
        try
        {
            new HTMLEditorKit().read(stringReader, document, 0);
        }
        catch(Exception e){
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        try
        {
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        }
        catch(Exception e){ExceptionHandler.log(e);}
        return stringWriter.toString();
    }

    public HTMLDocument getDocument()
    {
        return document;
    }

    public Controller(View view)
    {
        this.view = view;
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int n = jFileChooser.showOpenDialog(view);
        if (n == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try(FileReader fileReader = new FileReader(currentFile)){
                new HTMLEditorKit().read(fileReader, document,0);
                view.resetUndo();
            }
            catch(Exception e){
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument(){
        if (currentFile == null){
            saveDocumentAs();
        } else
        {
            view.selectHtmlTab();
            try(FileWriter fileWriter = new FileWriter(currentFile)){
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {

        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int n = jFileChooser.showSaveDialog(view);
        if (n == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }


}
