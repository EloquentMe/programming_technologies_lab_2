package by.bsu.lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.bsu.lab2.entity.LogEntry;
import by.bsu.lab2.entity.Merchandise;
import by.bsu.lab2.entity.Order;

public class AccountingAccessor {
	
	public void log(Order order) {
		try {
			Connection conn = getConnection();
			PreparedStatement stmt;

			stmt = conn.prepareStatement("insert into LOG (client, info, total_amount, total_price) value (?,?,?,?)");
			stmt.setString(1, order.getClient().toString());
			stmt.setString(2, productsLog(order.getExistingProducts()));
			stmt.setInt(3, totalAmount(order.getExistingProducts()));
			stmt.setInt(4, totalPrice(order.getExistingProducts()));

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	private int totalPrice(List<Merchandise> existingProducts) {
		int total = 0;
		for(Merchandise m : existingProducts) {
			total += m.getAmount() * m.getPrice();
		}
		return total;
	}



	private int totalAmount(List<Merchandise> existingProducts) {
		int total = 0;
		for(Merchandise m : existingProducts) {
			total += m.getAmount();
		}
		return total;
	}



	private String productsLog(List<Merchandise> existingProducts) {
		StringBuilder builder = new StringBuilder();
		for(Merchandise m : existingProducts) {
			builder.append(m.getName());
			builder.append(" x ");
			builder.append(m.getAmount());
		}
		return builder.toString();
	}



	public List<Integer> getLog() {
		try {
			Connection conn = getConnection();
			PreparedStatement stmt;

			stmt = conn.prepareStatement("select id from LOG");

			ResultSet rs = stmt.executeQuery();
			List<Integer> orders = new ArrayList<>();
			while (rs.next()) {
				orders.add(rs.getInt(1));
			}
			stmt.close();
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public LogEntry getLogEntry(int id) {
		try {
			Connection conn = getConnection();
			PreparedStatement stmt;

			stmt = conn.prepareStatement("select client, info, total_amount, total_price from LOG where id = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			LogEntry answer = new LogEntry();
			
			if (rs.next()) {
				answer.setClient(rs.getString(1));
				answer.setInfo(rs.getString(2));
				answer.setTotal_amount(rs.getInt(3));
				answer.setTotal_price(rs.getInt(4));
			}
		
			return answer;
		} catch (SQLException e) {
			e.printStackTrace();
			return new LogEntry();
		}
	}
	
	private Connection getConnection() {
		return ConnectionPool.getInstance().getConnection();
	}

}