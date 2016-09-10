package Chat;


import java.net.*;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.io.*;

public class Client implements Runnable
{
	private Socket socket = null;
	private Thread thread = null;
	private DataOutputStream streamOut = null;
	//private ClientThread client = null;
	private String username;

	public Client(String ipAddr, String username, int serverPort)
	{
		this.username = username;
		
		// set up the socket to connect to the gui
		try
		{
			socket = new Socket(ipAddr, serverPort);
			start();
		} catch (UnknownHostException h)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Unknown Host " + h.getMessage());
			System.exit(1);
		} catch (IOException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "IO exception: " + e.getMessage());
			System.exit(1);
		}
	}

	public void run()
	{
		//TODO check for a new message, once we receive it, steamOut will send it to the server
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name: (Type in your name, then press Enter");
		this.username = scan.next();
		
		//TODO other stuff
		scan.close();
		
	}

	public synchronized void handleChat(String msg)
	{
		//TODO
	}

	public void start() throws IOException
	{
		//TODO 
		
	}

	public void stop()
	{
		//TODO
	
	}
}
