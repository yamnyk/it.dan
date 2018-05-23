package it.dan.homeWork.getShapeArea;

import it.dan.homeWork.getShapeArea.model.Circle;
import it.dan.homeWork.getShapeArea.model.Rectangle;
import it.dan.homeWork.getShapeArea.model.Triangle;
import it.dan.homeWork.getShapeArea.service.ShapeSet;
import it.dan.homeWork.getShapeArea.service.XMLSerializer;

public class ApplicationRunner {
    public static void main(String[] args) {
        ShapeSet shapes = new ShapeSet();
        shapes.set.add(new Circle(8));
        shapes.set.add(new Rectangle(33,17));
        shapes.set.add(new Triangle(8,5,5));
        XMLSerializer XMLizer = new XMLSerializer();
        XMLizer.serialize(shapes, "/home/yamnyk/Downloads", "shapeSet.xml");
    }

}
