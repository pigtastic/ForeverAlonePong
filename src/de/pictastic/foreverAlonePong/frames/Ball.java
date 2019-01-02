package de.pictastic.foreverAlonePong.frames;

import java.awt.geom.Ellipse2D;

import de.pictastic.foreverAlonePong.helper.Vector;



@SuppressWarnings("serial")
public class Ball extends Ellipse2D.Double{
	private final double BALLSIZE=20;
	private double ballspeed=1;
	private Vector vector;
	
	public Vector getVector() {
		return vector;
	}
	public void setVector(Vector vector) {
		this.vector = vector;
	}


	private double ballX, ballY, velX = 1, velY = 1;
	public Ball() {
		this.x=ballX;
		this.y=ballY;
		this.height=BALLSIZE;
		this.width=BALLSIZE;
	}
	public double getBallspeed() {
		return ballspeed;
	}
	public void setBallspeed(double ballspeed) {
		this.ballspeed = ballspeed;
	}
	public double getBallX() {
		return this.x;
	}
	public void setBallX(double ballX) {
		this.x = ballX;
	}
	public double getBallY() {
		return this.y;
	}
	public void setBallY(double ballY) {
		this.y = ballY;
	}
	public double getVelX() {
		return velX;
	}
	public void setVelX(double velX) {
		this.velX = velX;
	}
	public double getVelY() {
		return velY;
	}
	public void setVelY(double velY) {
		this.velY = velY;
	}
	public double getBallSize() {
		return BALLSIZE;
	}
	
	
	public void move() {
		double newBallX=getBallX()+getVelX()*ballspeed;
		double newBallY=getBallY()+getVelY()*ballspeed;
		calcDirectionVector(getBallX(), getBallY(),newBallX, newBallY);
		setBallX(newBallX);
		setBallY(newBallY);
		
	}
	public void faster() {
		this.ballspeed+=0.2;
	}
	
	public void invertDirectionY() {
		setVelY(-getVelY());
	}
	public void invertDirectionX() {
		setVelX(-getVelX());
	}
	
	
	public void calcDirectionVector(double x1, double y1, double x2, double y2){
		Vector vector = new Vector(x2-x1,y2-y1);
			this.vector=vector;
	}
	
	
	
	
	



}
