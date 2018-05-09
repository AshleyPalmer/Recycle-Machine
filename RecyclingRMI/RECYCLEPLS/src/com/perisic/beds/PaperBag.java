package com.perisic.beds;

/**
 * This represents a paper bag. 
 * This class contains the Weight, Size, and Value of the Paper Bag
 *
 */
public class PaperBag extends DepositItem {
	static int weight = 2; 
	static int size = 7; 
	/**
	 * 
	 */
	public PaperBag() { 
		value = 3; 
	}
	
	String getName() { 
		return "Paper Bag"; 
	}
}
