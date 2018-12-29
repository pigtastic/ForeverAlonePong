package de.pictastic.foreverAlonePong;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


//Panel zum Start des Spiels mit Player namenseingabe für Highscore

 
public class StartMenu extends JPanel implements ActionListener{

	JButton start = new JButton("Start");
	JPanel panel;
	CardLayout cardLayout;
	
	public StartMenu(JPanel panel, CardLayout cardLayout) {
		add(new JLabel("this is StartMenuPane"));
		start.addActionListener(this);
		add(start);
		this.cardLayout=cardLayout;
		this.panel=panel;


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals (start)) {
			cardLayout.show(panel, "Game");
			Main.main.validate();
		}
		
	}





}
