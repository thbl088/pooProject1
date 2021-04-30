package Model;



public class Enemy extends Character{
	protected Item object;
        protected int position_x;
        protected int position_y;
        protected int width = 170;
        protected int height = 182;
        
        public Enemy(String name, Item item, Statistics stats, int x, int y, int w, int h){
            	super(name, stats);
		this.object = item;
                this.position_x = x;
                this.position_y = y;
                this.width = w;
                this.height = h;
        }
	public Enemy(String name, Item item, Statistics stats, int x, int y){
		super(name, stats);
		this.object = item;
                this.position_x = x;
                this.position_y = y;
	}

	public Enemy(String name, Statistics stats, int x, int y){
		super(name, stats);
		this.object = null;
                this.position_x = x;
                this.position_y = y;
	}

	public Enemy(){}

	public Item getObject(){ return this.object; }
        
        public int getPositionX(){ return this.position_x;}
        
        public int getPositionY(){ return this.position_y;}
        
        public int getPositionWidth(){ return this.width;}
        
        public int getPositionHeight(){ return this.height;}
}