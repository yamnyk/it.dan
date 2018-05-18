package it.dan.homeWork.getShapeArea.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ShapeSet<T extends MyShape> extends ArrayList {
    public void setToXml(ShapeSet<T> shapeSet, String filePath){

        for (Object circle : shapeSet) {
            Circle c = (Circle) circle;

            try (FileWriter fileWriter = new FileWriter(filePath, true)){
                fileWriter.write("<SHAPE> \n");
                String type = "     <TYPE> "+c.getClass()+"</TYPE>\n";
                fileWriter.write(type);
                fileWriter.write("</SHAPE> \n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
