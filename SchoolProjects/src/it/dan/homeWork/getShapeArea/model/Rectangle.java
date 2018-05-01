package it.dan.homeWork.getShapeArea.model;

public class Rectangle extends MyShape {
    private int height, width;

    public Rectangle(){
    }

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int area() {
        return height * width;
    }
}
