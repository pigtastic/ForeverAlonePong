package de.pictastic.foreverAlonePong.frames;

import java.awt.CardLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import de.pictastic.foreverAlonePong.highscore.Highscore;
import de.pictastic.foreverAlonePong.highscore.HighscoreWriter;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private static String activePane;
	private CardLayout cardlayout;
	private JPanel pnlMain = new JPanel();
	private static Highscores s;
	private static StartMenu sm;
	private static Game g;
	public static Replay r;
	public static GameWithBot gwb;

	public MainFrame() throws IOException {
		// Frame Settings
		setTitle("Pong");
		setSize(400, 700);
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		add(pnlMain);

		// Layout Settings Main Panel
		cardlayout = new CardLayout();
		pnlMain.setLayout(cardlayout);

		// add Panels to MainPanel
		g = new Game(pnlMain, cardlayout);
		s = new Highscores(pnlMain, cardlayout);
		sm = new StartMenu(pnlMain, cardlayout);
		r = new Replay(pnlMain, cardlayout);
		gwb = new GameWithBot(pnlMain, cardlayout);

		pnlMain.add(sm, "StartMenu");
		pnlMain.add(g, "Game");
		pnlMain.add(gwb, "GameWithBot");
		pnlMain.add(s, "Highscores");
		pnlMain.add(r, "Replay");

		// show default Panel
		cardlayout.show(pnlMain, "StartMenu");
		MainFrame.setActivePane("StartMenu");
		validate();

		// add Listeners
		addKeyListener(g);
		addKeyListener(r);
		addKeyListener(gwb);
	}

	public static void saveScore(int score) {
		r.displayScore(score);
		s.addNewScore(new Highscore(sm.getPlayername(), score));
		try {
			HighscoreWriter.writeScores(s.getScores());
			System.out.println("Score gespeichert!");
		} catch (IOException e1) {
			System.out.println("Scores konnten nicht gespeichert werden!");
			e1.printStackTrace();
		}

	}

	public static void setActivePane(String s) {
		activePane = s;
	}

	public static String getActivePane() {
		return activePane;
	}

}
