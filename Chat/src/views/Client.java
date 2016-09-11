package views;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Client extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JTextField tf,tfServer, tfPort;
	private JButton login, logout, whoIsIn;
	private JTextArea ta;
	private boolean connected;
	private controllers.Client client;
	private int defaultPort;
	private String defaultHost;

	public Client(String host, int port) {
		super("Chat Client");
		defaultPort = port;
		defaultHost = host;

		// Top panel
		JPanel top = new JPanel(new BorderLayout());
		top.setBorder(new EmptyBorder(5, 0, 5, 0));
		top.setBackground(Color.black);
		

	}

	// called by the Client to append text in the TextArea
	public void append(String str) {
		ta.append(str);
		ta.setCaretPosition(ta.getText().length() - 1);
	}

	// called by the GUI is the connection failed
	// we reset our buttons, label, textfield
	public void connectionFailed() {
		login.setEnabled(true);
		logout.setEnabled(false);
		whoIsIn.setEnabled(false);
		label.setText("Enter your username below");
		tf.setText("username");
		// reset port number and host name as a construction time
		tfPort.setText("" + defaultPort);
		tfServer.setText(defaultHost);
		// let the user change them
		tfServer.setEditable(false);
		tfPort.setEditable(false);
		// don't react to a <CR> after the username
		tf.removeActionListener(this);
		connected = false;
	}

	/*
	 * Button or JTextField clicked
	 */
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// if it is the Logout button
		if (o == logout) {
			client.sendMessage(new models.Message(models.Message.LOGOUT, ""));
			return;
		}
		// if it the who is in button
		if (o == whoIsIn) {
			client.sendMessage(new models.Message(models.Message.WHOISIN, ""));
			return;
		}

		// ok it is coming from the JTextField
		if (connected) {
			// just have to send the message
			client.sendMessage(new models.Message(models.Message.MESSAGE, tf.getText()));
			tf.setText("");
			return;
		}

		if (o == login) {
			// ok it is a connection request
			String username = tf.getText().trim();
			// empty username ignore it
			if (username.length() == 0)
				return;
			// empty serverAddress ignore it
			// JOptionPane.showMessageDialog(this,"Enter server address");
			String server = tfServer.getText().trim();
			if (server.length() == 0)
				return;
			// empty or invalid port numer, ignore it
			String portNumber = tfPort.getText().trim();
			if (portNumber.length() == 0)
				return;
			int port = 0;
			try {
				port = Integer.parseInt(portNumber);
			} catch (Exception en) {
				JOptionPane.showMessageDialog(this, "Invalid Port Number");
				return;
			}

			// try creating a new Client with GUI
			client = new controllers.Client(server, port, username, this);
			// test if we can start the Client
			if (!client.start())
				return;
			tf.setText("");
			label.setText("Enter your message below");
			connected = true;

			// disable login button
			login.setEnabled(false);
			// enable the 2 buttons
			logout.setEnabled(true);
			whoIsIn.setEnabled(true);
			// disable the Server and Port JTextField
			tfServer.setEditable(false);
			tfPort.setEditable(false);
			// Action listener for when the user enter a message
			tf.addActionListener(this);
		}

	}

	public static void main(String[] args) {

		new Client("localhost", 7000);
	}

}
