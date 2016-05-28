package by.bsu.lab2.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsu.lab2.dao.UserAccessor.Role;

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
		try {
			createConnection();
			fixTables();
		} catch (SQLException e) {
			throw new RuntimeException("db is doomed", e);
		}
	}

	private void fixTables() throws SQLException {
		if (!sanity()) {
			String sql;
			Connection conn = getConnection();
			StringBuilder b = new StringBuilder();
			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(getClass().getResourceAsStream(
							"/create_table.sql")))) {
				do {
					sql = reader.readLine();
					if (sql != null) {
						b.append(sql);
					}
				} while (sql != null);
			} catch (IOException e) {
				throw new RuntimeException("resource file reading failed", e);
			}
			conn.createStatement().executeUpdate(b.toString());
		}

	}

	private boolean sanity() throws SQLException {
		DatabaseMetaData meta = getConnection().getMetaData();
		String[] type = new String[] { "TABLE" };
		boolean logExists = false;
		boolean requestExists = false;
		boolean merchandiseExists = false;
		ResultSet tables = meta.getTables(null, null, null, type);
		while (tables.next()) {
			switch (tables.getString("TABLE_NAME")) {
			case "LOG":
				logExists = true;
				break;
			case "REQUEST":
				requestExists = true;
				break;
			case "MERCHANDISE":
				merchandiseExists = true;
				break;
			}
		}
		return requestExists && logExists && merchandiseExists;
	}

	private void createConnection() throws SQLException {
		sole = DriverManager.getConnection(url);
	}

	Connection getConnection() {
		try {
			if (sole == null || sole.isClosed()) {
				createConnection();
			}
		} catch (SQLException e) {
			throw new RuntimeException("db is doomed", e);
		}
		return sole;
	}

}
