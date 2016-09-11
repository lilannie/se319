import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPane;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		configure();
	}

	private void configure() {
		setTitle("Welcome to ChatMe");

		// Configurations
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 271);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);

		addLabels();
		addButtons();
	}

	private void addLabels() {
		JLabel lblNewLabel = new JLabel("Client");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(10, 42, 97, 40);
		mainPane.add(lblNewLabel);

		JLabel lblEnterYourName = new JLabel("Enter Your Name");
		lblEnterYourName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterYourName.setBounds(10, 108, 117, 17);
		mainPane.add(lblEnterYourName);
	}

	private void addButtons() {
		username = new JTextField();
		username.setBounds(10, 136, 117, 17);
		mainPane.add(username);
		username.setColumns(10);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(10, 164, 89, 23);
		mainPane.add(loginButton);

		// Send the username to the client and connect to the server
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = username.getText();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							 new ClientGUI("localhost", 1222, name);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				// dispose of this login page
				dispose();

			}
		});
	}
}
