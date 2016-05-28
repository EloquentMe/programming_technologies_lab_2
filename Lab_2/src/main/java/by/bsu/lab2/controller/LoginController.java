package by.bsu.lab2.controller;

import by.bsu.lab2.dao.DataAccessor;
import by.bsu.lab2.ui.LoginForm;

public class LoginController {

	public DataAccessor dataAccessObject;
	public LoginForm m_LoginForm;

	public LoginController(LoginForm logForm){
		m_LoginForm = logForm;

	}

	public void doLogin(String login, String password){

	}

}