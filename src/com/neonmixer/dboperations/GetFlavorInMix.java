package com.neonmixer.dboperations;

import com.neonmixer.db.*;

import java.sql.*;
import java.util.ArrayList;

public class GetFlavorInMix {
	private static String connectionUrl="jdbc:sqlserver://localhost;database=Neon-Mixer;user=KeeperXTL;password=12345678;";
	
		public static ArrayList<FlavorInMix> getByMix(int insertedMixId) {
			ArrayList<FlavorInMix> flavorsInMix = new ArrayList<FlavorInMix>();
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
				Connection conn = DriverManager.getConnection(connectionUrl);
				try {
					Statement statement = conn.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM FlavorInMix WHERE mixId=" + insertedMixId);
					while(resultSet.next()) {
						int mixId = resultSet.getInt(1);
						String flavorName = resultSet.getString(2);
						int flavorContent = resultSet.getInt(3);
						FlavorInMix flavorInMix = new FlavorInMix(mixId, flavorName, flavorContent);
						flavorsInMix.add(flavorInMix);
					}
			} catch(Exception ex) {
				System.out.println(ex);
			} finally {
				conn.close();
			}
		} catch(Exception ex) {
			System.out.println(ex);
		} finally {}
			return flavorsInMix;

		}
		}
