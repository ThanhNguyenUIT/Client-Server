package com.thanh.Exercise1;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {

	private JFrame frame;
	private JTextField textLink;
	private JButton btnBrowse, btnUpload;
	String filename, line;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		});
	}

	public Main() {
		initialize();
		
		btnBrowse.addActionListener(e -> {
				filename = FileUtils.chooseFile();
				textLink.setText(filename);
			});
		
		btnUpload.addActionListener(e ->{
			List<Student> listst = FileUtils.getListStudent(filename);
			FileUtils.printListStudent(listst);
		});
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 322, 148);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(12, 17, 56, 16);
		frame.getContentPane().add(lblFile);
		
		textLink = new JTextField();
		textLink.setBounds(50, 14, 116, 22);
		frame.getContentPane().add(textLink);
		textLink.setColumns(10);
		
		btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(192, 13, 97, 25);
		frame.getContentPane().add(btnBrowse);
		
		btnUpload = new JButton("Upload");
		btnUpload.setBounds(50, 57, 97, 25);
		frame.getContentPane().add(btnUpload);
	}
}
