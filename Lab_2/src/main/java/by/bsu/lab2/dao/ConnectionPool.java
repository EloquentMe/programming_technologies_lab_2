package by.bsu.lab2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionPool {

	private static ConnectionPool instance;

	private Connection sole;
	private String url;

	static synchronized ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	private ConnectionPool() {
		url = "jdbc:sqlite:" + System.getProperty("dbPath");
		createConnection();
	}

	private void createConnection() {
		try {
			sole = DriverManager.getConnection(url);
		} catch (SQLException e) {
			throw new RuntimeException("db is doomed", e);
		}
	}

	Connection getConnection() {
		try {
			if (sole == null || sole.isClosed()) {
				createConnection();
			}
			return sole;
		} catch (SQLException e) {
			throw new RuntimeException("db is doomed", e);
		}
	}

}
