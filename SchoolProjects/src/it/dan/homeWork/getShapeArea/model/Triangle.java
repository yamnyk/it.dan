package it.dan.homeWork.getShapeArea.model;

public class Triangle extends MyShape{
	private int aSide, bSide, cSide;

	public int getASide() {
		return aSide;
	}

	public void setASide(int aSide) {
		this.aSide = aSide;
	}

	public int getBSide() {
		return bSide;
	}

	public void setBSide(int bSide) {
		this.bSide = bSide;
	}

	public int getCSide() {
		return cSide;
	}

	public void setCSide(int cSide) {
		this.cSide = cSide;
	}

	@Override
	public int area() {
		int s = (aSide + bSide + cSide) / 2;
		if(s > aSide && s > bSide && s > cSide){
			return (int) Math.sqrt(s * (s - aSide) * (s - bSide) * (s - cSide));
		} else {
			return -1;
		}
	}

	public Triangle() {
	}

	public Triangle(int aSide, int bSide, int cSide) {
		this.aSide = aSide;
		this.bSide = bSide;
		this.cSide = cSide;
	}
}
