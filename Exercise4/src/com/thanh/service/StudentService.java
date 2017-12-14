package com.thanh.service;

import java.util.ArrayList;
import java.util.List;

import com.thanh.Exercise1.Student;
import com.thanh.persistence.StudentDao;

public class StudentService {

	public static List<Student> getStudents() {
		return StudentDao.readStudents();
	}
	
	public static void storeStudents(ArrayList<Student> students){
		StudentDao.insertStudents(students);
	}
}