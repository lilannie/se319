package models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

public class Client extends Thread
{
	Socket socket;
	ObjectInputStream sInput;
	ObjectOutputStream sOutput;

	// my unique id (easier for deconnection)
	int id;
	String username;
	ChatMessage cm;
	String date;

	public Client(Socket socket) {
		// a unique id
		// TODO set uniqueId;
//		id = ++server.uniqueId;
		this.socket = socket;
		System.out.println("Thread trying to create Object Input/Output Streams");
		try {
			// create output first
			sOutput = new ObjectOutputStream(socket.getOutputStream());
			sInput = new ObjectInputStream(socket.getInputStream());
			username = (String) sInput.readObject();
			display(username + " just connected.");
		} catch (IOException e) {
			display("Exception creating new Input/output Streams: " + e);
			return;
		} catch (ClassNotFoundException e) {
		}

		date = new Date().toString() + "\n";
	}

	// what will run forever
	public void run() {
		// to loop until LOGOUT

		boolean keepGoing = true;
		while (keepGoing) {
			// read a String (which is an object)
			try {
				cm = (ChatMessage) sInput.readObject();
			} catch (IOException e) {
				display(username + " Exception reading Streams: " + e);
				break;
			} catch (ClassNotFoundException e2) {
				break;
			}

			String message = cm.getMessage();

			// Switch on the type of message receive
			switch (cm.getType()) {

			case ChatMessage.MESSAGE:
				broadcast(username + ": " + message);
				break;
			case ChatMessage.LOGOUT:
				display(username + " disconnected with a LOGOUT message.");
				keepGoing = false;
				break;
			case ChatMessage.WHOISIN:
				writeMsg("List of the users connected at " + sdf.format(new Date()) + "\n");
				// scan al the users connected
				for (int i = 0; i < al.size(); ++i) {
					ClientThread ct = al.get(i);
					writeMsg((i + 1) + ") " + ct.username + " since " + ct.date);
				}
				break;
			}
		}
		// remove myself from the arrayList containing the list of the
		// connected Clients
		remove(id);
		close();
	}

	// try to close everything
	private void close() {
		// try to close the connection
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

	/*
	 * Write a String to the Client output stream
	 */
	private boolean writeMsg(String msg) {
		// if Client is still connected send the message to it
		if (!socket.isConnected()) {
			close();
			return false;
		}
		// write the message to the stream
		try {
			sOutput.writeObject(msg);
		}

		catch (IOException e) {
			display("Error sending message to " + username);
			display(e.toString());
		}
		return true;
	}
}