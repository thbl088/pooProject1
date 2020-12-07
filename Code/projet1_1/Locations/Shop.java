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

	public void getItem(String item){
		items.get(item);
		this.removeItem(item);
	}

	public Map getExitShop() {
		return this.exitShop;
	}

	public void removeItem(String item) {
		items.remove(item);
	}

	public void printItems() {
		for (String i : items.keySet()) {
			System.out.println(i + " : " + items.get(i).getDescription() + "\n");
		}
	}
}