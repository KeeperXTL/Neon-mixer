package com.neonmixer.dboperations;

import java.sql.*;

public class CreateUserMix {
	private static String connectionUrl="jdbc:sqlserver://localhost;database=Neon-Mixer;user=KeeperXTL;password=12345678;";
	
	public static void create(int insertedUserId, int insertedMixId) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(connectionUrl);
			try {
				Statement statement = conn.createStatement();
				statement.executeUpdate("INSERT INTO UserMix (userId, mixId) VALUES ('" + insertedUserId + "', '" + insertedMixId + "')");
			} catch(Exception ex) {
				System.out.println(ex);
			} finally {
				conn.close();
			}
		} catch(Exception ex) {
			System.out.println(ex);
		} finally {}
	}
}
