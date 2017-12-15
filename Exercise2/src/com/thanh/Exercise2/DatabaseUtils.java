package com.thanh.Exercise2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.thanh.Exercise1.Student;

public class DatabaseUtils {

	public static void insertStudents(ArrayList<Student> students) {
		Connection connection = getJDBCConnection();
		try {
			students.stream().forEach(st -> {
				Statement statement = null;
				try {
					statement = connection.createStatement();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				String sql = "Insert into student(last_name,first_name,birth_day,email) values('" + st.getLastName()
						+ "','" + st.getFirstName() + "','" + st.getBirthDay() + "','" + st.getEmail() + "')";
				try {
					statement.executeUpdate(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Student> readStudents() {
		try {
			ArrayList<Student> students = new ArrayList<Student>();
			Statement statement = getJDBCConnection().createStatement();
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

	private static Connection getJDBCConnection() {
		Connection connection = null;
		final String url = "jdbc:mysql://localhost:3306/internship?characterEncoding=utf8&useSSL=false";
		final String user = "root";
		final String password = "admin";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
