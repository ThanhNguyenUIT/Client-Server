package com.thanh.persistence;

import java.util.ArrayList;
import java.util.List;

import com.thanh.Exercise1.Student;
import com.thanh.Exercise2.DatabaseUtils;

public class StudentDao {

    public static List<Student> readStudents () {
        return (ArrayList<Student>) DatabaseUtils.readStudents();
    }
    
    public static void insertStudents(ArrayList<Student> students){
    	DatabaseUtils.insertStudents(students);
    }
}
