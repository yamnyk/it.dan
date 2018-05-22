package it.dan.homeWork.getShapeArea.service;

import it.dan.homeWork.getShapeArea.model.MyShape;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public abstract class ShapeSet extends MyShape {

    public ArrayList<MyShape> set;

    @Override
    public int getArea() {
        int area = 0;
        for (MyShape iterShape : set) {
            area += iterShape.getArea();
        }
        return area;
    }
}