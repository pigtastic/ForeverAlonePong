package de.pictastic.foreverAlonePong.frames;

import java.awt.geom.Ellipse2D;

public class Ball extends Ellipse2D.Double{
	private final double BALLSIZE=20;
	private double ballspeed;
	
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
		setBallX(getBallX()+getVelX());
		setBallY(getBallY()+getVelY());
	}
	
	public void changeDirectionY() {
		setVelY(-getVelY());
	}
	public void changeDirectionX() {
		setVelX(-getVelX());
	}
	



}
