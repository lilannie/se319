package controllers;

import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private Socket socket;
	private views.Client gui;
	private int port;
	private String server, username;

	public Client(String server, int port, String username) {
		this(server, port, username, null);
	}

	public Client(String server, int port, String username, views.Client gui) {
		this.server = server;
		this.port = port;
		this.username = username;
		this.gui = gui;
	}

	public boolean start() {
		if (connectServer() && createDataStream() && login()) {
			return true;
		}
		return false;
	}

	private boolean connectServer() {
		try {
			socket = new Socket(server, port);
		} catch (Exception error) {
			print("Error connecting to server: " + error);
			return false;
		}
		print("Connection accepted " + socket.getInetAddress() + ":" + socket.getPort());
		return true;
	}

	private boolean createDataStream() {
		/* Creating both Data Stream */
		try {
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());

			// creates the Thread to listen from the server
			new listeners.ServerListener(this).start();
		} catch (IOException exception) {
			print("Exception creating new Input/output Streams: " + exception);
			return false;
		}
		
		return true;
	}

	public boolean login() {
		try {
			// Send our username to the server this is the only message that we
			// will send as a String. All other messages will be ChatMessage
			// objects
			output.writeObject(username);
		} catch (IOException eIO) {
			print("Exception doing login : " + eIO);
			disconnect();
			return false;
		}
		// success we inform the caller that it worked
		return true;
	}

	public void print(String message) {
		if (gui != null)
			gui.append(message + "\n");
		else
			System.out.println(message);
	}

	public void sendMessage(models.Message message){
		try {
			output.writeObject(message);
		} catch(IOException exception){
			print("Exception writing to server: " + exception);
		}
	}
	
	public void disconnect(){
		try {
			if(input != null) input.close();
			if(output != null) output.close();
			if(socket != null) socket.close();
			if(gui != null) gui.connectionFailed();
		} catch(Exception e) {
		}
	}

	public ObjectInputStream getInput() {
		return input;
	}

	public ObjectOutputStream getOutput() {
		return output;
	}

	public Socket getSocket() {
		return socket;
	}

	public views.Client getGui() {
		return gui;
	}

	public int getPort() {
		return port;
	}

	public String getServer() {
		return server;
	}

	public String getUsername() {
		return username;
	}
}
