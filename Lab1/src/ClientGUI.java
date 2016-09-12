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
	private String username;

	ClientGUI(String host, int port, String username) {
		super("Chat Client");
		defaultPort = port;
		defaultHost = host;

		JPanel north = new JPanel(new BorderLayout());
		JPanel northPanel = new JPanel(new GridLayout(0, 1));

		tfServer = new JTextField(host);
		tfServer.setFont(new Font("Calibri", Font.BOLD, 20));

		tfPort = new JTextField("" + port);
		tfPort.setFont(new Font("Calibri", Font.BOLD, 20));
		tfPort.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel l1 = new JLabel("Server Address:  ");
		l1.setFont(new Font("Calibri", Font.BOLD, 20));

		JPanel serverAndPort = new JPanel();
		serverAndPort.add(l1);
		serverAndPort.add(tfServer);

		l1 = new JLabel("Port Number:  ");
		l1.setFont(new Font("Calibri", Font.BOLD, 20));
		serverAndPort.add(l1);
		serverAndPort.add(tfPort);
		serverAndPort.add(new JLabel(""));

		northPanel.add(serverAndPort);
		northPanel.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));

		label = new JLabel("Enter your username below", SwingConstants.CENTER);
		label.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		northPanel.add(label);
		tf = new JTextField(" Your username");
		tf.setFont(new Font("Calibri", Font.BOLD, 15));
		northPanel.add(tf);
		north.add(northPanel, BorderLayout.SOUTH);
		add(north, BorderLayout.NORTH);

		ta = new JTextArea("Welcome to the Chat room\n", 10, 20);
		JPanel centerPanel = new JPanel(new GridLayout(1, 1));
		centerPanel.add(new JScrollPane(ta));
		ta.setEditable(false);
		ta.setFont(new Font("Arial", Font.BOLD, 19));
		add(centerPanel, BorderLayout.CENTER);

		login = new JButton("Enter");
		login.setBackground(Color.BLACK);
		login.addActionListener(this);
		login.setFont(new Font("Calibri", Font.BOLD, 15));

		logout = new JButton("Exit");
		logout.addActionListener(this);
		logout.setBackground(Color.BLACK);
		logout.setFont(new Font("Calibri", Font.BOLD, 15));
		logout.setEnabled(false); 

		whoIsIn = new JButton("Online");
		whoIsIn.addActionListener(this);
		whoIsIn.setBackground(Color.BLACK);
		whoIsIn.setFont(new Font("Calibri", Font.BOLD, 15));
		whoIsIn.setEnabled(false); 

		JPanel southPanel = new JPanel(new GridLayout(1, 0));
		southPanel.add(login);
		southPanel.add(logout);
		southPanel.add(whoIsIn);
		add(southPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 700);
		setVisible(true);
		tf.requestFocus();
	}

	void append(String str) {
		ta.append(str);
		ta.setCaretPosition(ta.getText().length() - 1);
	}

	void connectionFailed() {
		login.setEnabled(true);
		logout.setEnabled(false);
		
		whoIsIn.setEnabled(false);
		label.setText("Enter your username below");
		tf.setText("username");
		tfPort.setText("" + defaultPort);
		tfServer.setText(defaultHost);
		tfServer.setEditable(false);
		tfPort.setEditable(false);
		tf.removeActionListener(this);
		connected = false;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// if it is the Logout button
		if (o == logout) {
			client.sendMessage(new Message(Message.LOGOUT, ""));
			return;
		}
		if (o == whoIsIn) {
			client.sendMessage(new Message(Message.WHOISIN, ""));
			return;
		}

		if (connected) {
			client.sendMessage(new Message(Message.MESSAGE, tf.getText()));
			tf.setText("");
			return;
		}

		if (o == login) {
			String username = tf.getText().trim();
			if (username.length() == 0)
				return;
			String server = tfServer.getText().trim();
			if (server.length() == 0)
				return;
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

			client = new Client(server, port, username, this);
			if (!client.start())
				return;
			tf.setText("");
			label.setText("Enter your message below");
			connected = true;

			login.setEnabled(false);
			logout.setEnabled(true);
			whoIsIn.setEnabled(true);
			tfServer.setEditable(false);
			tfPort.setEditable(false);
			tf.addActionListener(this);
		}

	}

	public static void main(String[] args) {

		new ClientGUI("localhost", 8080, "default username");
	}

}
