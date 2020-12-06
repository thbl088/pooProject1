package Items;

public class Item {

	private String name;
	private String description;
	private int price;

	public Item(String name, String description , int price){
		
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName(){

		return this.name ;
	}

	public String getDescription(){

		return this.description ;
	}

	public int getPrice(){

		return this.price ;
	}
}