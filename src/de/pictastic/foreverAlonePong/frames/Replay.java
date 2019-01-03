package de.pictastic.foreverAlonePong.frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;

//Panel nach GameOver  


@SuppressWarnings("serial")
public class Replay extends DefaultJPanel implements KeyListener, ActionListener {
	

	private CardLayout cardlayout;
	private JPanel panel;

	private JButton highscoresbtn = new JButton("HIGHSCORES");
	private JButton backbtn = new JButton ("BACK TO STARTMENU");

	public Replay(JPanel pnlMain, CardLayout cardlayout) {

		this.cardlayout = cardlayout;
		this.panel = pnlMain;

		// Layout Settings
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);

		// Panel Components
		JLabel headline = new JLabel("GAME OVER");
		headline.setForeground(Color.WHITE);
		headline.setFont(new Font("Helvetica", Font.PLAIN, 50));
		headline.setHorizontalAlignment(SwingConstants.CENTER);

		JEditorPane info = new JEditorPane();
		info.setBackground(Color.BLACK);
		info.setForeground(Color.RED);
		info.setOpaque(true);
		info.setFont(new Font("Helvetica", Font.PLAIN, 20));
		info.setContentType("text/plain");
		info.setEditable(false);
		info.setEnabled(true);
		info.setText("Hier kommt später info zum Highscore oder sonst was rein");
		Color bgColor = new Color(0, 0, 0);
		UIDefaults defaults = new UIDefaults();
		defaults.put("EditorPane[Enabled].backgroundPainter", bgColor);
		info.putClientProperty("Nimbus.Overrides", defaults);
		info.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
		info.setBackground(bgColor);

		highscoresbtn.setBackground(Color.BLACK);
		highscoresbtn.setForeground(Color.WHITE);
		highscoresbtn.setFont(new Font("Helvetica", Font.PLAIN, 20));

		JLabel replay = new JLabel("Press Space to Replay");
		replay.setForeground(Color.WHITE);
		replay.setFont(new Font("Helvetica", Font.PLAIN, 20));
		replay.setHorizontalAlignment(SwingConstants.CENTER);

		addComponent(gbl, new JLabel(""), 0, 0, 1, 1, 0.0, 0.5);
		addComponent(gbl, headline, 0, 1, 1, 1, 0.0, 1.0);
		addComponent(gbl, new JLabel(""), 0, 2, 1, 1, 0.0, 0.5);
		addComponent(gbl, info, 0, 3, 1, 1, 1.0, 0.0);
		addComponent(gbl, new JLabel(""), 0, 4, 1, 1, 0.0, 0.5);
		addComponent(gbl, highscoresbtn, 0, 5, 1, 1, 1.0, 0.0, new Insets(20, 0, 20, 0));
		addComponent(gbl, replay, 0, 6, 1, 1, 1.0, 0.0);
		addComponent(gbl, new JLabel(""), 0, 7, 1, 1, 0.0, 1.0);
		
		//add listeners
		highscoresbtn.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(backbtn)) {
			cardlayout.show(panel, "Game");
			MainFrame.setActivePane("Game");
			Main.main.validate();
		}
		if (e.getSource().equals(highscoresbtn)) {
			cardlayout.show(panel, "Highscores");
			MainFrame.setActivePane("Highscores");
			Main.main.validate();
		}

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (MainFrame.getActivePane().equals("Replay")) {
			int code = e.getKeyCode();
			if (code == KeyEvent.VK_SPACE) {
				cardlayout.show(panel, "Game");
				Main.main.validate();
				MainFrame.setActivePane("Game");
			}

		}


	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
