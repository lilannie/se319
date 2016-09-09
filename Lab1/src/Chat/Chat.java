package Chat;

import java.util.Scanner;

public class Chat {

	private ServerListener sl;

	public static void main(String[] args) {
		ListClient lc = new ListClient();
		sl = new ServerListener(lc, new Socket());
	}

}
