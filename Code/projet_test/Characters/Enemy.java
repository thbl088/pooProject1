package Characters;

import Items.*;
import Stats.*;

public class Enemy extends Character{
	private Item object;

	public Enemy(String name, Item item, Statistics stats){
		super(name, stats);
		this.object = item;
	}

	public Item getObject(){ return this.object; }
}