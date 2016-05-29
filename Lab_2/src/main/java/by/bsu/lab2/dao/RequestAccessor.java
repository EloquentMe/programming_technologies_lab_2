package by.bsu.lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.bsu.lab2.entity.Person;
import by.bsu.lab2.entity.Request;

public class RequestAccessor extends AbstractAccessor {

	public void addRequest(Request req) {
		try {
			Connection conn = getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("insert into REQUEST (name, surname, coordinates, description) values (?,?,?,?)");
			
			stmt.setString(1, req.getClient().getName());
			stmt.setString(2, req.getClient().getSurname());
			stmt.setString(3, req.getClient().getCoordinates());
			stmt.setString(4, req.getDescription());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRequest(Request req) {
		try {
			Connection conn = getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("delete from REQUEST where name = ? "
							+ "and surname = ? "
							+ "and coordinates = ? "
							+ "and description = ?");
			
			stmt.setString(1, req.getClient().getName());
			stmt.setString(2, req.getClient().getSurname());
			stmt.setString(3, req.getClient().getCoordinates());
			stmt.setString(4, req.getDescription());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Request> getRequests() {
		try {
			Connection conn = getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("select name, surname, coordinates, description from REQUEST");
			
			ResultSet rs = stmt.executeQuery();
			
			List<Request> res = new ArrayList<>();
			
			while (rs.next()) {
				Person p = new Person();
				p.setName(rs.getString(1));
				p.setSurname(rs.getString(2));
				p.setCoordinates(rs.getString(3));
				Request req = new Request();
				req.setClient(p);
				req.setDescription(rs.getString(4));
				res.add(req);
			}
			
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}


}