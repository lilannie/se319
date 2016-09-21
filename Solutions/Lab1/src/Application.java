import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Application extends JFrame implements ActionListener {

	private JPanel main;
	private JButton createClient, createServer;
	
	public Application(){
		super("Chat Application");
		main = new JPanel();
		
		createClient = new JButton("Create Client");
		createClient.setBackground(Color.BLACK);
		createClient.addActionListener(this);
		createClient.setFont(new Font("Calibri", Font.BOLD, 15));
		main.add(createClient);
		
		createServer = new JButton("Create Server");
		createServer.setBackground(Color.BLACK);
		createServer.addActionListener(this);
		createServer.setFont(new Font("Calibri", Font.BOLD, 15));
		main.add(createServer);
		
		add(main, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 100);
		setVisible(true);
	}
	public static void main(String[] args){
		new Application();
	}

	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if (o == createClient) {
			new ClientGUI("localhost", 8080, "default username");
		} else if (o == createServer) {
			new ServerGUI(8080);
		} 
	}
}
