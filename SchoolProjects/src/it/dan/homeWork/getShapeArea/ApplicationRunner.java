package it.dan.homeWork.getShapeArea;

import it.dan.homeWork.getShapeArea.model.Circle;
import it.dan.homeWork.getShapeArea.model.Rectangle;
import it.dan.homeWork.getShapeArea.model.Triangle;
import it.dan.homeWork.getShapeArea.service.ShapeSet;

public class ApplicationRunner {
    public static void main(String[] args) {
        ShapeSet<Triangle> trSet = new ShapeSet<>();
        trSet.add(new Triangle(20,18,21));
        trSet.add(new Triangle(10,8,9));
        trSet.add(new Triangle(10,13,10));
        trSet.add(new Triangle(5,3,5));

        String appDir = "/home/yamnyk/Downloads";
        String fileName = "triangleSet";
        ShapeSet.toXMLFile(trSet, appDir, fileName);

        ShapeSet<Circle> circleSet = new ShapeSet<>();
        circleSet.add(new Circle(45));
        circleSet.add(new Circle(5));
        circleSet.add(new Circle(25));
        circleSet.add(new Circle(8));
        circleSet.add(new Circle(11));

        String fileName1 = "circleSet";
        ShapeSet.toXMLFile(trSet, appDir, fileName1);

        ShapeSet<Rectangle> rectangleSet = new ShapeSet<>();
        rectangleSet.add(new Rectangle(8,16));
        rectangleSet.add(new Rectangle(5,1));
        rectangleSet.add(new Rectangle(7,18));
        rectangleSet.add(new Rectangle(23,27));
        rectangleSet.add(new Rectangle(13,9));
        rectangleSet.add(new Rectangle(1,11));

        String fileName2 = "rectangleSet";
        ShapeSet.toXMLFile(trSet, appDir, fileName2);
    }

}
