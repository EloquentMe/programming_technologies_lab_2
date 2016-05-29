package by.bsu.lab2.controller;

import java.util.ArrayList;
import java.util.List;

import by.bsu.lab2.dao.RequestAccessor;
import by.bsu.lab2.entity.Merchandise;
import by.bsu.lab2.entity.Request;
import by.bsu.lab2.ui.RequestForm;

public class RequestController {

	public RequestForm m_RequestForm;
	public Request currentRequest;
	public RequestAccessor dataAccessObject;
	//public List<Request> current;

	public RequestController(RequestForm reqForm){
		m_RequestForm = reqForm;
		dataAccessObject = new RequestAccessor();
		//current = dataAccessObject.getRequests();
	}

	public void addRequest(Request r) {
		currentRequest = r;
		dataAccessObject.addRequest(r);
	}

	
	public void addMerchandise(Merchandise merch) {
		//tempAdd.add(merch);
	}
	
	public void deleteMerchandise(Merchandise merch) {
		//tempAdd.remove(merch);
	}
	
	public void editMerchandise() {
		
	}
	public void deleteRequest() {

	}

	public void getRequestList() {

	}

	public void saveRequest() {

	}

	public void showRequestForm(RequestForm reqForm) {

	}

	public void showRequestList() {

	}

	public void updateRequestList() {

	}

}