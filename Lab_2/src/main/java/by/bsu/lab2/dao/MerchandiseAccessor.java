package by.bsu.lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.bsu.lab2.entity.Merchandise;
import by.bsu.lab2.entity.Person;
import by.bsu.lab2.entity.Request;

public class MerchandiseAccessor extends AbstractAccessor {

	public void addMerchandise(Merchandise merch) {
		try {
			Connection conn = getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("insert into MERCHANDISE (name, amount, price) values (?,?,?)");
			
			stmt.setString(1, merch.getName());
			stmt.setInt(2, merch.getAmount());
			stmt.setInt(3, merch.getPrice());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMerchandise(Merchandise merch) {
		try {
			Connection conn = getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("delete from MERCHANDISE where name = ? "
							+ "and amount = ? "
							+ "and price = ? ");
			
			stmt.setString(1, merch.getName());
			stmt.setInt(2, merch.getAmount());
			stmt.setInt(3, merch.getPrice());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Merchandise> getMerchandise() {
		try {
			Connection conn = getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("select name, amount, price from MERCHANDISE");
			
			ResultSet rs = stmt.executeQuery();
			
			List<Merchandise> res = new ArrayList<>();
			
			while (rs.next()) {
				Merchandise req = new Merchandise();
				req.setName(rs.getString(1));
				req.setAmount(rs.getInt(2));
				req.setPrice(rs.getInt(3));
				res.add(req);
			}
			
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public void updateMerchandise(Merchandise merch) {
		try {
			Connection conn = getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("update MERCHANDISE set amount = ?, price = ? where name = ?");
			
			stmt.setInt(1, merch.getAmount());
			stmt.setInt(2, merch.getPrice());
			stmt.setString(3, merch.getName());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
