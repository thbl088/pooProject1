package Characters;
package Items;
import java.util.HashMap;
import Items.*;
import Locations.*;
import Item.*;

public class Player extends Characters {

	private HashMap<String, Item> inventory;
	private int healthPotion = 0;
	private int attackPotion = 0;
	private int defensePotion = 0;
	private int critPotion = 0;
	private Map currentLocation ;
	private Item armor ;
	private Item weapon;

	public Player(String name){
		super(name);
	}

	public void addHealthPotion() {

		this.healthPotion ++;
		throw new UnsupportedOperationException();
	}

	public void addDefensePotion() {

		this.defensePotion ++ ;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newLoc
	 */
	public void Move(Map newLoc) {
		// TODO - implement Player.Move
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public Item getItem(String item) {

		return inventory.get(item);

		throw new UnsupportedOperationException();
	}

	public int useHealthPotion() {
		if (this.healthPotion > 0)
		{
			this.healthPotion = -1 ;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion");
			return 0;
		}
		throw new UnsupportedOperationException();
	}

	public int useDefensePotion() {
		if (this.defensePotion > 0)
		{
			this.defensePotion = -1 ;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion");
			return  0;
		}

		throw new UnsupportedOperationException();
	}

	public int useCritPotion() {

		if (this.critPotion > 0)
		{
			this.critPotion = -1 ;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion");
			return  0;
		}


		throw new UnsupportedOperationException();
	}

	public void printInventory() {
		// TODO - implement Player.printInventory

		for (String i : Inventory.keySet()) {
			System.out.println(i);
		  }

		throw new UnsupportedOperationException();
	}

	public void removeWeapon() {
		// TODO - implement Player.removeWeapon
		throw new UnsupportedOperationException();
	}

	public void removeArmor() {
		// TODO - implement Player.removeArmor
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void addInventory(Item item) {
		// TODO - implement Player.addInventory

		Inventory.put(Item.getName(), item);

		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void addEquipment(Item item) {
		// TODO - implement Player.addEquipment
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void removeInventory(Item item) {
		// TODO - implement Player.removeInventory

		Inventory.remove(Item.getName());

		throw new UnsupportedOperationException();
	}

}