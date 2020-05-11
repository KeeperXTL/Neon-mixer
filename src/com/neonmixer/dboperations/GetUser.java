package com.neonmixer.dboperations;

import com.neonmixer.db.*;

import java.sql.*;
import java.util.ArrayList;

public class GetUser {
	private static String connectionUrl="jdbc:sqlserver://localhost;database=Neon-Mixer;user=KeeperXTL;password=12345678;";

	public static ArrayList<Users> getById(int insertedUserId) {
		ArrayList<Users> usersList = new ArrayList<Users>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(connectionUrl);
			try {
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE userId=" + insertedUserId);
				while (resultSet.next()) {
					int userId = resultSet.getInt(1);
					String login = resultSet.getString(2);
					String password = resultSet.getString(3);
					Users users = new Users(userId, login, password);
					usersList.add(users);
				}
			} catch(Exception ex) {
				System.out.println(ex);
			} finally {
				conn.close();
			}
		} catch(Exception ex) {
			System.out.println(ex);
		} finally {}
		return usersList;
	}
	
	public static ArrayList<Users> getByLogin(String insertedUserLogin) {
		ArrayList<Users> usersList = new ArrayList<Users>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(connectionUrl);
			try {
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE login='" + insertedUserLogin + "'");
				while (resultSet.next()) {
					int userId = resultSet.getInt(1);
					String login = resultSet.getString(2);
					String password = resultSet.getString(3);
					Users users = new Users(userId, login, password);
					usersList.add(users);
				}
			} catch(Exception ex) {
				System.out.println(ex);
			} finally {
				conn.close();
			}
		} catch(Exception ex) {
			System.out.println(ex);
		} finally {}
		return usersList;
	}
}
