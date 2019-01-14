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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.pictastic.foreverAlonePong.helper.GameSoundPlayer;
import de.pictastic.foreverAlonePong.helper.MusicPlayer;

//Panel zum Start des Spiels mit player namenseingabe für Highscore

@SuppressWarnings("serial")
public class StartMenu extends DefaultJPanel implements MouseListener, ActionListener, KeyListener {

	JPanel panel;
	CardLayout cardLayout;

	// Components
	JLabel picLabel = new JLabel();
	JTextField playerinput = new JTextField(10);
	JLabel fail = new JLabel("");
	JButton playbtn = new JButton("PLAY");
	JButton highscoresbtn = new JButton("HIGHSCORES");
	JCheckBox playWithBro = new JCheckBox();

	// variables
	private String playername;
	private boolean mute = false;

	// Constructor
	public StartMenu(JPanel panel, CardLayout cardLayout) {
		this.cardLayout = cardLayout;
		this.panel = panel;

		// Layout Settings
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);

		// Start Music
		enableMusic();

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
		playbtn.setEnabled(false);

		highscoresbtn.setBackground(Color.BLACK);
		highscoresbtn.setForeground(Color.WHITE);
		highscoresbtn.setFont(new Font("Helvetica", Font.PLAIN, 20));

		picLabel.setBackground(Color.BLACK);
		picLabel.addMouseListener(this);

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
		addComponent(gbl, picLabel, 2, 11, 1, 1, 0.0, 0.0, new Insets(0, 0, 10, 10));

		// Add Listeners
		playbtn.addActionListener(this);
		highscoresbtn.addActionListener(this);
		playerinput.addKeyListener(this);
//		picLabel.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(playbtn)) {
			MusicPlayer.stopMusic();
			cardLayout.show(panel, "GameWithBot");
			MainFrame.setActivePane("GameWithBot");
			playername = playerinput.getText();
			Main.main.validate();
			GameSoundPlayer.playSound(0, 1);
		}
		if (e.getSource().equals(highscoresbtn)) {
			cardLayout.show(panel, "Highscores");
			MainFrame.setActivePane("Highscores");
			Main.main.validate();

		}

	}

	/**
	 * Turn the music off and change symbol.
	 */
	private void disableMusic() {
		MusicPlayer.disableSound();
		mute = true;
		MusicPlayer.stopMusic();

		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("../AppData/mute.png"));
		} catch (IOException e) {
			System.out.println("Mute Icon nicht gefunden");
			e.printStackTrace();
		}
		picLabel.setIcon(new ImageIcon(myPicture));

	}

	/**
	 * Turn music on and change symbol.
	 */
	private void enableMusic() {
		MusicPlayer.enableSound();
		mute = false;
		MusicPlayer.playMusic("../AppData/Sounds/FAPS2.wav");

		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("../AppData/notmute.png"));
		} catch (IOException e) {
			System.out.println("Mute Icon nicht gefunden");
			e.printStackTrace();
		}
		picLabel.setIcon(new ImageIcon(myPicture));
	}

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (playerinput.getText().length() > 0) {
			playbtn.setEnabled(true);
		} else {
			playbtn.setEnabled(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(picLabel)) {
			if (mute) {
				enableMusic();
			} else {
				disableMusic();
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
