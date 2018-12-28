package de.pictastic.singlePong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


//Panel zum Start des Spiels mit Player namenseingabe für Highscore

 
public class StartMenu extends JPanel implements KeyListener{

	public StartMenu() {
		add(new JLabel("this is StartMenuPane"));
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		JButton start = new JButton("Start");
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
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
