package com.perisic.beds;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This is the interface of the system. It represents the interaction from 
 * the customer with the system. 
 * The customer panel knows the recycling machine (i.e. the Deposit Item Receiver class)
 * @author Marc Conrad
 *
 */
public class CustomerPanel {
	DepositItemReceiver receiver = null; //Declaring member variable and instantiation of the class
	
	private String sessioncookie = "not set yet"; 
	/**
	 * This method calls the constructor of the parent class and instantiates
	 * the DepositItemReceiver class as receiver
	 * @param myPrinter
	 */
	public CustomerPanel(PrinterInterface myPrinter) {
			super();
			receiver = new DepositItemReceiver(myPrinter); 
	}
	
	public int getNumberOfItems(String authenticationcookie ) { 
		if( authenticationcookie.equals(sessioncookie)) { 
			int result = receiver.getNumberOfItems();
		return result; 
		} else { 
			return -1; 
			}
		}
	/**
	 * Hashes the user inputted password
	 * @param passwd
	 * @return generatedPassword
	 */
	public String MD5Encrypt(String passwd){
		String passwordToHash = passwd;
	    String generatedPassword = null;
	    try {
	    	// Create MessageDigest instance for MD5
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        //Add password bytes to digest
	        md.update(passwordToHash.getBytes());
	        //Get the hash's bytes
	        byte[] bytes = md.digest();
	        //This bytes[] has bytes in decimal format;
	        //Convert it to hexadecimal format
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i< bytes.length ;i++)
	        {
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        //Get complete hashed password in hex format
	        generatedPassword = sb.toString();
	        }
	    catch (NoSuchAlgorithmException e)
	    {
	    	e.printStackTrace();
	    	}
	    System.out.println(generatedPassword);
	    return generatedPassword;
	    }
	/**
	 * Logs in to the Client
	 * @param passwd
	 * @return sessioncookie
	 */
	public String login(String passwd) { 
		String hashpw = "5f4dcc3b5aa765d61d8327deb882cf99";
		String generatedPassword = MD5Encrypt(passwd);
		if(generatedPassword.equals(hashpw)) { // means password is ok. Needs further work! Password shouldn't be hard coded but rather be encrypted etc
			sessioncookie = "Random"+Math.random(); 
			return sessioncookie;
		} else { 
			return "wrong"; 
		}
	}
	
	/**
	 * Use Case I - an item has been entered into the system.
	 * @param slot
	 */
	public void itemReceived(int slot) { 
		receiver.classifyItem(slot); 
	}
	/**
	 * Use Case II - a receipt has been requested. 
	 */
	public void printReceipt() { 
		receiver.printReceipt();
	}
	
	public void setPrinter(PrinterInterface myPrinter) { 
		// Add something like for Task 2, b: receiver.setPrinter(myPrinter); 
	}
	
}
