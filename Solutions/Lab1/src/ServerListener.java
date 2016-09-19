import java.io.IOException;

public class ServerListener extends Thread {

	private Client client;
	
	public ServerListener(Client client){
		this.client = client;
	}
	
	public void run() {
		while (true) {
			try {
				String msg = (String) client.getInput().readObject();
				if (client.getGui() == null) {
					System.out.println(msg);
					System.out.print("> ");
				} else {
					client.getGui().append(msg);
				}
			} catch (IOException e) {
				client.display("Server has close the connection: " + e);
				if (client.getGui() != null)
					client.getGui().connectionFailed();
				break;
			} catch (ClassNotFoundException e2) {
			}
		}
	}
}
