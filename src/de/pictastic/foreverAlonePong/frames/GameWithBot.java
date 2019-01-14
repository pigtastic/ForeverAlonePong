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

import de.pictastic.foreverAlonePong.helper.MusicPlayer;
import de.pictastic.foreverAlonePong.helper.Vector;


@SuppressWarnings("serial")
public class GameWithBot extends JPanel implements ActionListener, KeyListener {

	private int height, width;
	private Timer t = new Timer(5, this);
	private boolean first;

	public HashSet<String> keys = new HashSet<String>();

	private CardLayout cardlayout;
	private JPanel panel;

	// pad
	private int padSpeed = 2;
	private int padH = 10, padW = 40;
	private int bottomPadX, topPadX;;
	private int inset = 10;
	

	// ball
	Ball ball =new Ball();
	
	
	// triangle
	Vector leftVector= new Vector();
	Vector rightVector= new Vector();
	


	// score
	private int score;

	public GameWithBot(JPanel pnlMain, CardLayout cardlayout) {
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
			bottomPadX = width / 2 - padW / 2;
			topPadX = width / 2 - padW / 2;
			ball.setBallX(width/2);
			ball.setBallY(100 - ball.getBallSize() / 2);
			t.start();
			first = false;
			score = 0;
			ball.resetBallspeed();
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		height = getHeight();
		width = getWidth();

		// bottom pad
		Rectangle2D bottomPad = new Rectangle(bottomPadX, height - padH - inset, padW, padH);
		g2d.fill(bottomPad);
		
		
		// top pad
				Rectangle2D topPad = new Rectangle(topPadX, inset, padW, padH);
				g2d.fill(topPad);

		// ball
		// initial positioning
		startPosition();
		g2d.fill(ball);



		// score
		String scoreTemp = new Integer(score).toString();
		g2d.setFont(new Font(g2d.getFont().getFontName(), Font.PLAIN, 80));
		g2d.drawString(scoreTemp, width - 70 * scoreTemp.length(), 90);



	}

	


	@Override
	public void actionPerformed(ActionEvent e) {
		// side walls

		if (ball.getBallX() < 0 || ball.getBallX() > width - ball.getBallSize()) {
			ball.invertDirectionX();


		}




		// top wall

		if (ball.getBallY() < 0) {
			ball.invertDirectionY();
			
		}

		// down wall
		if (ball.getBallY() - ball.getBallSize() > height) {

			gameLose();

		}
		// top Pad
		if (ball.getBallY() <= padH + inset && ball.getVelY() < 0)
			if (ball.getBallX() + ball.getBallSize() >= topPadX && ball.getBallX() <= topPadX + padW)
			{
				MusicPlayer.playMusic("./AppData/Sounds/FAP_Right.wav");
				ball.invertDirectionY();
			}
		//  bottompad
		if (ball.getBallY() + ball.getBallSize() >= height - padH - inset && ball.getBallY() + ball.getBallSize() <= height - padH - inset+1 && ball.getVelY() > 0)
			if (ball.getBallX() + ball.getBallSize() >= bottomPadX && ball.getBallX() <= bottomPadX + padW) {
				ball.invertDirectionY();
				MusicPlayer.playMusic("./AppData/Sounds/FAP_Right.wav");
				score++;
				ball.faster();
			}
				

		ball.move();
		
		

		// pressed keys
		if (keys.size() == 1) {
			if (keys.contains("LEFT")) {
				bottomPadX -= (bottomPadX > 0) ? padSpeed : 0;
			} else if (keys.contains("RIGHT")) {
				bottomPadX += (bottomPadX < width - padW) ? padSpeed : 0;
			}
		}
		
		neverlooseAI();

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
	
	
	public void neverlooseAI() {
		double delta = ball.getBallX() - topPadX;
		if (delta > 0) {
			topPadX += (topPadX < width - padW) ? padSpeed : 0;
		}
		else if (delta < 0) {
			topPadX -= (topPadX > 0) ? padSpeed : 0;
		}
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}