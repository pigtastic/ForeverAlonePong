package de.pictastic.foreverAlonePong;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Panel nach GameOver  

public class Replay extends JPanel implements KeyListener, ActionListener {

	// Panel and Layout
	private JPanel panel;
	private CardLayout cardlayout;

	//Button
	private JButton button = new JButton ("Back to Start");
	
//	erneutspielen?
//	nein? Highscores anzeigen

//	Highscoreeintrag?
	public Replay(JPanel panel, CardLayout cardlayout) {
		this.cardlayout = cardlayout;
		this.panel = panel;
		add(new JLabel("Press Space to Replay"));
		add(button);
		button.addActionListener(this);
		addKeyListener(this);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_SPACE) {
			cardlayout.show(panel, "Game");
			Main.main.validate();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button)) {
			cardlayout.show(panel, "StartMenu");
			Main.main.validate();
		}
		
	}

}
