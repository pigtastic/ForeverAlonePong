package de.pictastic.singlePong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * displays the highscores list on this system after the game
 */
public class Highscores extends JPanel implements ActionListener {
	private JButton start;

	private ArrayList<Highscore> scores = new ArrayList<Highscore>();
/**
 * 
 * @param playedHighscore
 */
	public Highscores(Highscore playedHighscore) {
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
	 * Entfernt bei Bedarf den aus Platz 11. fallenden Score.
	 * @param score
	 */
	public void addNewScore(Highscore score) {
		scores.add(score);
		Collections.sort(scores);
		scores.subList(0, 9);
	}

	
}
