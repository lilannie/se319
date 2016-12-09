package edu.iastate.anniesteenson.lab1;

import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import java.util.*;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.*;
import javax.crypto.Cipher;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.imageio.ImageIO;

public class Client implements Runnable
{
	static Scanner scan;
	private PrintWriter out = null;
	private String username;
	ServerListener sl;

	byte[] salt = {
			(byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
			(byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
	};
	int iterationCount = 19;
	String secretKey = "secret";
	KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
	SecretKey key;
	AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
	Cipher encipher;
	Cipher decipher;

	public Client(String ipAddr, String username, int serverPort)
	{
		this.username = username.trim();
		try
		{
			Socket socket = new Socket(ipAddr, serverPort);
			System.out.println("Welcome "+ username);
			out = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
			// ObjectOutputStream imageOut = new ObjectOutputStream(socket.getOutputStream());
			key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

			sl = new ServerListener(this, socket);
			Thread thread;
			thread = new Thread(sl);
			thread.start();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	public void run()
	{
		if (username.equals("Admin")) {
			System.out.println("Admin Actions");
			System.out.println("1. Broadcast message to all clients.");
			System.out.println("2. List all messages so far.");
			System.out.println("3. Delete a selected message.");
			System.out.print("Enter Action Number: ");
		}
		else {
			System.out.println("Client Actions");
			System.out.println("1. Send a message to the server.");
			System.out.println("2. Send an image to the server.");
			System.out.print("Enter Action Number: ");
		}
		while (scan.hasNextLine()) {
			getAction();
		}
	}
	public void getAction()
	{
		String input = scan.nextLine();

		try {
			int action = Integer.parseInt(input);
			processAction(action);
		} catch (Exception e) {
			System.out.println("Input only a number");
		}
		// System.out.println("Received action: "+action);
		System.out.println("Enter Action Number: ");
	}
	public void processAction(int action)
	{
		if (username.equals("Admin")) {
			switch (action) {
				case 1: {
					// Broadcast message to clients
					System.out.println("Enter message to broadcast: ");
					String message = "Admin|1|"+scan.nextLine();
					sendServer(message);
					break;
				}
				case 2: {
					// List all chat messages
					sendServer("Admin|2");
					break;
				}
				case 3: {
					// Delete a selected message
					System.out.println("Enter message id to remove: ");
					String message = "Admin|3|"+scan.nextLine();
					sendServer(message);
					break;
				}
				default: {
					System.out.println("Invalid Action Number");
					break;
				}
			}
		}
		else {
			switch (action) {
				case 1: {
					// Send message
					System.out.print("Enter message to send: ");
					String message = username+"|1|"+scan.nextLine();
					sendServer(message);
					break;
				}
				case 2: {
					System.out.print("Enter a jpg image file name to send: ");
					String fileName = scan.nextLine();
					try {
						BufferedImage img = ImageIO.read(new File(fileName));
						sendImgServer(img);
					} catch (Exception e) {
						System.out.println("Cannot find image file.");
					}
					//sendServer(message);
					break;
				}
				default: {
					System.out.println("Invalid Action Number");
					break;
				}
			}
		}
	}
	public void sendServer(String message)
	{
		System.out.println("Sending message to server: " + message);
		out.println(encrypt(message));
		out.flush();
	}
	public void sendImgServer(BufferedImage img) {
		try {
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			ImageIO.write(img, "jpg", byteStream);
			byteStream.flush();
			byte[] imageInByte = byteStream.toByteArray();
			byteStream.close();
			String prepend = username+"|2|";
			String encryptedPrepend = encrypt(prepend);
			String encryptedImage = encryptByteArr(imageInByte);
			sendServer(encryptedPrepend+encryptedImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String encryptByteArr(byte[] message)
	{
		try {
			encipher = Cipher.getInstance(key.getAlgorithm());
			encipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			byte[] out = encipher.doFinal(message);
			return new sun.misc.BASE64Encoder().encode(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public String encrypt(String message)
	{
		try {
			encipher = Cipher.getInstance(key.getAlgorithm());
			encipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			String charSet = "UTF-8";
			byte[] in = message.getBytes(charSet);
			byte[] out = encipher.doFinal(in);
			return new sun.misc.BASE64Encoder().encode(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public String decrypt(String message)
	{
		try {
			decipher = Cipher.getInstance(key.getAlgorithm());
			decipher.init(Cipher.DECRYPT_MODE, key,paramSpec);
			byte[] enc = new sun.misc.BASE64Decoder().decodeBuffer(message);
			byte[] utf8 = decipher.doFinal(enc);
			String charSet = "UTF-8";
			return new String(utf8, charSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String args[])
	{
		scan = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = scan.nextLine();
		Client client = new Client("localhost", name, 1222);
		client.run();
		System.out.println("Closing scanner");
		scan.close();
	}

	class ServerListener implements Runnable {
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
				// System.out.println("Client - waiting to read");
				String s = in.nextLine();
				System.out.println("\nMessage from server: " + decrypt(s));
			}
		}
	}
}
