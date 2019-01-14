package de.pictastic.foreverAlonePong.frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DefaultJPanel extends JPanel{
	

	
	public DefaultJPanel() {
		super();

		//Panel Settings
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);

		}
	
	
	
	/**
	 * Add Components to GridBagLayout
	 * 
	 * @param gbl
	 * @param comp component that should be added
	 * @param x column
	 * @param y row
	 * @param width Component span x
	 * @param height Component span y
	 * @param weightx
	 * @param weighty
	 */
	protected void addComponent(GridBagLayout gbl, Component comp, int x, int y, int width, int height, double weightx,
			double weighty) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 20, 0, 20);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(comp, gbc);
		this.add(comp);
	}
	
	 /**
	 * Add Components to GridBagLayout
	 * 
	 * @param gbl
	 * @param comp component that should be added
	 * @param x column
	 * @param y row
	 * @param width Component span x
	 * @param height Component span y
	 * @param weightx
	 * @param weighty
	 * @param inset specifiy a new inset
	 */
	protected void addComponent(GridBagLayout gbl, Component comp, int x, int y, int width, int height, double weightx,
			double weighty, Insets inset) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.insets=inset;
		gbl.setConstraints(comp, gbc);
		this.add(comp);
	}

}
