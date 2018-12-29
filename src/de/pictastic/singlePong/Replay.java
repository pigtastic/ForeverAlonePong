package de.pictastic.singlePong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Panel nach GameOver  

public class Replay extends JPanel implements KeyListener {
//	erneutspielen?
//	nein? Highscores anzeigen

//	Highscoreeintrag?
	public Replay() {
		add(new JLabel("this is ReplayPane"));
		add(new JLabel("Press Space to Replay"));

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		System.out.println("test");
		if (code == KeyEvent.VK_SPACE) {
			System.out.println("leertaste gedrückt");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
