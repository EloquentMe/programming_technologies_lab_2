public class Merchandise {

	private int amount;
	private String name;
	private int price;

	public Merchandise(){

	}
	
	public Merchandise(String name, int amount, int price){
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	public void finalize() throws Throwable {

	}

}