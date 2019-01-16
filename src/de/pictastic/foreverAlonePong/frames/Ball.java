package de.pictastic.foreverAlonePong.frames;

import java.awt.geom.Ellipse2D;

import de.pictastic.foreverAlonePong.helper.Direction;

import de.pictastic.foreverAlonePong.helper.Vector;



@SuppressWarnings("serial")
public class Ball extends Ellipse2D.Double{
	private double ballsize=20;
	private double ballspeed=1.0;
	private Vector vector=new Vector();
	private Direction directionX;
	private Direction directionY;
	
	double lastBallX=getBallX();
	double lastBallY=getBallY();
	


//Constructor
	private double ballX, ballY, velX = 1, velY = 1;
	public Ball() {
		this.x=ballX;
		this.y=ballY;
		this.height=ballsize;
		this.width=ballsize;
		directionX=Direction.RIGHT;
		directionY=Direction.BOTTOM;
	}
	
	//Getter and Setter
	public double getBallspeed() {
		return ballspeed;
	}
	public void setBallspeed(double ballspeed) {
		this.ballspeed = ballspeed;
	}
	public void resetBallspeed() {
		this.ballspeed=0.5;
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
		return ballsize;
	}

	public void setBallSize(double ballsize) {
		this.ballsize = ballsize;
		this.height=ballsize;
		this.width=ballsize;
	}

	public Vector getVector() {
		return vector;
	}
	public void setVector(Vector vector) {
		this.vector = vector;
	}
	
	
	public Direction getDirectionX() {
		return directionX;
	}

	public void setDirectionX(Direction directionX) {
		this.directionX = directionX;
	}

	public Direction getDirectionY() {
		return directionY;
	}

	public void setDirectionY(Direction directionY) {
		this.directionY = directionY;
	}
	
	

	public double getLastBallX() {
		return lastBallX;
	}

	public void setLastBallX(double lastBallX) {
		this.lastBallX = lastBallX;
	}

	public double getLastBallY() {
		return lastBallY;
	}

	public void setLastBallY(double lastBallY) {
		this.lastBallY = lastBallY;
	}

	/*
	 * Starts the ball movement and calculates the Vector
	 */
	public void move() {
		lastBallX=getBallX();
		lastBallY=getBallY();
		double newBallX=getBallX()+getVelX()*ballspeed;
		double newBallY=getBallY()+getVelY()*ballspeed;
		vector.calcVector(newBallX, newBallY,getBallX(), getBallY());
		
		setBallX(newBallX);
		setBallY(newBallY);
		
		
	}
	
	/**
	 * Makes the ballmovement faster
	 */
	public void faster() {
		this.ballspeed+=0.2;
	}
	/*
	 * Invertes the Y-Direction of the Ball
	 */
	public void invertDirectionY() {
		setVelY(-getVelY());
		if(getVelY()<0) {
			directionY=Direction.TOP;
		}
		if(getVelY()>0) {
			directionY=Direction.BOTTOM;
		}
	}
	/*
	 * Invertes the X-Direction of the Ball
	 */
	public void invertDirectionX() {
		setVelX(-getVelX());
		if(getVelX()<0) {
			directionX=Direction.LEFT;
		}
		if(getVelX()>0) {
			directionX=Direction.RIGHT;
		}
	}
	


	
	
	
	
	



}