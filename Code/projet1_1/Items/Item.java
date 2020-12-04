package projet1_1.Items;

public class Item {

	private String name;
	private String description;
	private int price;

	public Item(String name, String description , int price){
		
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getname(){

		return this.name ;
	}

	public String getdescription(){

		return this.description ;
	}

	public int getprice(){

		return this.price ;
	}
}