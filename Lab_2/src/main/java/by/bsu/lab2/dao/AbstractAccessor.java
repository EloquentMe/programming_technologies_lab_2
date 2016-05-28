package by.bsu.lab2.dao;

import java.sql.Connection;

abstract class AbstractAccessor {
	protected Connection getConnection() {
		return ConnectionPool.getInstance().getConnection();
	}
}
