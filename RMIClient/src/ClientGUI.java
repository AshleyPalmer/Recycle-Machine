
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.Vector;

import javax.swing.*;

import com.perisic.beds.rmiinterface.RemoteRecycling;
/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * @author Marc Conrad
 *
 */


public class ClientGUI extends JFrame implements ActionListener  {
	private static String sessioncookie = "??"; 
	
	private RemoteRecycling myRecyclingMachine = null; 
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(items)) { 
			try { 
				int result = myRecyclingMachine.getNumberOfItems(sessioncookie); 
				if( result == -1) { 
					System.out.println("Please login first"); 
				} else { 
					System.out.println("There are "+result+" items in the machine.");
				}

			} catch (Exception exception) {
				System.err.println("JavaClient: " + exception);
			}
		}
		else if(e.getSource().equals(login)){ 
			String message = JOptionPane.showInputDialog("Please enter your password"); 
				try {   
					String result = myRecyclingMachine.login(message); 
					
					if(result.equals("wrong")) { 
						System.out.println("Sorry, wrong password"); 
					} else { 
						System.out.println("Login successful. Please continue"); 
						sessioncookie = result.toString(); 
					}
					

				} catch (Exception exception) {
					System.err.println("JavaClient: " + exception);
				}

		} else if( e.getSource().equals(logout)) { 
			sessioncookie = "Reset"+Math.random(); 
			System.out.println("Logout. Have a good time!"); 
		} else if( e.getSource().equals(receipt))
		{ 
			
			System.out.println("Machine has been emptied.");
		}
		
	}
	
	JButton items = new JButton("No. of Items"); 
	JButton login = new JButton("Login"); 
	JButton logout = new JButton("Logout"); 
	JButton receipt = new JButton("Empty"); 
	
	public ClientGUI() {
		super();
		setSize(400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.add(items); 
		panel.add(login);
		panel.add(logout); 
		
		
		
		items.addActionListener(this); 
		login.addActionListener(this); 
		logout.addActionListener(this); 
		
		panel.add(receipt); 
		receipt.addActionListener(this); 
		
		
		
		getContentPane().add(panel);
		panel.repaint();
	
	}
	
	public static void main(String [] args ) { 
		ClientGUI myGUI = new ClientGUI(); 
		myGUI.setVisible(true); 
		 try {
			  myGUI.myRecyclingMachine =
		(RemoteRecycling) Naming.lookup("rmi://localhost/RecyclingService1718"); 
			   
			  } catch (Exception exception) {
			   System.err.println("JavaClient: " + exception);
			   }
		
	}

}