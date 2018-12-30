package de.pictastic.foreverAlonePong;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.concurrent.locks.Condition;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Game extends JPanel implements  ActionListener, KeyListener {
	
	private int height, width;
	private Timer t = new Timer(10, this);
	private boolean first;
	
	public HashSet<String> keys = new HashSet<String>();
	
	private CardLayout cardlayout;
	private JPanel panel;
	
	// pad
	private final int SPEED = 2;
	private int padH = 10, padW = 40;
	private int PadX;
	private int inset = 10;
	
	// ball
	private double ballX, ballY, velX = 1, velY = 1, ballSize = 20, ballSpeed=1;
	
	// score
	private int  score;
	
	public Game(JPanel pnlMain, CardLayout cardlayout) {
		
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);
		first = true;
		t.setInitialDelay(100);
		this.cardlayout=cardlayout;
		this.panel = pnlMain;
		
	}
	
	protected void startPosition() {
		if (first) {
			PadX = width / 2 - padW / 2;
			ballX = width / 2 - ballSize / 2;
			ballY = 40 - ballSize / 2;
			t.start();
			first = false;
			score = 0;
		}
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		height = getHeight();
		width = getWidth();

		// initial positioning
		startPosition();
		
		//  pad
		Rectangle2D Pad = new Rectangle(PadX, height - padH - inset, padW, padH);
		g2d.fill(Pad);
		
		
		// ball
		Ellipse2D ball = new Ellipse2D.Double(ballX, ballY, ballSize, ballSize);
		g2d.fill(ball);
		
		// score
		String scoreTemp = new Integer(score).toString();
		g2d.setFont(new Font(g2d.getFont().getFontName(),Font.PLAIN,80));
		g2d.drawString(scoreTemp, width - 70*scoreTemp.length(), 90);
		
//		triangle
		Line2D leftSide = new Line2D.Double(0,height,width/2,0);
		Line2D rightSide = new Line2D.Double(width,height,width/2,0);
		g2d.draw(leftSide);
		g2d.draw(rightSide);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// side walls
		if (ballX < 0 || ballX > width - ballSize) {
			velX = -velX;
		}
		// top wall
		if (ballY < 0) {
			velY = -velY;
			
		}
		// down wall
		if (ballY - ballSize > height) {
			t.stop();
			first=true;
			cardlayout.show(panel, "Replay");
			Main.condition.setCondition("AFTERGAME");
			Main.main.validate();
		
		}
		//  pad
		if (ballY + ballSize >= height - padH - inset && ballY + ballSize <= height - padH - inset+1 && velY > 0)
			if (ballX + ballSize >= PadX && ballX <= PadX + padW) {
				velY = -velY;
				score++;
				
			}
				


		ballX += velX*ballSpeed;
		ballY += velY*ballSpeed;
		
		// pressed keys
		if (keys.size() == 1) {
			if (keys.contains("LEFT")) {
				PadX -= (PadX > 0) ? SPEED : 0;
			}
			else if (keys.contains("RIGHT")) {
				PadX += (PadX < width - padW) ? SPEED : 0;
			}
		}
	

		
		repaint();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_LEFT:
			keys.add("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			keys.add("RIGHT");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_LEFT:
			keys.remove("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			keys.remove("RIGHT");
			break;
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	
	
}
