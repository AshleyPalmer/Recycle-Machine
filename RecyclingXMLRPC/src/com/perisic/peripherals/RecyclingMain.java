package com.perisic.peripherals;

import org.apache.xmlrpc.WebServer;
/**
 * The main method for the program, creates a new GUI instance and sets it as visible.
 * Also includes a timeout timer that needs further development
 * @see RecyclingGUI
 * @author Ashley Palmer 
 */
public class RecyclingMain {
	
	public static void main(String [] args) { 
		RecyclingGUI myGUI = new RecyclingGUI(); 
		myGUI.setVisible(true); 
		try {
			System.out.println("Starting the Server..."); 
			WebServer server = new WebServer(80);
			server.addHandler("sample", myGUI.myPanel );
			server.start();
		} catch (Exception exception) {
			System.err.println("JavaServer: " + exception);
		}
		
	}
}