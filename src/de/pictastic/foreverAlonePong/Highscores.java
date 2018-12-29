package de.pictastic.foreverAlonePong;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * displays the highscores list on this system after the game
 */
public class Highscores extends JPanel implements ActionListener{
	private JButton start;
	
    private LinkedList<Highscore> highscores;

	JPanel panel;
	CardLayout cardLayout;
	//Constructor
	public Highscores(JPanel panel, CardLayout cardLayout) {
		this.cardLayout = cardLayout;
		this.panel = panel;
		start = new JButton("Go Back to Start");
		add(start);
		start.addActionListener(this);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals (start)) {

		}
		
	}
}
