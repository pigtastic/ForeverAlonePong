package de.pictastic.foreverAlonePong;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private CardLayout cardlayout;
	private JPanel pnlMain=new JPanel();
	private Game g;
	private Replay r;
	static public String activePane;
	
	public MainFrame() {
		//Frame Settings
		setTitle("Pong");
		setSize(400, 700);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		add(pnlMain);
		
		//Layout Settings Main Panel
		cardlayout = new CardLayout();
		pnlMain.setLayout(cardlayout);
		
		//add Panels to MainPanel
		g = new Game(pnlMain, cardlayout);
		r = new Replay(pnlMain, cardlayout);
		
		pnlMain.add(new StartMenu(pnlMain, cardlayout),"StartMenu");
		pnlMain.add(g,"Game");
		pnlMain.add(new Highscores(pnlMain, cardlayout), "Highscores");
		pnlMain.add(r, "Replay");
		
		//show default Panel
		cardlayout.show(pnlMain, "Replay");
		activePane="StartMenu";
		validate();
		
		//add Listeners
		addKeyListener(g);
		addKeyListener(r);
	}
	
	

	


}
