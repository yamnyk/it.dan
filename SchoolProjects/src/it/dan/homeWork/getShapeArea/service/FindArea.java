package it.dan.homeWork.getShapeArea.service;

import it.dan.homeWork.getShapeArea.model.Circle;
import it.dan.homeWork.getShapeArea.model.Rectangle;
import it.dan.homeWork.getShapeArea.model.Triangle;

public class FindArea {
    public static void main(String[] args) {
        Triangle abc = new Triangle();
        abc.setASide(8);
        abc.setBSide(9);
        abc.setCSide(15);
        printAreaOfTriangle(abc);

        Circle o = new Circle();
        o.setRadius(83);
        printAreaOfCircle(o);

        Rectangle ab = new Rectangle();
        ab.setHeight(1920);
        ab.setWidth(1080);
        printAreaOfRectangle(ab);

    }

    private static void printAreaOfRectangle(Rectangle ab) {
        if(ab.area() > 0){
            System.out.printf("The area of rectangle width = %d, height = %d is: %d",
                    ab.getWidth(), ab.getHeight(), ab.area());
        } else {
            System.out.println("Uncorrected parameter");
        }
    }

    private static void printAreaOfCircle(Circle o) {
        if(o.area() > 0){
            System.out.printf("The area of circle with radius %d is: %d \n", o.getRadius(), o.area());
        } else {
            System.out.println("Uncorrected parameter");
        }
    }

    private static void printAreaOfTriangle(Triangle abc) {
        if(abc.area() != -1){
            System.out.printf("The area of triangle %d, %d, %d is: %d \n",
                    abc.getASide(), abc.getBSide(), abc.getCSide(), abc.area());
        } else {
            System.out.println("Uncorrected parameter");
        }
    }
}
