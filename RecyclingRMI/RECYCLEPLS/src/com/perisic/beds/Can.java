package com.perisic.beds;

import com.perisic.util.ItemReader;

/**
 * This class contains the Weight, Size, and Value of the Can
 * 
 *
 */
public class Can extends DepositItem {
	static int weight = 4;
	static int size = 5;
	/**
	 * 
	 */
	public Can() { 
		try {
			value = ItemReader.getValueOf("can");
		} catch  (Exception e) {
			System.out.println("An exception has occured: "+e.toString());
			e.printStackTrace();
		}
		//value = 16;
	}
}
