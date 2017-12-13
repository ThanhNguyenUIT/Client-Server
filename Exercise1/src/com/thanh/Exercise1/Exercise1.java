package com.thanh.Exercise1;

import java.awt.EventQueue;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Exercise1 {

	private JFrame frame;
	private JTextField textLink;
	private JButton btnBrowse, btnUpload;
	String filename, line;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
				try {
					Exercise1 window = new Exercise1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		});
	}

	public Exercise1() {
		initialize();
		
		btnBrowse.addActionListener(e -> {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(null);
				File f = fc.getSelectedFile();
				filename = f.getAbsolutePath();
				textLink.setText(filename);
			});
		
		btnUpload.addActionListener(e ->{
			List<Student> listst = ReadFile.getListStudent(filename);
			ReadFile.printData(listst);
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
