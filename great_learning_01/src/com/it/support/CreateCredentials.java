package com.it.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateCredentials {

	public static void main(String[] args) {
		Connection connection = null;
		String userName, email, contactNumber;
		Scanner scanner = new Scanner(System.in);
		PreparedStatement preparedStatement = null;

		String sql = "insert into employee(name, email, contact_number) values(?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demotb", "root", "root@123");

			System.out.println("Enter you name:");
			userName = scanner.next();
			System.out.println("Enter you email:");
			email = scanner.next();
			System.out.println("Enter you contact number:");
			contactNumber = scanner.next();

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, contactNumber);

			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				System.out.println("Record inserted " + result);
			} else {
				System.out.println("Error");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}