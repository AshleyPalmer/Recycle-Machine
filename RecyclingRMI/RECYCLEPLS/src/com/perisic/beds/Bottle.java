package com.perisic.beds;

import com.perisic.util.ItemReader;

/**
 * This class contains the Weight, Size, and Value of the Bottle
 * 
 *
 */
public class Bottle extends DepositItem {
	static int weight = 10;
	static int size = 8; 
	/**
	 * 
	 */
	public Bottle() { 
		try {
			value = ItemReader.getValueOf("bottle");
		} catch  (Exception e) {
			System.out.println("An exception has occured: "+e.toString());
			e.printStackTrace();
		}
	}
}
