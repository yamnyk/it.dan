package it.dan.homeWork.getShapeArea.model;

public class Circle extends MyShape{
	private int radius;
	private final double pi = Math.PI;
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Circle() {
	}
	
	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public int area() {
		double findArea = pi * Math.pow(radius, 2);
		return (int) findArea;
	}
}

 