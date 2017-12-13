package com.thanh.Exercise3;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectServer {
	public Socket connectServer(String host, int port) throws UnknownHostException, IOException{
		System.out.println("Connecting to " + host + " on port " + port);
		Socket client = new Socket(host, port);
		System.out.println("Just connected to " + client.getRemoteSocketAddress());
		return client;
	}
}
