package de.pictastic.singlePong;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	static JPanel panel=new StartMenu();
	
	public MainFrame() {
		setTitle("Pong");
		setContentPane(panel);
		setSize(400, 700);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	


}
