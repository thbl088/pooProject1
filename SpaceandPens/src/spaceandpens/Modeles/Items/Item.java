package Items;

public class Item {


	private final String NAME;
	private final String DESCRIPTION;
	private final int PRICE;

	public Item(String name, String description , int price){
		this.NAME = name;
		this.DESCRIPTION = description;
		this.PRICE = price;
	}


	public String getName() { return this.NAME ; }

	public String getDescription() { return this.DESCRIPTION ; }

	public int getPrice() { return this.PRICE ; }
}