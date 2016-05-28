package by.bsu.lab2.controller;

import java.util.List;

import by.bsu.lab2.dao.AccountingSystem;
import by.bsu.lab2.dao.DataAccessor;
import by.bsu.lab2.entity.Order;
import by.bsu.lab2.entity.Request;
import by.bsu.lab2.ui.OrderForm;

public class OrderController {

	public OrderForm m_OrderForm;
	public DataAccessor dataAccessObject;
	public AccountingSystem accountingSystem;
	public Order currentOrder;
	public List<Request> current;

	public OrderController(OrderForm orderForm){
		
		m_OrderForm = orderForm;

	}
	public void addMerchandiseToOrder(){

	}

	public void getRequest(){

	}

	public void getRequestList(){

	}

	public void saveOrder(){

	}

}