package de.pictastic.singlePong;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * displays the highscores list on this system after the game
 */
public class Highscores extends JPanel implements ActionListener {
	
	private JButton start;
	JPanel panel;
	CardLayout cardLayout;

	private ArrayList<Highscore> scores = new ArrayList<Highscore>();
/**
 * 
 * @param panel
 * @param cardLayout
 * @param playedHighscore
 */
	public Highscores(JPanel panel, CardLayout cardLayout, Highscore playedHighscore) {
		add(new JLabel("Higscores"));
		this.cardLayout=cardLayout;
		this.panel=panel;
		
		start = new JButton("Go Back to Start");
		add(start);
		start.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(start)) {

		}
	}

	/**
	 * Fügt den Score zur Highscoreliste hinzu, wenn dieser in der Top10 ist.
	 * @param score
	 */
	public void addNewScore(Highscore score) {
		scores.add(score);
		Collections.sort(scores);
		scores.subList(0, 9);
	}

	
}
