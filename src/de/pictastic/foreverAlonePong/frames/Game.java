package de.pictastic.foreverAlonePong.frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;

import javax.swing.JPanel;
import javax.swing.Timer;

import de.pictastic.foreverAlonePong.helper.Vector;

@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener, KeyListener {

	private int height, width;
	private Timer t = new Timer(5, this);
	private boolean first;

	public HashSet<String> keys = new HashSet<String>();

	private CardLayout cardlayout;
	private JPanel panel;

	// pad
	private int padSpeed = 2;
	private int padH = 10, padW = 40;
	private int PadX;
	private int inset = 10;

	// ball
	Ball ball = new Ball();

	// triangle
	Vector leftVector = new Vector();
	Vector rightVector = new Vector();

	// score
	private int score;
	private Line2D leftSide;
	private Line2D rightSide;

	public Game(JPanel pnlMain, CardLayout cardlayout) {
		this.cardlayout = cardlayout;
		this.panel = pnlMain;

		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);
		first = true;
		t.setInitialDelay(100);

		setBackground(Color.BLACK);
		setForeground(Color.WHITE);

	}

	protected void startPosition() {
		if (first) {
			PadX = width / 2 - padW / 2;
			ball.setBallX(width / 2);
			ball.setBallY(100 - ball.getBallSize() / 2);
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

		// pad
		Rectangle2D Pad = new Rectangle(PadX, height - padH - inset, padW, padH);
		g2d.fill(Pad);

		// ball
		// initial positioning
		startPosition();
		g2d.fill(ball);

		// score
		String scoreTemp = new Integer(score).toString();
		g2d.setFont(new Font(g2d.getFont().getFontName(), Font.PLAIN, 80));
		g2d.drawString(scoreTemp, width - 70 * scoreTemp.length(), 90);

//		triangle

		leftSide = new Line2D.Double(0, height, width / 2, 0);
		rightSide = new Line2D.Double(width, height, width / 2, 0);
		// calc Vector
		leftVector.calcVector(width / 2, 0, width, height);
		rightVector.calcVector(width / 2, 0, width, height);

		double leftangle = Vector.angle(leftVector, ball.getVector());
		double rightangle = Vector.angle(rightVector, ball.getVector());

		// TESTING
		System.out.println(leftangle);
		System.out.println(rightangle);
		System.out.println(ball.getVector().toString());

		// TESTING END

		leftSide = new Line2D.Double(0, height, width / 2, 0);
		rightSide = new Line2D.Double(width, height, width / 2, 0);
		g2d.draw(leftSide);
		g2d.draw(rightSide);

	}

	/**
	 * Method to get intersection of Ball and TriangleSide
	 * 
	 * @param x
	 * @param y
	 * @param side
	 * @return
	 */

	private boolean intersection(double x, double y, Line2D side) {
		// Startpunkt
		double x1 = side.getX1();
		double y1 = side.getY1();
		// Endpunkt
		double x2 = side.getX2();
		double y2 = side.getY2();
		// Geradensteigung
		double m = (y2 - y1) / (x2 - x1);
		// Geradengleichung
		double linearEquation = m * (x - x1) + y1;
		if (linearEquation - y < 3 && linearEquation - y > -3) {
			return true;
		} else
			return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// side walls

		if (ball.getBallX() < 0 || ball.getBallX() > width - ball.getBallSize()) {
			ball.invertDirectionX();


		}

		//left triangle side
		if(intersection(ball.getBallX(),ball.getBallY(),leftSide)&&ball.getVelX()<0) {
			
		}
		//right triangle side
		if(intersection(ball.getBallX()+ball.getBallSize(),ball.getBallY()+ball.getBallSize(),rightSide)&&ball.getVelX()>0) {
		}


		// top wall

		if (ball.getBallY() < 0) {
			ball.invertDirectionY();
			
		}

		// down wall
		if (ball.getBallY() - ball.getBallSize() > height) {

			gameLose();

		}

		//  pad
		if (ball.getBallY() + ball.getBallSize() >= height - padH - inset && ball.getBallY() + ball.getBallSize() <= height - padH - inset+1 && ball.getVelY() > 0)
			if (ball.getBallX() + ball.getBallSize() >= PadX && ball.getBallX() <= PadX + padW) {
				ball.invertDirectionY();
				
				score++;
					ball.faster();
			}

		ball.move();
		
		
			
		// pressed keys
		if (keys.size() == 1) {
			if (keys.contains("LEFT")) {
				PadX -= (PadX > 0) ? padSpeed : 0;
			} else if (keys.contains("RIGHT")) {
				PadX += (PadX < width - padW) ? padSpeed : 0;
			}
		}

		repaint();
		
	}

	/**
	 * Method that is called when game is lost
	 */
	private void gameLose() {
		t.stop();
		first = true;
		cardlayout.show(panel, "Replay");
		MainFrame.saveScore();
		MainFrame.setActivePane("Replay");
		Main.main.validate();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

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