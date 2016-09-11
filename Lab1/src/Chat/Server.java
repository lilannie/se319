package Chat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		// 1. serversocket
		ServerSocket serverSocket = null;
		// keeps track of how many clients were created
		int clientNum = 0;

		// 1. CREATE A NEW SERVERSOCKET
		try {
			// provide MYSERVICE at port 4444
			int port = 4444;
			System.out.println("Binding to port " + port + ", please wait  ...");
			serverSocket = new ServerSocket(port);
			System.out.println("Server started: " + serverSocket);
		} catch (IOException e) {
			System.out.println("Could not listen on port: 4444");
			System.exit(-1);
		}

		// 2. LOOP FOREVER - SERVER IS ALWAYS WAITING TO PROVIDE SERVICE!
		while (true) { // 3.
			Socket clientSocket = null;
			try {
				// 2.1 WAIT FOR CLIENT TO TRY TO CONNECT TO SERVER
				System.out.println("Waiting for client " + (clientNum + 1) + " to connect!");
				clientSocket = serverSocket.accept(); // // 4.

				// 2.2 SPAWN A THREAD TO HANDLE CLIENT REQUEST
				System.out.println("Server got connected to a client" + ++clientNum);
				Thread t = new Thread(new ClientHandler(clientSocket, clientNum));
				t.start();

			} catch (IOException e) {
				System.out.println("Accept failed: 4444");
				System.exit(-1);
			}

			// 2.3 GO BACK TO WAITING FOR OTHER CLIENTS
			// (While the thread that was created handles the connected client's
			// request)

		} // end while loop

	} // end of main method

} // end of class MyServer