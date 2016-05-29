package by.bsu.lab2.controller;

import java.util.List;

import by.bsu.lab2.dao.AccountingAccessor;
import by.bsu.lab2.dao.MerchandiseAccessor;
import by.bsu.lab2.dao.RequestAccessor;
import by.bsu.lab2.entity.Merchandise;
import by.bsu.lab2.entity.Order;
import by.bsu.lab2.entity.Request;
import by.bsu.lab2.ui.OrderForm;

public class OrderController {

	public OrderForm m_OrderForm;
	public RequestAccessor dataAccessObject;
	public MerchandiseAccessor merchandiseAccessor;
	public AccountingAccessor accountingSystem;
	//public Order currentOrder;
	public List<Request> current;
	private List<Merchandise> temp;

	public OrderController(OrderForm orderForm) {
		m_OrderForm = orderForm;
		merchandiseAccessor = new MerchandiseAccessor();
		dataAccessObject = new RequestAccessor();
		accountingSystem = new AccountingAccessor();
	}
	public void addMerchandiseToOrder(){

	}

	public List<Request> createRList() {
		current = dataAccessObject.getRequests();
		return current; 
	}
	
	public List<Merchandise> createInventory() {
		temp = merchandiseAccessor.getMerchandise();
		return temp; 
	}
	
	public void getRequest(){

	}

	public void updMerch(Merchandise m){
		merchandiseAccessor.updateMerchandise(m);
	}

	public void saveOrder(Order order, Request req){
		accountingSystem.log(order);
		dataAccessObject.deleteRequest(req);
	}

}