package com.neonmixer.dboperations;

import java.sql.*;

public class CreateFlavorInMix {
	private static String connectionUrl="jdbc:sqlserver://localhost;database=Neon-Mixer;user=KeeperXTL;password=12345678;";
	
	public static void create(int insertedMixId, String insertedFlavorName, int insertedFlavorContent) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(connectionUrl);
			try {
				Statement statement = conn.createStatement();
				statement.executeUpdate("INSERT INTO FlavorInMix (mixId, flavorName, flavorContent) VALUES ('" + insertedMixId + "', '" + insertedFlavorName + "', '" + insertedFlavorContent + "')");
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
