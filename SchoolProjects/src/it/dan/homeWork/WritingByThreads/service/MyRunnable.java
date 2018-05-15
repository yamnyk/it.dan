package it.dan.homeWork.WritingByThreads.service;

import java.io.FileWriter;
import java.io.IOException;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        //creating filepath
        String sep = System.getProperty("file.separator");
        String appDir = "/home/yamnyk/Downloads"; //path to file directory
        String filePath = appDir + sep + "myFirstFile.txt"; //full path to the file

        try {
            FileWriter fw = new FileWriter(filePath, true);
            fw.write("I'm hot, and you are not! " + "Thread name - "
                    + Thread.currentThread().getName() + "\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
