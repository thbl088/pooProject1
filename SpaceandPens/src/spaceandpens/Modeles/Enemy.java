package spaceandpens.Modeles;



public class Enemy extends Character{
	protected Item object;

	public Enemy(String name, Item item, Statistics stats){
		super(name, stats);
		this.object = item;
	}

	public Enemy(String name, Statistics stats){
		super(name, stats);
		this.object = null;
	}

	public Enemy(){}

	public Item getObject(){ return this.object; }
}