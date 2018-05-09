package com.perisic.beds;
import java.util.Vector; 

/**
 * This is where the data lives, i.e. cans, bottles and crates are recorded
 * in this class. We might call it our database (if we insist!). 
 * It also provides a summative statement about all the items inserted into the 
 * machine. 
 * @author Marc Conrad
 *
 */
public class ReceiptBasis {
	private Vector<DepositItem> myItems = new Vector<DepositItem>();
	/**
	 * @param item an item that has been inserted into the machine (such as can, bottle, crate). 
	 */
	public void addItem(DepositItem item) { 
		myItems.add(item); 
		item.number = myItems.indexOf(item); 
	}
	/**
	 * Calculates a summary based on the items inserted.
	 * @return the overall value of the items inserted by the customer.
	 */
	public String computeSum() {
		String receipt = ""; 
		int sum = 0;
		int totalweight = 0;
		
		for(int i=0; i < myItems.size(); i++ ) {
			DepositItem item = myItems.get(i);
			item.number = item.number +1;
			receipt = receipt + item.number +": "+item.value +" ("+item.getName()+")"; 
			receipt = receipt + System.getProperty("line.separator");
			sum = sum + item.value;
			totalweight = totalweight + item.weight;
		}
		
		receipt = receipt + "Total value: "+sum;
		receipt = receipt + System.getProperty("line.separator");
		int itemCounter = myItems.size();
		receipt = receipt + "Total amount of items: " +itemCounter;
		return receipt;	
	}
} 