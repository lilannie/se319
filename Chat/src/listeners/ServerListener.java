package listeners;

import java.io.IOException;

public class ServerListener extends Thread {
	private controllers.Client client;

	public ServerListener(controllers.Client client) {
		this.client = client;
	}

	public void run() {
		while (true) {
			try {
				String msg = (String) client.getInput().readObject();
				// if console mode print the message and add back the prompt
				if (client.getGui() == null) {
					System.out.println(msg);
					System.out.print("> ");
				} else {
					client.getGui().append(msg);
				}
			} catch (IOException exception) {
				client.print("Server has close the connection: " + exception);
				if (client.getGui() != null)
					client.getGui().connectionFailed();
				break;
			}
			// can't happen with a String object but need the catch anyhow
			catch (ClassNotFoundException e2) {
			}
		}
	}

}
