package com.thanh.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.thanh.Exercise1.Student;
import com.thanh.service.StudentService;

public class StudentController {

	@SuppressWarnings("unchecked")
	public void processRequest(Socket server, String path) {
		if (path.equals("RecieveData")) {

			System.out.println("Receive a read data request...");
			System.out.println("Sending...");

			List<Student> students = StudentService.getStudents();

			try {
				ObjectOutputStream output = new ObjectOutputStream(server.getOutputStream());
				output.writeObject(students);
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Sent!");

		} else if (path.equals("SendData")) {
			List<Student> students = new ArrayList<>();

			System.out.println("Receive a insert data request...");
			System.out.println("Inserting...");

			try {
				ObjectInputStream objectInput = new ObjectInputStream(server.getInputStream());
				students = (ArrayList<Student>) objectInput.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			StudentService.storeStudents((ArrayList<Student>) students);

			System.out.println("DatabaseUtils done!");
		}
	}

}