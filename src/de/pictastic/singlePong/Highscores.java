package de.pictastic.singlePong;
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


    public Highscores(Highscore playedHighscore)
    {
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
