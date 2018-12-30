package de.pictastic.foreverAlonePong;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private CardLayout cardlayout;
	private JPanel pnlMain=new JPanel();
	private HighscoresPanel s;
	private StartMenu sm;
	private Game g;
	private Replay r;
	String test;
	
	
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
		s = new HighscoresPanel(pnlMain, cardlayout);
		sm = new StartMenu(pnlMain, cardlayout);
		r = new Replay(pnlMain, cardlayout);
		
		pnlMain.add(sm,"StartMenu");
		pnlMain.add(g,"Game");
		pnlMain.add(s, "Highscores");
		pnlMain.add(r, "Replay");
		
		//show default Panel
		cardlayout.show(pnlMain, "StartMenu");
		validate();
		
		//add Listeners
		addKeyListener(g);
		addKeyListener(r);
	}

	
	public void addScoreToHighscoreList () {
	s.addNewScore(new Highscore(sm.getPlayername(), g.getScore()));
	}
}
