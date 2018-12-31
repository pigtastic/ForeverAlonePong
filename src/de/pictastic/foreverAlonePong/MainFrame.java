package de.pictastic.foreverAlonePong;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainFrame extends JFrame implements ActionListener {
	private CardLayout cardlayout;
	private JPanel pnlMain = new JPanel();
	private Highscores s;
	private StartMenu sm;
	private Game g;
	private Replay r;
	private Timer t = new Timer(10, this);

	public MainFrame() {
		// Frame Settings
		setTitle("Pong");
		setSize(400, 700);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		add(pnlMain);
		t.start();

		// Layout Settings Main Panel
		cardlayout = new CardLayout();
		pnlMain.setLayout(cardlayout);

		// add Panels to MainPanel
		g = new Game(pnlMain, cardlayout);
		s = new Highscores(pnlMain, cardlayout);
		sm = new StartMenu(pnlMain, cardlayout);
		r = new Replay(pnlMain, cardlayout);

		pnlMain.add(sm, "StartMenu");
		pnlMain.add(g, "Game");
		pnlMain.add(s, "Highscores");
		pnlMain.add(r, "Replay");

		// show default Panel
		cardlayout.show(pnlMain, "Highscores");
		validate();

		// add Listeners
		addKeyListener(g);
		addKeyListener(r);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Main.condition.getCondition().equals("AFTERGAME")) {
			addScoreToHighscoreList();
			Main.condition.setCondition("BEFOREGAME");
		}
	}

	public void addScoreToHighscoreList() {
		s.addNewScore(new Highscore(sm.getPlayername(), g.getScore()));
	}

}
