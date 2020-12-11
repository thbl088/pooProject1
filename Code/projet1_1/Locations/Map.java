package Locations;

import Characters.*;

import java.util.HashMap;
import Doors.*;
import Items.*;

public class Map {

	private String name;
	private HashMap<String, Enemy> enemies = new HashMap<>();
	private HashMap<String, Item> groundItems= new HashMap<>();
	private HashMap<String, Npc> npcs= new HashMap<>();
	private Door north;
	private Door east;
	private Door west;
	private Door south;
	private Door shop;
	private String description;

	public Map(){}

	public Map(String newName){
		this.name = newName;
		this.enemies = new HashMap<>();
		this.groundItems = new HashMap<>();
		this.npcs = new HashMap<>();
	}

	public void changeName(String name){ this.name = name; }

	public void addEnemy(Enemy newEnemy) {
		enemies.put(newEnemy.getName(), newEnemy);
	}

	public void addItem(Item newItem) { groundItems.put(newItem.getName(), newItem); }

	public void addNpc(Npc newNPC) { npcs.put(newNPC.getName(), newNPC); }

	public void setNorth(Door newNorth) {
		north = newNorth;
	}

	public void setSouth(Door newSouth) {
		south = newSouth;
	}

	public void setEast(Door newEast) {
		east = newEast;
	}

	public void setWest(Door newWest) {
		west = newWest;
	}

	public void setShop(Door newshop) { 
		shop = newshop; 
	}

	public void setDescription(String desc) { this.description = desc; }

	public boolean isNorth() { return north != null; }

	public boolean isSouth() { return south != null; }

	public boolean isEast() { return east != null; }

	public boolean isWest() { return west != null; }

	public boolean isShop() { return this.shop != null; }

	public Door getNorth() { return north; }

	public Door getSouth() { return south; }

	public Door getEast() { return east; }

	public Door getWest() { return west; }

	public Door getShop() { return shop; }

	public String getName() { return this.name; }

	public String getDescription() { return this.getName() + " : " + this.description; }

	public HashMap<String, Enemy> getEnemies(){return enemies;} //warning mais on se fiche de l'ordre des ennemies

	public Item getItem(String item) {
		Item itemReturn = groundItems.get(item);
		groundItems.remove(item);
		return itemReturn;
	}
	public boolean isNpc(String Npc) { return npcs.containsKey(Npc); }

	public Npc getNpc(String Npc) {
		return npcs.get(Npc);
	}

	public String getEnemiesList() {
		if (enemies.isEmpty()) {
			return "there are no enemies here";
		} else if (enemies.size() == 1){
			return "There is " + enemies.size() + " enemy on this map : " + enemies.keySet();
		}
		else {
			return "There are " + enemies.size() + " enemies on this map : " + enemies.keySet();
		}
	}

	public String getGroundItemsList() {
		if (groundItems.isEmpty()) {
			return "there are no items here";
		} else if (groundItems.size() == 1){
			return "There is " + groundItems.size() + " item on this map : " + groundItems.keySet();
		}
		else {
			return "There are " + groundItems.size() + " items on this map : " + groundItems.keySet();
		}
	}

	public String getNpcsList() {
		if (npcs.isEmpty()) {
			return "there are no NPCs here";
		} else if (npcs.size() == 1){
			return "There is " + npcs.size() + " NPC on this map : " + npcs.keySet();
		}
		else {
			return "There are " + npcs.size() + " NPCs on this map : " + npcs.keySet();
		}
	}

	public String toString() {
		return this.getName() + " : " + this.getDescription()
				+ "\n"
				+ "Shop : " + this.isShop();
	}
}
