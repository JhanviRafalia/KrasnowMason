package com.gmu.databasedemo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class PreparedStatementCreator {
	private static final Logger LOGGER = Logger.getLogger(PreparedStatementCreator.class.getName());
	
	private final Connection connection;

	PreparedStatementCreator() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mysql";
			String user = "root";
			String pass = "root";

			connection = DriverManager.getConnection(url, user, pass);
			addShutdownHook();
		} catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private void addShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					connection.close();
				} catch (SQLException ex) {
					LOGGER.info("Cannot close db connection " + ex.getStackTrace());
				}
			}
		});
	}
	
	public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		return connection.prepareStatement(sql);
	}
}
