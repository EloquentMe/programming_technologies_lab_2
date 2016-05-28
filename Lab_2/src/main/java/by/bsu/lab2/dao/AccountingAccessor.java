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

public class AccountingAccessor  extends AbstractAccessor {

	public void log(Order order) {
		try {
			Connection conn = getConnection();
			PreparedStatement stmt;

			stmt = conn
					.prepareStatement("insert into LOG (client, info, total_amount, total_price) value (?,?,?,?)");
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
		for (Merchandise m : existingProducts) {
			total += m.getAmount() * m.getPrice();
		}
		return total;
	}

	private int totalAmount(List<Merchandise> existingProducts) {
		int total = 0;
		for (Merchandise m : existingProducts) {
			total += m.getAmount();
		}
		return total;
	}

	private String productsLog(List<Merchandise> existingProducts) {
		StringBuilder builder = new StringBuilder();
		for (Merchandise m : existingProducts) {
			builder.append(m.getName());
			builder.append(" x ");
			builder.append(m.getAmount());
		}
		return builder.toString();
	}

	public List<LogEntry> getLog() {
		try {
			Connection conn = getConnection();
			PreparedStatement stmt;

			stmt = conn
					.prepareStatement("select client, info, total_amount, total_price from LOG");

			ResultSet rs = stmt.executeQuery();

			List<LogEntry> res = new ArrayList<>();

			while (rs.next()) {
				LogEntry ans = new LogEntry();
				ans.setClient(rs.getString(1));
				ans.setInfo(rs.getString(2));
				ans.setTotal_amount(rs.getInt(3));
				ans.setTotal_price(rs.getInt(4));
			}

			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}