package de.pictastic.singlePong;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private CardLayout cardlayout;
	private JPanel pnlMain=new JPanel();
	private Game g;
	
	public MainFrame() {
		
		setTitle("Pong");
		setSize(400, 700);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cardlayout = new CardLayout();
		pnlMain.setLayout(cardlayout);
		pnlMain.add(new StartMenu(pnlMain, cardlayout),"StartMenu");
		g = new Game(pnlMain, cardlayout);
		addKeyListener(g);
		setFocusable(true);
		pnlMain.add(g,"Game");
		cardlayout.show(pnlMain, "StartMenu");
		add(pnlMain);
		validate();
//		requestFocusInWindow();
	}
	

	


}
