package by.bsu.lab2.entity;

public class Request {

	private Person client;
	private String description;
	
	public Person getClient() {
		return client;
	}
	public void setClient(Person client) {
		this.client = client;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}