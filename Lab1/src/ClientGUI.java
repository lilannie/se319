import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JTextField tf;
	private JTextField tfServer, tfPort;
	private JButton login, logout, whoIsIn;
	private JTextArea ta;
	private boolean connected;
	private Client client;
	private int defaultPort;
	private String defaultHost;

	public ClientGUI(String host, int port) {
		super("Chat Client");
		defaultPort = port;
		defaultHost = host;

		JPanel top = new JPanel(new BorderLayout());
		top.setBorder(new EmptyBorder(5, 0, 5, 0));
		top.setBackground(Color.WHITE);
		JPanel topPanel = new JPanel(new GridLayout(0, 1));
		topPanel.setBackground(Color.WHITE);

		JPanel serverAndPort = new JPanel();

		tfServer = new JTextField(host);
		tfServer.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
		tfServer.setFont(new Font("Calibri", Font.BOLD, 20));

		tfPort = new JTextField("" + port);
		tfPort.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
		tfPort.setFont(new Font("Calibri", Font.BOLD, 20));
		tfPort.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel l1 = new JLabel("Server Address:  ");
		l1.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
		l1.setFont(new Font("Calibri", Font.BOLD, 20));
		
		serverAndPort.add(l1);
		serverAndPort.add(tfServer);
		
		l1 = new JLabel("Port Number:  ");
		l1.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
		l1.setFont(new Font("Calibri", Font.BOLD, 20));
		serverAndPort.add(l1);
		serverAndPort.add(tfPort);
		serverAndPort.add(new JLabel(""));
		
		// adds the Server an port field to the GUI
		topPanel.add(serverAndPort);
		topPanel.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
		
		// the Label and the TextField
		label = new JLabel("Enter your username below", SwingConstants.CENTER);
		label.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		topPanel.add(label);
		tf = new JTextField("Your username");
		tf.setFont(new Font("Calibri", Font.BOLD, 15));
		tf.setBackground(Color.WHITE);
		tf.setForeground(Color.BLACK);
		topPanel.add(tf);
		top.add(topPanel, BorderLayout.SOUTH);
		add(top, BorderLayout.NORTH);
		// The CenterPanel which is the chat room
		ta = new JTextArea("Welcome to the Chat room\n", 10, 20);
		JPanel centerPanel = new JPanel(new GridLayout(1, 1));
		centerPanel.add(new JScrollPane(ta));
		ta.setEditable(false);
		ta.setFont(new Font("Arial", Font.BOLD, 19));
		ta.setForeground(Color.BLUE);
		add(centerPanel, BorderLayout.CENTER);

		// the 3 buttons
		login = new JButton("Enter");
		login.setBackground(Color.WHITE);
		login.addActionListener(this);
		login.setFont(new Font("Calibri", Font.BOLD, 15));

		logout = new JButton("Exit");
		logout.addActionListener(this);
		logout.setBackground(Color.WHITE);
		logout.setFont(new Font("Calibri", Font.BOLD, 15));
		logout.setEnabled(false); // you have to login before being able to
									// logout

		whoIsIn = new JButton("Online");
		whoIsIn.addActionListener(this);
		whoIsIn.setBackground(Color.WHITE);
		whoIsIn.setFont(new Font("Calibri", Font.BOLD, 15));
		whoIsIn.setEnabled(false); // you have to login before being able to Who
									// is in

		JPanel southPanel = new JPanel(new GridLayout(1, 0));
		southPanel.add(login);
		southPanel.add(logout);
		southPanel.add(whoIsIn);
		add(southPanel, BorderLayout.SOUTH);
		southPanel.setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 700);
		setVisible(true);
		tf.requestFocus();

	}

	// called by the Client to append text in the TextArea
	void append(String str) {
		ta.append(str);
		ta.setCaretPosition(ta.getText().length() - 1);
	}

	// called by the GUI is the connection failed
	// we reset our buttons, label, textfield
	void connectionFailed() {
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
		Object source = e.getSource();
		// if it is the Logout button
		if (source == logout) {
			client.sendMessage(new Message(Message.LOGOUT, ""));
			return;
		}
		// if it the who is in button
		if (source == whoIsIn) {
			client.sendMessage(new Message(Message.WHOISIN, ""));
			return;
		}

		// From the JTextField
		if (connected) {
			// just have to send the message
			client.sendMessage(new Message(Message.MESSAGE, tf.getText()));
			tf.setText("");
			return;
		}

		if (source == login) {
			// Connection request
			String username = tf.getText().trim();
			// Empty username ignore it
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
			client = new Client(server, port, username, this);
			// test if we can start the Client
			if (!client.start())
				return;
			tf.setText("");
			label.setText("Enter your message below");
			connected = true;

			// Disable login button
			login.setEnabled(false);
			// Enable the 2 buttons
			logout.setEnabled(true);
			whoIsIn.setEnabled(true);
			// Disable the Server and Port JTextField
			tfServer.setEditable(false);
			tfPort.setEditable(false);
			// Action listener for when the user enter a message
			tf.addActionListener(this);
		}

	}

	public static void main(String[] args) {
		new ClientGUI("localhost", 7000);
	}

}
