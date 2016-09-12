import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Server {
	private static int uniqueId;
	private ArrayList<ClientThread> clients;
	private ServerGUI gui;
	private int port;
	private boolean keepGoing;

	
	public Server(int port, ServerGUI gui) {
		this.gui = gui;
		this.port = port;
		clients = new ArrayList<ClientThread>();
	}

	public void start() {
		keepGoing = true;

		try {
			ServerSocket serverSocket = new ServerSocket(port);

			while (keepGoing) {
				display("Server waiting for Clients on port " + port + ".");
				Socket socket = serverSocket.accept();
				if (!keepGoing)
					break;
				ClientThread t = new ClientThread(socket, this);
				clients.add(t);
				t.start();
			}
			try {
				serverSocket.close();
				for (int i = 0; i < clients.size(); ++i) {
					ClientThread tc = clients.get(i);
					try {
						tc.sInput.close();
						tc.sOutput.close();
						tc.socket.close();
					} catch (IOException ioE) {
					}
				}
			} catch (Exception e) {
				display("Exception closing the server and clients: " + e);
			}
		} catch (IOException e) {
			String msg = "Exception on new ServerSocket: " + e + "\n";
			display(msg);
		}
	}

	protected void stop() {
		keepGoing = false;
		try {
			new Socket("localhost", port);
		} catch (Exception e) {
		}
	}

	public void display(String msg) {
		if (gui == null)
			System.out.println(msg);
		else
			gui.appendEvent(msg + "\n");
	}

	public synchronized void broadcast(String message) {
		String messageLf = message + "\n";
		if (gui == null)
			System.out.print(messageLf);
		else
			gui.appendRoom(messageLf);
		for (int i = clients.size() - 1; i >= 0; i--) {
			ClientThread ct = clients.get(i);
			if (!ct.writeMsg(messageLf)) {
				clients.remove(i);
				display("Disconnected Client " + ct.username + " removed from list.");
			}
		}
	}

	public synchronized void remove(int id) {
		for (int i = 0; i < clients.size(); ++i) {
			ClientThread ct = clients.get(i);
			if (ct.id == id) {
				clients.remove(i);
				return;
			}
		}
	}
	
	public int getUniqueId(){
		return this.uniqueId;
	}
	
	public ArrayList<ClientThread> getClients(){
		return this.clients;
	}
	
}
