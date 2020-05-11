package com.neonmixer.dboperations;

import com.neonmixer.db.*;

import java.sql.*;
import java.util.ArrayList;

public class GetUserMixInnerMix {
	private static String connectionUrl="jdbc:sqlserver://localhost;database=Neon-Mixer;user=KeeperXTL;password=12345678;";
	
	public static ArrayList<UserMixInnerMix> getByMix(int insertedMixId){
		ArrayList<UserMixInnerMix> userMixes = new ArrayList<UserMixInnerMix>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(connectionUrl);
			try {
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM UserMix INNER JOIN Mix ON Mix.mixId = UserMix.mixId WHERE UserMix.mixId=" + insertedMixId);
				while(resultSet.next()) {
					int userId = resultSet.getInt(1);
					int mixId = resultSet.getInt(2);
					String name = resultSet.getString(4);
					int PGVG = resultSet.getInt(5);
					int volOfFlud = resultSet.getInt(6);
					int water = resultSet.getInt(7);
					int strengthOfNicoBase = resultSet.getInt(8);
					int nicoContent = resultSet.getInt(9);
					UserMixInnerMix userMixInnerMix = new UserMixInnerMix(mixId, name, PGVG, volOfFlud, water, strengthOfNicoBase, nicoContent, userId);
					userMixes.add(userMixInnerMix);
				}
			} catch(Exception ex) {
				System.out.println(ex);
			} finally {}
		} catch(Exception ex) {
			System.out.println(ex);
		} finally {}
		return userMixes;
	}
	
	public static ArrayList<UserMixInnerMix> getByUser(int insertedUserId){
		ArrayList<UserMixInnerMix> userMixes = new ArrayList<UserMixInnerMix>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(connectionUrl);
			try {
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM UserMix INNER JOIN Mix ON Mix.mixId = UserMix.mixId WHERE UserMix.userId=" + insertedUserId);
				while(resultSet.next()) {
					int userId = resultSet.getInt(1);
					int mixId = resultSet.getInt(2);
					String name = resultSet.getString(4);
					int PGVG = resultSet.getInt(5);
					int volOfFlud = resultSet.getInt(6);
					int water = resultSet.getInt(7);
					int strengthOfNicoBase = resultSet.getInt(8);
					int nicoContent = resultSet.getInt(9);
					UserMixInnerMix userMixInnerMix = new UserMixInnerMix(mixId, name, PGVG, volOfFlud, water, strengthOfNicoBase, nicoContent, userId);
					userMixes.add(userMixInnerMix);
				}
			} catch(Exception ex) {
				System.out.println(ex);
			} finally {}
		} catch(Exception ex) {
			System.out.println(ex);
		} finally {}
		return userMixes;
	}
}
