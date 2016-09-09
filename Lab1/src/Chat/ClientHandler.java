package Chat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
	Socket s; // this is socket on the server side that connects to the CLIENT
	int num; // keeps track of its number just for identifying purposes

	public ClientHandler(Socket s, int n) {
		this.s = s;
		num = n;
	}

	// This is the client handling code
	// This keeps running handling client requests 
	// after initially sending some stuff to the client
	public void run() { 
		Scanner in;
		PrintWriter out;
		
		try {
			// 1. GET SOCKET IN/OUT STREAMS
			in = new Scanner(new BufferedInputStream(s.getInputStream())); 
			out = new PrintWriter(new BufferedOutputStream(s.getOutputStream()));
	
			// 2. PRINT SOME STUFF TO THE CLIENT
			out.println("print Hello There");
			out.println("print You get three wishes!");
			out.flush(); // force the output
			
			// 3. KEEP LISTENING AND RESPONDING TO CLIENT REQUESTS
			int count = 1;
			while (count <= 3) {
				System.out.println("Server - waiting to read");
				String s = in.nextLine();
				handleRequest(s);
				count++;
			}
			out.println("exit done with wishes");
			out.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// This handling code dies after doing all the printing
	} // end of method run()
	
	void handleRequest(String s) {
		System.out.println("server side: " + s);
	}

} // end of class ClientHandler
