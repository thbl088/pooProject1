package Locations;

import Items.*;
import java.util.HashMap;

public class Shop extends Map {

	private HashMap<String, Item> items;
	private Map exitShop;

	public Shop(){
		this.items = new HashMap<>();
		this.exitShop = null;
	}

	public void setReturn(Map back){
		this.exitShop = back;
	}

	public void addItem(Item newItem) {
		items.put(newItem.getName(), newItem);
	}

	public boolean hasItem(String item) {
		return this.items.containsKey(item);
	}

	public void removeItem(String item) {
		this.items.remove(item);
	}

	public Item getItem(String item){
		Item itemReturn = this.items.get(item);
		this.items.remove(item);
		return itemReturn;
	}

	public Map getExitShop() {
		return this.exitShop;
	}



	public void printItems() {
		for (String i : items.keySet()) {
			System.out.println(i + " : " + items.get(i).getDescription());
		}
	}
}