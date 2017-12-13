package com.thanh.Exercise2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.thanh.Exercise1.Student;

public class JDBCStatement {
	public static List<Student> readData() {
		try {
			ArrayList<Student> students = new ArrayList<Student>();
			Statement statement = JDBCConectionMysql.getJDBCConnection().createStatement();
			String sql = "SELECT * FROM internship.student";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String lname = rs.getString("last_name");
				String fname = rs.getString("first_name");
				String bd = rs.getString("birth_day");
				String email = rs.getString("email");
				students.add(new Student(lname, fname, bd, email));
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
