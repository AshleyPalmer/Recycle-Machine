package com.perisic.peripherals;

import java.awt.Color;

import javax.swing.*;

import com.perisic.beds.PrinterInterface; 
/* 
 * Displays text in a frame.
 */
public class Display extends JTextArea implements PrinterInterface {
	/**
	 * A serialVersionUID is required by the JFrame class. 
	 */
	private static final long serialVersionUID = -8505887234618184162L;
	
	/**
	 * when constructed the display will be directly visible. 
	 */	
	public Display() {
		super();
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			
		setForeground(Color.white);
		}
	/**
	 * Prints the text string to the screen. Any previous text will be overwritten. 
	 * @see com.perisic.beds.PrinterInterface#print(java.lang.String)
	 */
	public void print(String str) { 
		setText(str); 
		repaint();
	}

}