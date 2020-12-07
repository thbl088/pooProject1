package Locations;

import Characters.*;
import java.util.HashMap;
import Doors.*;

public class Map {

	private String name;
	private HashMap<String, Enemy> enemies;
	private Door north;
	private Door east;
	private Door west;
	private Door south;
	private Shop shop;
	private String description;
	
	public Map(String newName){
		this.name = newName;
		this.enemies = new HashMap<>();
	}

	public void addEnemy(Enemy newEnemy) {
		enemies.put(newEnemy.getName(), newEnemy);
	}

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

	public void setShop() { this.shop = new Shop(); }

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

	public Shop getShop() { return this.shop; }

	public String getName() { return this.name; }

	public String getDescription() { return this.description; }

	public String toString() {
		return this.getName() + " : " + this.getDescription()
				+ "\n"
				+ "Shop : " + this.isShop();
	}

	public HashMap<String, Enemy> getEnemy(){return enemies;} //warning mais on se fiche de l'ordre des ennemies

	public String getEnemiesList(){ return "The enemies on this map are : " + enemies.keySet(); }
}