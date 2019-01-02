package de.pictastic.foreverAlonePong.frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.pictastic.foreverAlonePong.highscore.Highscore;
import de.pictastic.foreverAlonePong.highscore.HighscoreReader;

/**
 * Displays the highscores list on this system after the game.
 */
public class Highscores extends JPanel implements ActionListener {

	// Panel and Layout
	private JPanel panel;
	private CardLayout cardLayout;

	// Components
	private JLabel headline = new JLabel();
	private JButton backbtn;

	// Liste zur Highscoreanzeige
	private List<Highscore> scores = new ArrayList<Highscore>();
	private DefaultListModel<String> scoreModel = new DefaultListModel<String>();
	private JList<String> scoreList = new JList<String>(scoreModel);

	/**
	 * Konstruktor des Highscores JPanel.
	 * 
	 * @param panel
	 * @param cardLayout
	 * @param playedHighscore not used
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public Highscores(JPanel panel, CardLayout cardLayout) {
		this.cardLayout = cardLayout;
		this.panel = panel;

		// Panel Settings
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);

		// LayoutSettings
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);

		// Panel Components

		// Headline
		headline = new JLabel("HIGHSCORES");
		headline.setForeground(Color.WHITE);
		headline.setBackground(Color.BLUE);
		headline.setFont(new Font("Helvetica", Font.PLAIN, 50));
		headline.setHorizontalAlignment(SwingConstants.CENTER);

		// Backbutton
		backbtn = new JButton("Go Back to Start");
		backbtn.setBackground(Color.BLACK);
		backbtn.setForeground(Color.WHITE);
		backbtn.setFont(new Font("Helvetica", Font.PLAIN, 20));

		// add Scores to JList
		try {
			scores = HighscoreReader.importScores();
		} catch (NumberFormatException | IOException e) {
			System.out.println("Highscore-Import fehlgeschlagen");
			e.printStackTrace();
		}
		scores.forEach(a -> {
			scoreModel.addElement(a.toString());
		});
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) scoreList.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		scoreList.setBackground(Color.BLACK);
		scoreList.setForeground(Color.WHITE);
		scoreList.setFont(new Font("Helvetica", Font.PLAIN, 30));

		// add Component
		addComponent(this, gbl, headline, 0, 1, 3, 1, 0.0, 0.0, new Insets(25, 20, 15, 20));
		addComponent(this, gbl, scoreList, 0, 2, 3, 2, 0.0, 0.5);
		addComponent(this, gbl, backbtn, 0, 4, 3, 1, 0.0, 0.0, new Insets(10, 20, 20, 20));

		// add Listeners
		backbtn.addActionListener(this);

	}

	/*
	 * Adds Components to an GridBagLayout
	 */
	static void addComponent(JPanel panel, GridBagLayout gbl, Component c, int x, int y, int width, int height,
			double weightx, double weighty) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 20, 0, 20);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(c, gbc);
		panel.add(c);
	}

	/*
	 * Adds Components to an GridBagLayout. Requires an Insets;
	 */
	static void addComponent(JPanel panel, GridBagLayout gbl, Component c, int x, int y, int width, int height,
			double weightx, double weighty, Insets insets) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = insets;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(c, gbc);
		panel.add(c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(backbtn)) {
			cardLayout.show(panel, "StartMenu");
			Main.main.validate();
		}
	}

	/**
	 * Fügt den Score zur Highscoreliste hinzu, wenn dieser in der Top10 ist.
	 * 
	 * @param score
	 */
	public void addNewScore(Highscore score) {
		scores.add(score);
		Collections.sort(scores);
		if (scores.size() > 10) {
			scores = scores.subList(0, 10);
		}
		scoreModel.removeAllElements();
		scores.forEach(a -> {
			scoreModel.addElement(a.toString());
		});
//		JLabel topscorer;
//		for (int i = 0; i < scores.size(); i++) {
//			switch (i) {
//			case 0:
//				topscorer = new JLabel(scores.get(i).toString());
//				topscorer.setFont(new Font("Helvetica", Font.PLAIN, 55));
//				break;
//			case 1:
//				topscorer = new JLabel(scores.get(i).toString());
//				topscorer.setFont(new Font("Helvetica", Font.PLAIN, 50));
//				break;
//			case 2:
//				topscorer = new JLabel(scores.get(i).toString());
//				topscorer.setFont(new Font("Helvetica", Font.PLAIN, 45));
//				break;
//			default:
//				topscorer = new JLabel(scores.get(i).toString());
//				break;
//			}
//			scoreModel.addElement(topscorer.toString());
//	}
		}

	//Getter and Setter
	
	/**
	 * Return a list of highscores.
	 * @return scores
	 */
	public List<Highscore> getScores() {
		return scores;
	}
	
	/**
	 * Set a List as Highscores.
	 * @param scores
	 */
	public void setScores(List<Highscore> scores) {
		this.scores = scores;
	}
	
	
	
	}
