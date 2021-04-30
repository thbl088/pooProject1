package Model;

public class Item {


	private final String NAME;
	private final String DESCRIPTION;
	private final int PRICE;
        private int position_x;
        private int position_y;
        private int width = 170;
        private int height= 182;
        
	public Item(String name, String description , int price, int x, int y){
		this.NAME = name;
		this.DESCRIPTION = description;
		this.PRICE = price;
                this.position_x = x;
                this.position_y = y;
	}
        
	public Item(String name, String description , int price){
		this.NAME = name;
		this.DESCRIPTION = description;
		this.PRICE = price;
	}


	public String getName() { return this.NAME ; }

	public String getDescription() { return this.DESCRIPTION ; }

	public int getPrice() { return this.PRICE ; }
        
        public int getPositionX() { return this.position_x ; }
        
        public int getPositionY() { return this.position_y ; }
        
        public int getPositionHeight() { return this.height; }
        
        public int getPositionWidth() { return this.width; }
}