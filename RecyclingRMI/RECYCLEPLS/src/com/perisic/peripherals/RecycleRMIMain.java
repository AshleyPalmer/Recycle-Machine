package com.perisic.peripherals;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.perisic.beds.CustomerPanel;
import com.perisic.beds.rmiinterface.RemoteRecycling;

public class RecycleRMIMain extends UnicastRemoteObject implements RemoteRecycling {

	public static void main(String [] args ) { 
		RecyclingGUI myGUI = new RecyclingGUI(); 
		myGUI.setVisible(true); 
		
		try {
			RecycleRMIMain recyclingImpl = new RecycleRMIMain();

			recyclingImpl.setCustomerPanel(myGUI.myPanel);

			RemoteRecycling recyclingInterface = recyclingImpl; 

			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("RecyclingService1718",recyclingInterface);

			System.out.println("Starting Service. Welcome to the RMI Recyling Service!");
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}
	
	protected RecycleRMIMain() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	CustomerPanel myCustomerPanel = null; 
	
	void setCustomerPanel(CustomerPanel myPanel) { 
		myCustomerPanel = myPanel; 
	}

	@Override
	public int getNumberOfItems(String authenticationCookie) throws RemoteException {
		// TODO Auto-generated method stub
		// Needs Implementation!!!! '5' is only for testing purposes. 
		return myCustomerPanel.getNumberOfItems(authenticationCookie); 
	}

		@Override
	public String login(String password) throws RemoteException {
		return myCustomerPanel.login(password); 
	}
}
