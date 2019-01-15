package de.pictastic.foreverAlonePong.frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.pictastic.foreverAlonePong.helper.GameSoundPlayer;
import de.pictastic.foreverAlonePong.helper.MusicPlayer;

//Panel zum Start des Spiels mit player namenseingabe für Highscore

@SuppressWarnings("serial")
public class StartMenu extends DefaultJPanel implements MouseListener, ActionListener, KeyListener, ComponentListener {

	JPanel panel;
	CardLayout cardLayout;

	// Components
	private JLabel picLabel = new JLabel();
	private JTextField playerinput = new JTextField(10);
	private JLabel playWithBotLabel = new JLabel("Play with Bot");
	private JButton playbtn = new JButton("PLAY");
	private JButton highscoresbtn = new JButton("HIGHSCORES");
	private JLabel playWithBot = new JLabel();
	private JLabel foreverAlone = new JLabel("", SwingConstants.CENTER);

	// variables
	private String playername;
	private boolean mute = false;
	private static boolean def = true;

	// Constructor
	public StartMenu(JPanel panel, CardLayout cardLayout) {
		this.cardLayout = cardLayout;
		this.panel = panel;

		// Layout Settings
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);

		// Start Music
		enableMusic();

		// Load Start Picture
		loadStartPicture("fap_small.png");

		// Set default Game
		playDef();

		// Panel Components
		JLabel headline1 = new JLabel("FOREVERALONE");
		headline1.setForeground(Color.WHITE);
		headline1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		headline1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel headline2 = new JLabel("PONG");
		headline2.setForeground(Color.WHITE);
		headline2.setFont(new Font("Helvetica", Font.PLAIN, 70));
		headline2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel player = new JLabel("Playername");
		player.setForeground(Color.WHITE);
		player.setFont(new Font("Helvetica", Font.PLAIN, 20));
		player.setHorizontalAlignment(SwingConstants.CENTER);

		playWithBotLabel.setForeground(Color.WHITE);
		playWithBotLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));

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
		addComponent(gbl, foreverAlone, 0, 3, 3, 1, 0.0, 0.5);
		addComponent(gbl, player, 0, 4, 1, 1, 0.0, 0.0);
		addComponent(gbl, playerinput, 1, 4, 1, 1, 0.0, 0.0);
		addComponent(gbl, playWithBotLabel, 0, 5, 3, 1, 0.0, 0.2);
		addComponent(gbl, playWithBot, 1, 5, 3, 1, 0.0, 0.2);
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
		playWithBot.addMouseListener(this);
		addComponentListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(playbtn)) {
			if (playerinput.getText().contains("long dong") || playerinput.getText().contains("longdong")) {
				MainFrame.gwb.setPadW(120);
			}
			MusicPlayer.stopMusic();
			if (def) {
				cardLayout.show(panel, "Game");
				MainFrame.setActivePane("Game");
			} else {
				cardLayout.show(panel, "GameWithBot");
				MainFrame.setActivePane("GameWithBot");
			}

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

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(picLabel)) {
			if (mute) {
				enableMusic();
			} else {
				disableMusic();
			}
		}
		if (e.getSource().equals(playWithBot)) {
			if (def) {
				playBot();
			} else {
				playDef();
			}
		}
	}

	@Override
	public void componentResized(ComponentEvent l) {
		int height = getHeight();
		int width = getWidth();
		String name;

		if (height > 900 && width > 500) {
			name = "fap.png";
		} else {
			name = "fap_small.png";
		}

		loadStartPicture(name);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (playerinput.getText().length() > 0) {
			playbtn.setEnabled(true);
		} else {
			playbtn.setEnabled(false);
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
			System.out.println("NotMute Icon nicht gefunden");
			e.printStackTrace();
		}
		picLabel.setIcon(new ImageIcon(myPicture));
	}

	/**
	 * Load the ForeverAlone Meme.
	 */
	private void loadStartPicture(String name) {
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("../AppData/" + name));
		} catch (IOException e) {
			System.out.println("FA Icon nicht gefunden");
			e.printStackTrace();
		}
		foreverAlone.setIcon(new ImageIcon(myPicture));
	}

	/**
	 * Set Default Triangle Game.
	 */
	private void playDef() {
		def = true;
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("../AppData/uncheckedbox.png"));
		} catch (IOException e) {
			System.out.println("Unchecked Icon nicht gefunden");
			e.printStackTrace();
		}
		playWithBot.setIcon(new ImageIcon(myPicture));
	}

	/**
	 * Set Bot Game.
	 */
	private void playBot() {
		def = false;
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("../AppData/checkbox.png"));
		} catch (IOException e) {
			System.out.println("Checked Icon nicht gefunden");
			e.printStackTrace();
		}
		playWithBot.setIcon(new ImageIcon(myPicture));
	}

	// Getter and Setter

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public static boolean isDef() {
		return def;
	}

	public static void setDef(boolean def) {
		StartMenu.def = def;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

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

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

}
