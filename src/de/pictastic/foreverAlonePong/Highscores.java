package de.pictastic.foreverAlonePong;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * Displays the highscores list on this system after the game.
 */
public class Highscores extends JPanel implements ActionListener {

	//Panel and Layout
	private JPanel panel;
	private CardLayout cardLayout;
	
	//Components
	private JLabel headline = new JLabel();
	private JButton backbtn;


	// Liste zur Highscoreanzeige
	private ArrayList<Highscore> scores = new ArrayList<Highscore>();
	private DefaultListModel<String> scoreModel = new DefaultListModel<String>();
	private JList<String> scoreList = new JList<String>(scoreModel);

	/**
	 * Konstruktor des Highscores JPanel.
	 * 
	 * @param panel
	 * @param cardLayout
	 * @param playedHighscore not used
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

//		scores.add(new Highscore("Marvin", 5));

		// Panel Components

		// Headline
		headline = new JLabel("Highscores");
		headline.setForeground(Color.WHITE);
		headline.setBackground(Color.BLUE);
		headline.setFont(new Font("Helvetica", Font.PLAIN, 70));
		headline.setHorizontalAlignment(SwingConstants.CENTER);

		// Backbutton
		backbtn = new JButton("Go Back to Start");
		backbtn.setBackground(Color.BLACK);
		backbtn.setForeground(Color.WHITE);
		backbtn.setFont(new Font("Helvetica", Font.PLAIN, 20));

		// JList Scores
		scores.forEach(a -> {
			scoreModel.addElement(a.toString() );
		});
		JScrollPane scrollPane = new JScrollPane(scoreList);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) scoreList.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		scoreList.setBackground(Color.BLACK);
		scoreList.setForeground(Color.WHITE);
		scoreList.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		//add Component
		addComponent(this, gbl, headline, 0, 1, 3, 1, 0.0, 0.0, new Insets(10, 20, 0, 20));
		addComponent(this, gbl, scrollPane, 0, 2, 3, 2, 0.0, 0.5);
		addComponent(this, gbl, backbtn, 0, 4, 3, 1, 0.0, 0.0, new Insets(0, 20, 20, 20));


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
	/**
	 * Adds Components to an GridBagLayout. Requires an Insets;
	 * 
	 * @param panel
	 * @param gbl
	 * @param c
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param weightx
	 * @param weighty
	 * @param inset
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
		scores.subList(0, 9);
	}

}
