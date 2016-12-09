package edu.iastate.anniesteenson.lab1;//package lab3;

import java.net.*;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.*;
import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class Server implements Runnable
{
	private ServerSocket serverSocket = null;
	private File file = new File("chat.txt");
	private PrintWriter writer;
	ArrayList<ClientHandler> clients = new ArrayList<>();

	byte[] salt = {
			(byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
			(byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
	};
	int iterationCount = 19;
	String secretKey = "secret";
	KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
	SecretKey key;
	AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
	Cipher ecipher;
	Cipher dcipher;

	public Server(int port)
	{
		try {
			System.out.println("Binding to port " + port + ", please wait  ...");
			serverSocket = new ServerSocket(port);
			System.out.println("Server started: " + serverSocket);
			writer = new PrintWriter(file);
			key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
		} catch (Exception e){
			System.out.println("Can not listen on port " + port + ": " + e.getMessage());
		}
	}
	public void run()
	{
		// System.out.println("Server Running");
		int clientNum = 0;
		while (true) {
			findClient(clientNum);
			clientNum++;
		}
	}
	private int findClient(int ID)
	{
		try {
			// System.out.println("Waiting for client " + ID + " to connect!");
			Socket clientSocket = serverSocket.accept();
			System.out.println("Server got connected to a client " + ID);
			addThread(clientSocket, ID);
		} catch (IOException e) {
			System.out.println("Client Accept failed: 4444");
			System.exit(-1);
		}
		return ID;
	}
	private void addThread(Socket socket, int ID)
	{
		// System.out.println("Adding client handler "+ ID);
		ClientHandler handler = new ClientHandler(socket, ID);
		clients.add(handler);
		// System.out.println("Client array size: " + clients.size());
		handler.start();
	}
	public synchronized void recieveMessage(String message, int clientId)
	{
		System.out.println("Server received message: "+ message);
		broadcastMessage(message, clientId);
		writer.println(message);
		writer.flush();
	}
	public void broadcastMessage(String message, int clientId)
	{
		System.out.println("Broadcasting message: "+ message);
		for (ClientHandler handler: clients) {
			if (handler.num != clientId)
				handler.sendClientMessage(message);
		}
	}
	public synchronized String readChat()
	{
		String chat = "";
		try {
			Scanner fileScanner = new Scanner(file);
			int i = 0;
			while(fileScanner.hasNextLine()) {
				chat += i + ". "+ fileScanner.nextLine();
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return chat;
	}
	public synchronized void removeMessage(int ID)
	{
		System.out.println("Removing message on line number: "+ ID);
		File inputFile = new File("chat.txt");
		File tempFile = new File("tempFile.txt");
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(tempFile));
			String currentLine;
			int i = 0;

			while((currentLine = fileReader.readLine()) != null) {
				if(i == ID) continue;
				fileWriter.write(currentLine + System.getProperty("line.separator"));
				i++;
			}
			fileWriter.close();
			fileReader.close();
			if (!tempFile.renameTo(inputFile)) {
				System.out.println("Failed to rename file.");
			}
			else {
				file = tempFile;
				writer = new PrintWriter(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		Server server = new Server(1222);
		server.run();
	}

	class ClientHandler extends Thread {
		Socket client; // this is socket on the server side that connects to the CLIENT
		int num; // keeps track of its number just for identifying purposes
		Scanner in;
		PrintWriter out;

		ClientHandler(Socket client, int n)
		{
			this.client = client;
			num = n;
			try {
				in = new Scanner(new BufferedInputStream(client.getInputStream()));
				out = new PrintWriter(new BufferedOutputStream(client.getOutputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void run()
		{
			while (true) {
				// System.out.println("Handler "+num+" - waiting to read");
				try {
					String input = in.nextLine();
					// System.out.println("Client handler "+num+" received message: "+input);
					handleMessage(decrypt(input.trim()));
				} catch (Exception e) {
					System.out.println("\nClient "+ num+" has disconnected.");
					in.close();
					out.close();
					break;
				}
			}
		}
		void handleMessage(String s)
		{
			String[] input = s.split("\\|");
			if (input.length >= 2) {
				String user = input[0];
				// System.out.println("User: "+user);
				int request = Integer.parseInt(input[1]);
				// System.out.println("Request: "+request);
				if (user.equals("Admin")) {
					switch (request) {
						case 1: {
							// Broadcast message to clients
							String message = user + ": " +
									String.join("", Arrays.copyOfRange(input, 2, input.length));
							recieveMessage(message, num);
							break;
						}
						case 2: {
							// List all chat messages
							sendClientMessage(readChat());
							break;
						}
						case 3: {
							// Delete a selected message
							removeMessage(Integer.parseInt(input[2]));
							break;
						}
					}
				}
				else {
					switch (request) {
						// Send message to server
						case 1: {
							String message = user + ": " +
									String.join("", Arrays.copyOfRange(input, 2, input.length));
							recieveMessage(message, num);
							break;
						}
						// Send image to server
						case 2: {
							// String img = decrypt(input[2]);
							System.out.println("Recieved Image: ");
							// recieveMessage(img, num);
							break;
						}
					}
				}
			}
			else {
				System.out.println("Client sent invalid message: "+ s);
			}
		}
		void sendClientMessage(String message)
		{
			System.out.println("Sending client "+num+" message: "+ message);
			out.println(encrypt(message));
			out.flush();
		}
		public String encrypt(String message)
		{
			try {
				ecipher = Cipher.getInstance(key.getAlgorithm());
				ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
				String charSet="UTF-8";
				byte[] in = message.getBytes(charSet);
				byte[] out = ecipher.doFinal(in);
				String encStr=new sun.misc.BASE64Encoder().encode(out);
				return encStr;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		}
		public String decrypt(String message)
		{
			try {
				dcipher=Cipher.getInstance(key.getAlgorithm());
				dcipher.init(Cipher.DECRYPT_MODE, key,paramSpec);
				byte[] enc = new sun.misc.BASE64Decoder().decodeBuffer(message);
				byte[] utf8 = dcipher.doFinal(enc);
				String charSet="UTF-8";
				String plainStr = new String(utf8, charSet);
				return plainStr;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		}
	}
}