package it.dan.homeWork.WritingByThreads.service;

import java.io.FileWriter;
import java.io.IOException;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        String pathToFile = getFilePath("/home/yamnyk/Downloads");
        writeToFile(pathToFile);
    }

    private void writeToFile(String pathToFile) {
        try {
            FileWriter fw = new FileWriter(pathToFile, true); //'true' flag means that old data
                                                                 // will be saved while writing
            fw.write("I'm hot, and you are not! " + "Thread name - "
                    + Thread.currentThread().getName() + "\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFilePath(String appDir) {
        // creating filepath
        String sep = System.getProperty("file.separator"); //gets the system file separator symbol
        return appDir + sep + "myFirstFile.txt"; //if file doesn't exist, it will be created
    }
}
