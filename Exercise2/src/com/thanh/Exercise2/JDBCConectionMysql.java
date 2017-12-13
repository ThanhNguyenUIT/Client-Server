package com.thanh.Exercise2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConectionMysql {
	public static Connection getJDBCConnection() {
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
