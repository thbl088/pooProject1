package Locations;

import Items.*;
import java.util.HashMap;

public class ShopTest extends MapTest {

	private Shop shopTest;

	public ShopTest(){
		super(name);
		HashMap<String, Item> shop = new HashMap<>();
		this.items = shop;  //new HashMap<>();
		this.exitShop = null;
	}

	public void setReturn(Map back){
		this.exitShop = back;
	}

	@Override
	public void addItem(Item newItem) {
		items.put(newItem.getName(), newItem);
	}

	public boolean hasItem(String item) {
		return this.items.containsKey(item);
	}

	public void removeItem(String item) {
		this.items.remove(item);
	}

	@Override
	public Item getItem(String item){
		Item itemReturn = this.items.get(item);
		return itemReturn;
	}

	public Map getExitShop() {
		return this.exitShop;
	}


	public void printItems() {
		for (String i : items.keySet()) {
			System.out.println(i + " : " + items.get(i).getDescription() + " Price : " + items.get(i).getPrice() + " gold.");
		}
	}

	public void printPotions(){System.out.println("We have health_potion, attack_potion, defense_potion, crit_potion. Price : " + this.potionCost + " gold.");}

	public int getPotionCost(){return this.potionCost;}
}