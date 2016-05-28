package by.bsu.lab2.controller;

import by.bsu.lab2.dao.UserAccessor;
import by.bsu.lab2.dao.UserAccessor.Role;
import by.bsu.lab2.ui.LoginForm;

public class LoginController {

	private UserAccessor userAccessor;
	private LoginForm loginForm;

	public LoginController(LoginForm loginForm){
		this.loginForm = loginForm;
		userAccessor = new UserAccessor();
	}

	public Role doLogin(Role login, String password){
		return userAccessor.doLogin(login, password);
	}

}