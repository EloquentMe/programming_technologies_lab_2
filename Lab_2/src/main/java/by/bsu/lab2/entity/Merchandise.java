package by.bsu.lab2.entity;
public class Merchandise {

	private int amount;
	private String name;
	private int price;
	
	public Merchandise(String name, int amount, int price) {
		this.amount = amount;
		this.name = name;
		this.price = price;
	}
	public Merchandise() {
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String toString() {
		return this.getName() + " " + this.getAmount() + " " + this.getPrice();
	}
	public String toStringReq() {
		return this.getName() + " " + this.getAmount() + " ";
	}
}