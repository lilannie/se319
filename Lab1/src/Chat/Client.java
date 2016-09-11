package Chat;

import java.net.*;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.io.*;

public class Client {

	Socket serverSocket;
	String serverHostName = "localhost";
	int serverPortNumber = 4444;
	ServerListener sl;

	public Client(String name) {
		// 1. CONNECT TO THE SERVER
		try {
			serverSocket = new Socket(serverHostName, serverPortNumber);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2. SPAWN A LISTENER FOR THE SERVER. THIS WILL KEEP RUNNING
		// when a message is received, an appropriate method is called
		sl = new ServerListener(this, serverSocket);
		new Thread(sl).start();
	}

	public void printServer() {
		 PrintWriter out;
		 try {
		 out = new PrintWriter(new
		 BufferedOutputStream(serverSocket.getOutputStream()));
		
		 // 3. SEND THREE WISHES TO SERVER
		 out.println("wish 1: one million bucks ");
		 out.flush(); // force the output
		 out.println("wish 2: uh oh! ");
		 out.flush(); // force the output
		 out.println("wish 3: get rid of the bucks ");
		 out.flush(); // force the output
		
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
	}

	public void handleMessage(String cmd, String s) {
		switch (cmd) {
		case "print":
			System.out.println("client side: " + s);
			break;
		case "exit":
			System.exit(-1);
			break;
		default:
			System.out.println("client side: unknown command received:" + cmd);
		}
	}

	public static void main(String[] args) {
		Client lc = new Client("Fake name");
	}

}
