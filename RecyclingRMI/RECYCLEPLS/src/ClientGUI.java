
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * @author Marc Conrad
 *
 */

import org.apache.xmlrpc.XmlRpcClient;
public class ClientGUI extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String sessioncookie = "??"; 
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(items)) { 
			try { 
			 XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2");
			   Vector args = new Vector(); 
			   args.addElement(sessioncookie);
			   Object result = server.execute("sample.getNumberOfItems", args );
			   
			   
			   if( result.toString().equals("-1")){ 
				   System.out.println("Please login first");
				   } else {
				   System.out.println("There are "+result.toString()+" items in the machine.");
				   }
			   } catch (Exception exception) {
				   System.err.println("JavaClient: " + exception);
				   }
			}
		
		else if (e.getSource().equals(login)){
			String message = JOptionPane.showInputDialog("Enter your password: ");
				try {   
					XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); //
					Vector args  = new Vector(); 
					args.addElement(message); // need to work on that!
					Object result = server.execute("sample.login", args );
					
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
			
		} else if( e.getSource().equals(receipt)) { 
			System.out.println("This button does nothing yet, potential server selection.");
		}
	}
	
	JButton items = new JButton("Items"); 
	JButton login = new JButton("Login"); 
	JButton logout = new JButton("Logout"); 
	
	JButton receipt = new JButton("foo"); 
	
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
	}

}