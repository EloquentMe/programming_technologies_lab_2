package by.bsu.lab2.controller;

import by.bsu.lab2.dao.UserAccessor.Role;
import by.bsu.lab2.ui.InventoryForm;
import by.bsu.lab2.ui.LoginForm;
import by.bsu.lab2.ui.OrderForm;
import by.bsu.lab2.ui.RequestForm;

public class FormController {
	
	private InventoryForm invForm;
	private LoginForm loginForm;
	private OrderForm orderForm;
	private RequestForm reqForm;
	
	public FormController()
	{
		this.invForm = new InventoryForm();
		this.loginForm = null;
		this.orderForm = new OrderForm();
		this.reqForm = new RequestForm();
	}
	
	public FormController(InventoryForm inv, LoginForm login, OrderForm ord, RequestForm req) {
		this.invForm = inv;
		this.loginForm = login;
		this.orderForm = ord;
		this.reqForm = req;
	}
	
	public void showForm(Role role){
		switch(role) {
		case CLERK:
			reqForm.setVisible(true);
			break;
		case MANAGER:
			invForm.setVisible(true);
			break;
		case SALESMAN:
			orderForm.setVisible(true);
			break;
		}
	}
	public void hideEverything()
	{
		invForm.setVisible(false);
		loginForm.setVisible(false);
		orderForm.setVisible(false);
		reqForm.setVisible(false);
	}

}
