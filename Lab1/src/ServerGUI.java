import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ServerGUI extends JFrame implements ActionListener, WindowListener {
	private static final long serialVersionUID = 1L;
	private JButton stopStart;
	private JTextArea chat, event;
	private JTextField tPortNumber;
	private Server server;

	public ServerGUI(int port) {
		super("Chat Server");
		server = null;

		JPanel north = new JPanel(new BorderLayout());
		JPanel p = new JPanel();
		JLabel portLabel = new JLabel("Enter port number: ");
		portLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		north.add(portLabel);

		tPortNumber = new JTextField("  " + port, 10);
		tPortNumber.setFont(new Font("Calibri", Font.BOLD, 20));
		p.add(tPortNumber);

		stopStart = new JButton("Start");
		stopStart.setFont(new Font("Calibri", Font.BOLD, 15));
		stopStart.addActionListener(this);
		p.add(stopStart);

		north.add(p, "South");
		add(north, BorderLayout.NORTH);

		JPanel center = new JPanel(new GridLayout(2, 1));

		chat = new JTextArea(10, 20);
		chat.setEditable(false);
		chat.setWrapStyleWord(true);
		chat.setFont(new Font("Arial", Font.BOLD, 19));
		appendRoom("Chat room.\n");
		center.add(new JScrollPane(chat));

		event = new JTextArea(10, 20);
		event.setFont(new Font("Arial", Font.BOLD, 19));
		event.setEditable(false);
		appendEvent("Events log.\n");
		center.add(new JScrollPane(event));
		add(center);

		addWindowListener(this);
		setSize(600, 700);
		setVisible(true);
	}

	public static void main(String[] arg) {
		new ServerGUI(8080);
	}

	public void appendRoom(String str) {
		chat.append(str);
		chat.setCaretPosition(chat.getText().length() - 1);
	}

	public void appendEvent(String str) {
		event.append(str);
		event.setCaretPosition(chat.getText().length() - 1);
	}

	public void actionPerformed(ActionEvent e) {
		if (server != null) {
			server.stop();
			server = null;
			tPortNumber.setEditable(true);
			stopStart.setText("Start");
			return;
		}
		int port;
		try {
			port = Integer.parseInt(tPortNumber.getText().trim());
		} catch (Exception er) {
			appendEvent("Invalid port number");
			return;
		}
		server = new Server(port, this);
		new ServerRunning().start();
		stopStart.setText("Stop");
		tPortNumber.setEditable(false);
	}

	public void windowClosing(WindowEvent e) {
		if (server != null) {
			try {
				server.stop();
			} catch (Exception eClose) {
			}
			server = null;
		}
		dispose();
		System.exit(0);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	class ServerRunning extends Thread {
		public void run() {
			server.start();
			stopStart.setText("Start");
			tPortNumber.setEditable(true);
			appendEvent("Server crashed\n");
			server = null;
		}
	}

}
