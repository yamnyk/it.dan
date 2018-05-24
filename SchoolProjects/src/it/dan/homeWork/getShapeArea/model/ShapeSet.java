package it.dan.homeWork.getShapeArea.model;

import it.dan.homeWork.getShapeArea.model.MyShape;

import java.util.ArrayList;

public class ShapeSet extends MyShape {

    public ArrayList<MyShape> set = new ArrayList<>();

    @Override
    public int getArea() {
        int area = 0;
        for (MyShape iterShape : set) {
            area += iterShape.getArea();
        }
        return area;
    }
}
