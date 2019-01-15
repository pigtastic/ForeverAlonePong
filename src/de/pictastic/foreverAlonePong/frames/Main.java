package de.pictastic.foreverAlonePong.frames;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;



public class Main {
public static JFrame main;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    try { 
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
	    } catch(Exception ignored){}
		try {
			main = new MainFrame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	


}
