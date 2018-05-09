package com.perisic.util;

import java.net.*;
import java.io.*;

public class ItemReader {
	
    public static int getValueOf(String what) throws Exception {
        URL prices = new URL("http://www.perisic.com/uob/CIS007-3/prices.php?item="+what);
        BufferedReader in = new BufferedReader( new InputStreamReader(prices.openStream()));
        //Reads text from a character input stream such as a file, in this case its a HTML
        String inputLine;
        int result = -2; 
        
        while ((inputLine = in.readLine()) != null) {
        	result = Integer.parseInt(inputLine); 
        	}
        in.close(); 
        return result; 
    }
}