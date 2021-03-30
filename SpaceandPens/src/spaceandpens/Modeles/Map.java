package spaceandpens.Modeles;
import java.util.HashMap;


public class Map {

	private String name;
	private final HashMap<String, Enemy> ENEMIES;
	private final HashMap<String, Item> GROUND_ITEMS;
	private final HashMap<String, Npc> NPCS;
	private Door north;
	private Door east;
	private Door west;
	private Door south;
	private Door shop;
	private String description;

	public Map(){
		this.ENEMIES = new HashMap<>();
		this.GROUND_ITEMS = new HashMap<>();
		this.NPCS = new HashMap<>();
	}

	public Map(String newName){
		this.name = newName;
		this.ENEMIES = new HashMap<>();
		this.GROUND_ITEMS = new HashMap<>();
		this.NPCS = new HashMap<>();
	}

	public void changeName(String name){ this.name = name; }

	public void addEnemy(Enemy newEnemy) {
		this.ENEMIES.put(newEnemy.getName(), newEnemy);
	}

	public void addItem(Item newItem) { this.GROUND_ITEMS.put(newItem.getName(), newItem); }

	public void addNpc(Npc newNPC) { this.NPCS.put(newNPC.getName(), newNPC); }

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

	public HashMap<String, Enemy> getEnemies(){return this.ENEMIES;} //warning mais on se fiche de l'ordre des ennemies

	public Item getItem(String item) {
		Item itemReturn = this.GROUND_ITEMS.get(item);
		this.GROUND_ITEMS.remove(item);
		return itemReturn;
	}
	// public boolean isNpc(String Npc) { return this.NPCS.containsKey(Npc); }

	public Npc getNpc(String Npc) {
		return this.NPCS.get(Npc);
	}

	public String getEnemiesList() {
		if (this.ENEMIES.isEmpty()) {
			return "there are no enemies here";
		}
		else if (this.ENEMIES.size() == 1){
			return "There is " + this.ENEMIES.size() + " enemy on this map : " + this.ENEMIES.keySet();
		}
		else {
			return "There are " + this.ENEMIES.size() + " enemies on this map : " + this.ENEMIES.keySet();
		}
	}

	public String getGroundItemsList() {
		if (this.GROUND_ITEMS.isEmpty()) {
			return "there are no items here";
		}
		else if (this.GROUND_ITEMS.size() == 1){
			return "There is " + this.GROUND_ITEMS.size() + " item on this map : " + this.GROUND_ITEMS.keySet();
		}
		else {
			return "There are " + this.GROUND_ITEMS.size() + " items on this map : " + this.GROUND_ITEMS.keySet();
		}
	}

	public String getNpcsList() {
		if (this.NPCS.isEmpty()) {
			return "there are no NPCs here";
		}
		else if (this.NPCS.size() == 1){
			return "There is " + this.NPCS.size() + " NPC on this map : " + this.NPCS.keySet();
		}
		else {
			return "There are " + this.NPCS.size() + " NPCs on this map : " + this.NPCS.keySet();
		}
	}

	public String toString() {
		return this.getName() + " : " + this.getDescription()
				+ "\n"
				+ "Shop : " + this.isShop();
	}
}
