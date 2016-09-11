package Chat;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerListener implements Runnable{
	Client lc;
	Scanner in; // this is used to read which is a blocking call

	ServerListener(Client lc, Socket s) {
		try {
			this.lc = lc;
			in = new Scanner(new BufferedInputStream(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (true) { // run forever
			System.out.println("Client - waiting to read");
			String cmd = in.next();
			String s = in.nextLine();
			lc.handleMessage(cmd, s);
		}

	}
}