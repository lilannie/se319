package controllers;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import Views.*;

public class Server
{
	private static int uniqueId;
	private Views.Server gui;
	private int port;
	private ArrayList<ClientThread> clientThreads;
	private boolean keepGoing;
	
	public Server(int port) 
	{
		this(port, null);
	}
	
	public Server(int port, Views.Server gui) 
	{
		this.gui = gui;
		this.port = port;
		this.clientThreads = ArrayList<ClientThread>();
	}
}
