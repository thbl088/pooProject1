package projet1_1.Characters;

import java.util.HashMap;
import projet1_1.Items.*;
import projet1_1.Locations.*;

public class Player extends Character {

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

	public void addAttackPotion() {

		this.attackPotion ++ ;

		throw new UnsupportedOperationException();
	}

	public void addCritPotion() {

		this.critPotion++ ;

		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newLoc
	 */
	public void Move(Map newLoc) {
		
		this.currentLocation = newLoc;

		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public Item getItem(String item) {

		return inventory.get(item);

		
	}

	public int useHealthPotion() {
		if (this.healthPotion > 0)
		{
			this.healthPotion = -1 ;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion." + "\n");
			return 0;
		}
		
	}

	public int useDefensePotion() {
		if (this.defensePotion > 0)
		{
			this.defensePotion = -1 ;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion." + "\n");
			return  0;
		}

	}

	public int useCritPotion() {

		if (this.critPotion > 0)
		{
			this.critPotion = -1 ;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion."+"\n");
			return  0;
		}


		throw new UnsupportedOperationException();
	}

	public int useAttackPotion() {

		if (this.attackPotion > 0)
		{
			this.attackPotion = -1 ;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion."+"\n");
			return  0;
		}


		throw new UnsupportedOperationException();
	}

	public void printInventory() {

		for (String i : inventory.keySet()) {
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

		inventory.put(item.getname(), item);

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

		inventory.remove(item.getname());

		throw new UnsupportedOperationException();
	}

}