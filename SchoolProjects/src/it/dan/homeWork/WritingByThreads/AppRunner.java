package it.dan.homeWork.WritingByThreads;

import java.io.FileWriter;
import java.io.IOException;

public class AppRunner{
    public static void main(String[] args) {
        //creating filepath
        String sep = System.getProperty("file.separator");
        String path = "/home/yamnyk/Downloads"; //path to file directory
        String filePath = path + sep + "myFirstFile.txt"; //full path to the file

        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write("I'm hot, and you are not! " + "Thread name - \n"
                    + Thread.currentThread().getName());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

