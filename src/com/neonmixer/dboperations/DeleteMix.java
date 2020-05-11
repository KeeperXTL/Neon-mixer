package com.neonmixer.dboperations;

import java.sql.*;

public class DeleteMix {
	private static String connectionUrl="jdbc:sqlserver://localhost;database=Neon-Mixer;user=KeeperXTL;password=12345678;";

	public static void delete(int insertedMixId) {
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
		Connection conn = DriverManager.getConnection(connectionUrl);
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate("DELETE FROM Mix WHERE mixId=" + insertedMixId);
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
