
import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
	private ObjectInputStream input; 
	private ObjectOutputStream output; 
	private Socket socket;

	private ClientGUI gui;
	private String server, username;
	private int port;

	public Client(String server, int port, String username, ClientGUI gui) {
		this.server = server;
		this.port = port;
		this.username = username;
		this.gui = gui;
	}

	public boolean start() {
		try {
			socket = new Socket(server, port);
		} catch (Exception ec) {
			display("Error connectiong to server:" + ec);
			return false;
		}

		String msg = "Connected to " + socket.getInetAddress() + ":" + socket.getPort();
		display(msg);

		try {
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException eIO) {
			display("Exception creating new Input/output Streams: " + eIO);
			return false;
		}

		new ServerListener(this).start();
		try {
			output.writeObject(username);
		} catch (IOException eIO) {
			display("Exception doing login : " + eIO);
			disconnect();
			return false;
		}
		return true;
	}

	public void display(String msg) {
		if (gui == null)
			System.out.println(msg); 		
		else
			gui.append(msg + "\n"); 
	}
	
	void sendMessage(Message msg) {
		try {
			output.writeObject(msg);
		} catch (IOException e) {
			display("Exception writing to server: " + e);
		}
	}

	private void disconnect() {
		try {
			if (input != null)
				input.close();
		} catch (Exception e) {} 
		try {
			if (output != null)
				output.close();
		} catch (Exception e) {} 
		try {
			if (socket != null)
				socket.close();
		} catch (Exception e) {}
		
		if (gui != null)
			gui.connectionFailed();
	}

	public ObjectInputStream getInput() {
		return input;
	}

	public void setInput(ObjectInputStream input) {
		this.input = input;
	}

	public ObjectOutputStream getOutput() {
		return output;
	}

	public void setOutput(ObjectOutputStream output) {
		this.output = output;
	}

	public ClientGUI getGui() {
		return gui;
	}

	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}
	
}
