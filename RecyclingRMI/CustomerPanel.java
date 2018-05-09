package com.perisic.beds;

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
	
	public String login(String passwd) { 
		if( passwd.equals("password")) { // means password is ok. Needs further work! Password shouldn't be hard coded but rather be encrypted etc
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
