package com.thanh.Exercise3;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.thanh.Exercise1.ReadFile;
import com.thanh.Exercise1.Student;

public class Server extends Thread {

	private JFrame frame;
	private ServerSocket serverSocket;
	private List<Student> students;
	private Socket server;

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(100000);
	}

	@SuppressWarnings("unchecked")
	public void run() {
		while (true) {
			try {
				students = new ArrayList<>();

				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				server = serverSocket.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				
				ObjectInputStream input = new ObjectInputStream(server.getInputStream());
				System.out.println("Reading...");
				students = (ArrayList<Student>) input.readObject();
				System.out.println("Receive!");
				
				ReadFile.printData(students);
				
			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally{
				if(server != null){
					try {
						server.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Server window = new Server();
				window.frame.setVisible(true);

				int port = 6066;
				Thread t = new Server(port);
				t.start();

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Server() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
