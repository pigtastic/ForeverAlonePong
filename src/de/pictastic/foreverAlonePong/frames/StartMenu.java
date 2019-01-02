package de.pictastic.foreverAlonePong.frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.pictastic.foreverAlonePong.helper.Music;

//Panel zum Start des Spiels mit player namenseingabe für Highscore

@SuppressWarnings("serial")
public class StartMenu extends DefaultJPanel implements ActionListener {

	JPanel panel;
	CardLayout cardLayout;

	JTextField playerinput = new JTextField(10);
	JLabel fail = new JLabel("Hier werden nachher fails angezeigt");
	JButton playbtn = new JButton("PLAY");
	JButton highscoresbtn = new JButton("HIGHSCORES");
	private String playername;

	// Constructor
	public StartMenu(JPanel panel, CardLayout cardLayout) {
		this.cardLayout = cardLayout;
		this.panel = panel;

		// Layout Settings
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);

		// Start Music
		Music.playMusic("./AppData/Sounds/ForeverAloneSound.wav");

		// Panel Components
		JLabel headline1 = new JLabel("FOREVERALONE");
		headline1.setForeground(Color.WHITE);
		headline1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		headline1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel headline2 = new JLabel("PONG");
		headline2.setForeground(Color.WHITE);
		headline2.setFont(new Font("Helvetica", Font.PLAIN, 70));
		headline2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel player = new JLabel("Player");
		player.setForeground(Color.WHITE);
		player.setFont(new Font("Helvetica", Font.PLAIN, 20));
		player.setHorizontalAlignment(SwingConstants.CENTER);

		fail.setForeground(Color.RED);
		fail.setFont(new Font("Helvetica", Font.PLAIN, 16));

		playbtn.setBackground(Color.BLACK);
		playbtn.setForeground(Color.WHITE);
		playbtn.setFont(new Font("Helvetica", Font.PLAIN, 20));

		highscoresbtn.setBackground(Color.BLACK);
		highscoresbtn.setForeground(Color.WHITE);
		highscoresbtn.setFont(new Font("Helvetica", Font.PLAIN, 20));

		// Add Panel Components
		addComponent(gbl, new JLabel(""), 0, 0, 3, 1, 0.0, 0.5);
		addComponent(gbl, headline1, 0, 1, 3, 1, 0.0, 0.0);
		addComponent(gbl, headline2, 0, 2, 3, 1, 0.0, 0.0);
		addComponent(gbl, new JLabel(""), 0, 3, 3, 1, 0.0, 1.0);
		addComponent(gbl, player, 0, 4, 1, 1, 0.0, 0.0);
		addComponent(gbl, playerinput, 1, 4, 1, 1, 0.0, 0.0);
		addComponent(gbl, fail, 0, 5, 3, 1, 0.0, 0.0);
		addComponent(gbl, new JLabel(""), 0, 6, 3, 1, 0.0, 0.2);
		addComponent(gbl, playbtn, 0, 7, 3, 1, 0.0, 0.0);
		addComponent(gbl, new JLabel(""), 0, 8, 3, 1, 0.0, 0.2);
		addComponent(gbl, highscoresbtn, 0, 9, 3, 1, 0.0, 0.0);
		addComponent(gbl, new JLabel(""), 0, 10, 3, 1, 0.0, 1.0);

		// Add Listeners
		playbtn.addActionListener(this);
		highscoresbtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(playbtn)) {
			cardLayout.show(panel, "Game");
			MainFrame.setActivePane("Game");
			playername = playerinput.getText();
			Main.main.validate();
		}
		if (e.getSource().equals(highscoresbtn)) {
			cardLayout.show(panel, "Highscores");
			MainFrame.setActivePane("Highscores");
			Main.main.validate();
		}

	}

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

}
