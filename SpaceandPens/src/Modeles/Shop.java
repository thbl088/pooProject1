package Modeles;

import Modeles.*;
import java.util.HashMap;

public class Shop extends Map {

	private final HashMap<String, Item> ITEMS;
	private Map exitShop;
	private final int POTION_COST;

	public Shop(String name){
		super(name);
		this.ITEMS = new HashMap<>();  //new HashMap<>();
		this.POTION_COST = 5;
		this.exitShop = null;
	}

	public void setReturn(Map back){
		this.exitShop = back;
	}

	@Override
	public void addItem(Item newItem) {
		this.ITEMS.put(newItem.getName(), newItem);
	}

	// public boolean hasItem(String item) { return this.ITEMS.containsKey(item); }

	public void removeItem(String item) {
		this.ITEMS.remove(item);
	}

	
	public Item getItem(String item){
		return this.ITEMS.get(item);
	}

	public HashMap<String, Item> getItems() { return this.ITEMS; }

	public Map getExitShop() {
		return this.exitShop;
	}

	public void printItems() {
		for (String i : this.ITEMS.keySet()) {
			System.out.println(i + " : " + this.ITEMS.get(i).getDescription() + " Price : " + this.ITEMS.get(i).getPrice() + " gold.");
		}
	}

	public void printPotions(){System.out.println("We have health_potion, attack_potion, defense_potion, crit_potion. Price : " + this.POTION_COST + " gold.");}

	public int getPotionCost(){return this.POTION_COST;}
}