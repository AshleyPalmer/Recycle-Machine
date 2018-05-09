package com.perisic.peripherals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.perisic.beds.CustomerPanel;


/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * This class no longer combines the three different aspects 
 * 1) Starting the software is controlled by RecyclingMain
 * 2) This class just Implements the GUI
 * 3) Handling events is handed over to the InsertItemButton class
 * 
 * To do: (Task 3 Done) - refactor into more than one class to separate the different aspects. 
 * @author Ashley Palmer
 *
 */
public class RecyclingGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CustomerPanel myPanel = null; //Declaring Member variable and instantiating
	
	/**
	 * The GUI Class
	 */
	public RecyclingGUI() {
		super();
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		
		Display myPrinter = new Display(); 
		myPanel = new CustomerPanel(myPrinter); 
		myPrinter.setBackground(Color.gray);
		
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(myPrinter, BorderLayout.CENTER);
		panel.repaint();
		

		JButton slot1 = new InsertItemButton("Can", myPanel, 1);
		slot1.setBackground(new Color(59, 89, 182));
		slot1.setPreferredSize(new Dimension(100,30));
		slot1.setForeground(Color.white);
		slot1.setFocusPainted(false);
		
		JButton slot2 = new InsertItemButton("Bottle", myPanel, 2); 
		slot2.setBackground(new Color(59, 89, 182));
		slot2.setForeground(Color.white);
		slot2.setPreferredSize(new Dimension(100,30));
		slot2.setFocusPainted(false);
		
		JButton slot3 = new InsertItemButton("Crate", myPanel, 3);
		slot3.setBackground(new Color(59, 89, 182));
		slot3.setPreferredSize(new Dimension(100,30));
		slot3.setForeground(Color.white);
		slot3.setFocusPainted(false);
		
		JButton slot4 = new InsertItemButton("Paper Bag", myPanel, 4);
		slot4.setBackground(new Color(59, 89, 182));
		slot4.setPreferredSize(new Dimension(100,30));
		slot4.setForeground(Color.white);
		slot4.setFocusPainted(false);
		
		JButton receipt = new JButton("Receipt");
		receipt.setBackground(new Color(59, 89, 182));
		receipt.setPreferredSize(new Dimension(100,30));
		receipt.setForeground(Color.white);
		receipt.setFocusPainted(false);
		
		/**
		 * An anonymous method for the Print Receipt button, creates an actionevent which then prints the receipt
		 */
		receipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel.printReceipt();
			}
		});
		panel.add(slot1);
		panel.add(slot2);
		panel.add(slot3);
		panel.add(slot4);
		panel.add(receipt);
	}
}