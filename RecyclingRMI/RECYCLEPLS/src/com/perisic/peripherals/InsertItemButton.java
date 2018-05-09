package com.perisic.peripherals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.perisic.beds.CustomerPanel;
	/**
	 * This class handles the GUI Buttons
	 * @author Ashley Palmer
	 */
public class InsertItemButton extends JButton {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * This method is used as an actionlistener for the buttons that adds the item
	 * @param label Printerinterface
	 * @param Customer Panel
	 * @param slot integer (Item number)
	 */
	public InsertItemButton(String label, CustomerPanel CP, int slot) {
		super(label);
        this.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            CP.itemReceived(slot);
        }});
    }
}