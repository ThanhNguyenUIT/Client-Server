package com.thanh.Exercise2;

import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thanh.Exercise1.ReadFile;
import com.thanh.Exercise1.Student;

public class Main {

	private JFrame frame;
	private JTextField link;
	private JButton btnBrowse;
	private JButton btnInsert;
	private JButton btnShow;
	private String filePath;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
		btnBrowse.addActionListener(e -> {

			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(null);
			File f = fc.getSelectedFile();
			filePath = f.getAbsolutePath();
			link.setText(filePath);
		});
		btnInsert.addActionListener(e -> {
			List<Student> listStudent = ReadFile.getListStudent(filePath);
			Insert.insertInfo((ArrayList<Student>) listStudent);
		});

		btnShow.addActionListener(e -> {
			List<Student> students = (ArrayList<Student>) JDBCStatement.readData();
			ReadFile.printData(students);
		});
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbFile = new JLabel("File");
		lbFile.setBounds(41, 72, 61, 16);
		frame.getContentPane().add(lbFile);

		link = new JTextField();
		link.setBounds(120, 67, 130, 26);
		frame.getContentPane().add(link);
		link.setColumns(10);

		btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(262, 67, 117, 29);

		frame.getContentPane().add(btnBrowse);

		btnInsert = new JButton("Insert");

		btnInsert.setBounds(87, 123, 80, 29);
		frame.getContentPane().add(btnInsert);

		btnShow = new JButton("Show");
		btnShow.setBounds(188, 123, 86, 29);
		frame.getContentPane().add(btnShow);
	}

}
