package it.dan.homeWork.getShapeArea.service;

import it.dan.homeWork.getShapeArea.model.Circle;
import it.dan.homeWork.getShapeArea.model.MyShape;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class ShapeSet<T extends MyShape> extends ArrayList {

    public static void toXMLFile(ShapeSet shapeSet, String appDir, String fileName) {
        //constructing main string will be placed at the top of file
        String mainStr = "<?xml version=\"1.33\" encoding=\"UTF-8\" standalone=\"no\"?>\n\n";
        //generating filePath
        String filePath = getFilePath(appDir, fileName);

        try (FileWriter writer = new FileWriter(filePath);) {
            writer.write(mainStr); //writing down main string to the created file

            //iterate for each shape in ShapeSet and writing its parameters
            for (Object iterShape : shapeSet) {
                writer.write(xmlText(iterShape));
            }
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static String xmlText(Object obj) {
        Class c = obj.getClass();
        StringBuilder str = new StringBuilder();

        str.append("<Shape>\n" //open tag for shape
                + "       <name>" + c.getName() + "</name>\n"); //writing the name of shape

        Field[] fields = c.getFields(); //getting all of shapes fields

        //iterate for each field to write down its name and value
        for (Field i : fields) {
            try {
                //           open tag "fieldName"      field value       close tag "fieldName"
                str.append("        <" + i.getName() + ">" + i.getInt(obj) + "</" + i.getName() + ">\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //writing down the value of shapes getArea
        try {
            //geting method by name and its value for this object
            str.append("       <getArea>" + c.getMethod("getArea").invoke(obj) + "</getArea>\n");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //close tag for shape
        str.append("</Shape>" + "\n\n");

        return str.toString();
    }

    private static String getFilePath(String appDir, String fileName) {
        // creating filepath
        String sep = System.getProperty("file.separator"); //gets the system file separator symbol
        return appDir + sep + fileName; //if file doesn't exist, it will be created
    }
}
