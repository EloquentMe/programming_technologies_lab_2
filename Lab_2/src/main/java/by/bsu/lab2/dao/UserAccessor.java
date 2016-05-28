package by.bsu.lab2.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumMap;
import java.util.Map;

public class UserAccessor {

	public static enum Role {
		MANAGER, SALESMAN, CLERK;
	}

	Map<Role, String> users;

	public UserAccessor() {
		users = new EnumMap<>(Role.class);
		String r;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				getClass().getResourceAsStream("/users.txt")))) {
			do {
				r = reader.readLine();
				if (r == null) {
					break;
				}
				String[] line = r.split(" ", 2);
				Role role = Role.valueOf(line[0]);
				String pass = line[1];
				users.put(role, pass);
			} while(r != null);
		} catch (IOException e) {
			throw new RuntimeException("resource file reading failed", e);
		}
	}

	public Role doLogin(Role username, String pass) {
		if (pass.equals(users.get(username))) {
			return username;
		} else {
			return null;
		}
	}

}
