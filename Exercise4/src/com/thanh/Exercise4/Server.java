package com.thanh.Exercise4;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.thanh.Exercise1.Student;
import com.thanh.Exercise2.Insert;
import com.thanh.Exercise2.JDBCStatement;

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

				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				server = serverSocket.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());

				DataInputStream input = new DataInputStream(server.getInputStream());
				String path = input.readUTF();

				if (path.equals("RecieveData")) {
					
					System.out.println("Receive a read data request...");
					System.out.println("Sending...");
					
					students = new ArrayList<>();
					students = (ArrayList<Student>) JDBCStatement.readData();

					ObjectOutputStream output = new ObjectOutputStream(server.getOutputStream());
					output.writeObject(students);
					
					System.out.println("Sent!");

				} else if (path.equals("SendData")) {
					List<Student> students = new ArrayList<>();
					
					System.out.println("Receive a insert data request...");
					System.out.println("Inserting...");
					
					ObjectInputStream objectInput = new ObjectInputStream(server.getInputStream());

					students = (ArrayList<Student>) objectInput.readObject();

					Insert.insertInfo((ArrayList<Student>) students);
					
					System.out.println("Insert done!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (server != null) {
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
		int port = 6066;
		try {
			Thread t = new Server(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
