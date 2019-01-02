package de.pictastic.foreverAlonePong.helper;

public class Vector {
	
	double x;
	double y;
	
	public Vector(){
	}
	public Vector(double x, double y){
		this.x=x;
		this.y=y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void calcVector(double x1, double y1, double x2, double y2) {
		this.x=x2-x1;
		this.y=y2-y1;
	}
	@Override
	public String toString() {
		return "Vector [x=" + x + ", y=" + y + "]";
	}
	

	

}
