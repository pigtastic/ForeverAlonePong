package de.pictastic.singlePong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Panel nach GameOver  

public class Replay extends JPanel implements KeyListener{
//	erneutspielen?
//	nein? Highscores anzeigen
	
//	Highscoreeintrag?
	public Replay() {
		add(new JLabel("this is ReplayPane"));
		JButton start = new JButton("Start again");
		add(start);
		start.addActionListener(l->{
			MainFrame.panel=new Game();
			Main.main(null);
			
		});
	}
	
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	


}
