package com.neonmixer.dboperations;

import java.sql.*;
import java.util.ArrayList;

import com.neonmixer.db.*;

public class CreateMix {
	private static String connectionUrl="jdbc:sqlserver://localhost;database=Neon-Mixer;user=KeeperXTL;password=12345678;";
	
	public static ArrayList<Mix> create(String insertedName, int insertedPGVG, int insertedVolOfFlud, int insertedWater, int insertedStrengthOfNicoBase, int insertedNicoContent) {
		ArrayList<Mix> mixes = new ArrayList<Mix>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(connectionUrl);
			try {
				Statement statement = conn.createStatement();
				statement.executeUpdate("INSERT INTO Mix (name, PGVG, volOfFlud, water, strengthOfNicoBase, nicoContent) VALUES ('" + insertedName + "', '" + insertedPGVG + "', '" + insertedVolOfFlud + "', '" + insertedWater + "', '" + insertedStrengthOfNicoBase + "', '" + insertedNicoContent + "')");
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Mix WHERE (name='" + insertedName + "') AND (PGVG='" + insertedPGVG + "') AND (volOfFlud='" + insertedVolOfFlud + "') AND (water='" + insertedWater + "') AND (strengthOfNicoBase='" + insertedStrengthOfNicoBase + "') AND (nicoContent='" + insertedNicoContent + "')");
				while(resultSet.next()) {
					int mixId = resultSet.getInt(1);
					String name = resultSet.getString(2);
					int PGVG = resultSet.getInt(3);
					int volOfFlud = resultSet.getInt(4);
					int water = resultSet.getInt(5);
					int strengthOfNicoBase = resultSet.getInt(6);
					int nicoContent = resultSet.getInt(7);
					Mix mix = new Mix(mixId, name, PGVG, volOfFlud, water, strengthOfNicoBase, nicoContent);
					mixes.add(mix);
					System.out.println(mixes);
				}
			} catch(Exception ex) {
				System.out.println(ex);
			} finally {
				conn.close();
			}
		} catch(Exception ex) {
			System.out.println(ex);
		} finally {}
		return mixes;
	}
}
