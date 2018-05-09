package it.dan.homeWork.WritingByThreads.model;

import java.io.File;
import java.io.Serializable;

public class Item implements Serializable {

    private String filePath;

    public Item() {
    }

    public Item(File textKeeper) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
