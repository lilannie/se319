import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

public class ClientThread extends Thread {
	Socket socket;
	ObjectInputStream sInput;
	ObjectOutputStream sOutput;
	int id;
	String username;
	Message cm;
	String date;
	Server server;

	public ClientThread(Socket socket, Server server) {
		id = server.getUniqueId()+1;
		this.socket = socket;
		this.server = server;
		System.out.println("Thread trying to create Object Input/Output Streams");
		try {
			sOutput = new ObjectOutputStream(socket.getOutputStream());
			sInput = new ObjectInputStream(socket.getInputStream());
			username = (String) sInput.readObject();
			server.display(username + " just connected.");
		} catch (IOException e) {
			server.display("Exception creating new Input/output Streams: " + e);
			return;
		} catch (ClassNotFoundException e) {
		}
		date = new Date().toString() + "\n";
	}

	public void run() {
		boolean keepGoing = true;
		while (keepGoing) {
			try {
				cm = (Message) sInput.readObject();
			} catch (IOException e) {
				server.display(username + " Exception reading Streams: " + e);
				break;
			} catch (ClassNotFoundException e2) {
				break;
			}

			String message = cm.getMessage();

			switch (cm.getType()) {
			case Message.MESSAGE:
				server.broadcast(username + ": " + message);
				break;
			case Message.LOGOUT:
				server.display(username + " disconnected with a LOGOUT message.");
				keepGoing = false;
				break;
			case Message.WHOISIN:
				writeMsg("List of the users connected: \n");
				for (int i = 0; i < server.getClients().size(); ++i) {
					ClientThread ct = server.getClients().get(i);
					writeMsg((i + 1) + ") " + ct.username + " since " + ct.date);
				}
				break;
			}
		}
		server.remove(id);
		close();
	}

	public void close() {
		try {
			if (sOutput != null)
				sOutput.close();

			if (sInput != null)
				sInput.close();

			if (socket != null)
				socket.close();
		} catch (Exception e) {
		}
	}

	public boolean writeMsg(String msg) {
		if (!socket.isConnected()) {
			close();
			return false;
		}
		try {
			sOutput.writeObject(msg);
		} catch (IOException e) {
			server.display("Error sending message to " + username);
			server.display(e.toString());
		}
		return true;
	}
}
