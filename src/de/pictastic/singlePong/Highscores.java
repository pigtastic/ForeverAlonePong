package de.pictastic.singlePong;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * displays the highscores list on this system after the game
 */
public class Highscores extends JPanel

{
    /** Attributes */

    /**
     * 
     */
    private LinkedList<Highscore> highscores;

    /**
     * Operation Highscores
     *
     * @param player -
     * @param score  -
     * @return
     */
    public Highscores(Highscore playedHighscore)
    {
		JButton start = new JButton("Go Back to Start");
		add(start);
		start.addActionListener(l->{

			
		});
    }
}
