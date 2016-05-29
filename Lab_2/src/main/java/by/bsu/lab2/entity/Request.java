package by.bsu.lab2.entity;

public class Request {

	private Person client;
	private String description;
	
	public Request(Person client, String description) {
		this.client = client;
		this.description = description;
	}
	public Request() {
	}
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
	public String toString() {
		return this.client.getName() + " " + this.client.getSurname() + " " + this.client.getCoordinates();
	}
}