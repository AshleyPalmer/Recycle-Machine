package com.perisic.beds.rmiinterface;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteRecycling extends Remote {
	/**
	 * RMI Remote Constructor
	 * @param authenticationCookie
	 * @return
	 * @throws RemoteException
	 */
	public int getNumberOfItems(String authenticationCookie) throws RemoteException;
	
	public String login(String password) throws RemoteException; 
}
