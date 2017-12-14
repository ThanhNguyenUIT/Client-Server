import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

import com.thanh.controller.StudentController;

public class Server extends Thread {

	private JFrame frame;
	private ServerSocket serverSocket;
	private Socket server;
	private StudentController studentController = new StudentController();

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(100000);
	}

	public void run() {
		while (true) {
			try {

				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				server = serverSocket.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());

				DataInputStream input = new DataInputStream(server.getInputStream());
				String path = input.readUTF();

				studentController.processRequest(server, path);
			} catch (IOException e) {
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
