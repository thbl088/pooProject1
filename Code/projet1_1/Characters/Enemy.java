package projet1_1.Characters;

import projet1_1.Items.*;
import projet1_1.Stats.*;

public class Enemy extends Character{

	private Item object;

	public Enemy(String name, Item item, Statistics stats){
		super(name, stats);
		this.object = item;
	}

	public Item getobject(){

		return this.object;

	}
	
}