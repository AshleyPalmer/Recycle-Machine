package com.perisic.beds;

/** 
 * This class represents the overall system. 
 * @author Marc Conrad
 *
 */
public class DepositItemReceiver {
	ReceiptBasis theReceiptBasis = null; 
	
	
	/**
	 * The deposit item receiver is constructed with the output devie (i.e. the printer)
	 * @param printer
	 */
	public DepositItemReceiver(PrinterInterface printer) {
		super();
		this.printer = printer;
	}
	private int counter = 0;
	PrinterInterface printer = null; 
	/**
	 * This method adds to the Receipt based on the input slot
	 */
	public void createReceiptBasis() { 
		theReceiptBasis = new ReceiptBasis(); 
	}
	/**
	 * An if loop method that distinguishes what item has been inserted
	 * @param slot
	 */
	public void classifyItem(int slot) { 
		DepositItem item = null; 
		if( slot == 1 ) { 
			item = new Can(); 
		} else if( slot == 2 ) { 
			item = new Bottle(); 
		} else if ( slot == 3 ) { 
			item = new Crate(); 
		} else if (slot == 4) { 
			item = new PaperBag(); 
		}
		if( theReceiptBasis == null ) { 
			createReceiptBasis(); 
		}
		theReceiptBasis.addItem(item);
		counter = counter +1;
	}
	/**
	 * This method calls the computeSum method to complete the print statements and then prints it to the printer console.
	 */
	public void printReceipt() { 
		String str = theReceiptBasis.computeSum(); 
		printer.print(str); 
		theReceiptBasis = null; 
	}
	int getNumberOfItems() {
		// TODO Auto-generated method stub
		return counter;
	}
}
