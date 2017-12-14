package com.thanh.Exercise3;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thanh.Exercise1.FileUtils;
import com.thanh.Exercise1.Student;

public class Client {

	private JFrame frame;
	private JTextField textField;
	private JButton btnBrowse;
	private JButton btnUpload;
	private String filePath;
	private List<Student> students;
	private Socket client;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Client window = new Client();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Client() {
		initialize();

		btnBrowse.addActionListener(e -> {
			filePath = FileUtils.chooseFile();
			textField.setText(filePath);
		});

		btnUpload.addActionListener(e -> {
			String host = "localhost";
			int port = 6066;
			try {
				client = new ConnectServer().connectServer(host, port);
				System.out.println("Sending...");
				
				students = (ArrayList<Student>) FileUtils.getListStudent(filePath);

				ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
				output.writeObject(students);
				
				System.out.println("Sent!");

			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				if (client != null) {
					try {
						client.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblFile = new JLabel("File");
		lblFile.setBounds(61, 85, 34, 14);
		frame.getContentPane().add(lblFile);

		textField = new JTextField();
		textField.setBounds(106, 82, 173, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		btnUpload = new JButton("Send Request");
		btnUpload.setBounds(134, 129, 125, 23);
		frame.getContentPane().add(btnUpload);

		btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(298, 81, 89, 23);
		frame.getContentPane().add(btnBrowse);

	}
}
