package com.perisic.beds;

import com.perisic.util.ItemReader;

/**
 * This class contains the Weight, Size, and Value of the Crate
 *
 */
public class Crate extends DepositItem {
	static int weight = 1516;
	static int size = 90;
	/**
	 * 
	 */
	public Crate() { 
		try {
			value = ItemReader.getValueOf("crate");
		} catch  (Exception e) {
			System.out.println("An exception has occured: "+e.toString());
			e.printStackTrace();
		}
	}
}
