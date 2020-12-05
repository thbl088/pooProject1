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
	private Armor armor ;
	private Weapon weapon;
	private Armor DEFAULT_ARMOR = new Armor("Combinaison spatiale", "Armure du début", 0, 3);
	private Weapon DEFAULT_WEAPON = new Weapon("Hache", "Hache du début", 0, 3);

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
	public void move(Map newLoc) {
		
		this.currentLocation = newLoc;

		throw new UnsupportedOperationException();
	}

	public Map getMapHero() {

		return this.currentLocation;

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
			this.healthPotion -- ;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion de soin.");
			return 0;
			
		}
		
	}

	public int useDefensePotion() {
		if (this.defensePotion > 0)
		{
			this.defensePotion -- ;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion de défense.");
			return  0;
		}

	}

	public int useCritPotion() {

		if (this.critPotion > 0)
		{
			this.critPotion -- ;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion de crit.");
			return  0;
		}


		//throw new UnsupportedOperationException();
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


		//throw new UnsupportedOperationException();
	}

	public void printInventory() {

		for (String i : inventory.keySet()) {
			System.out.println(i);
		  }

		throw new UnsupportedOperationException();
	}

	public void removeWeapon() {
		
		if (this.weapon == DEFAULT_WEAPON)
		{
			System.out.println("Vous ne pouvez pas enlever d'arme car vous en avez pas.");
		}
		else
		{
			this.weapon = DEFAULT_WEAPON;
		}
		throw new UnsupportedOperationException();
	}

	public void removeArmor() {
		
		if (this.armor == DEFAULT_ARMOR)
		{
			System.out.println("Vous ne pouvez pas enlever d'armure car vous en avez pas.");
		}
		else
		{
			this.armor = DEFAULT_ARMOR;
		}
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
	 *
	 * 
	*/
	public void addEquipment(Item item) {
	
		if ( item instanceof Weapon )
		{

		equiWeapon(((Weapon)item));

		}
		else if 
		throw new UnsupportedOperationException();
	}

	public void equiWeapon(Weapon item) {
		
		this.weapon = item;

		throw new UnsupportedOperationException();
	}

	public void equiArmor(Armor item) {
		
		this.armor = item;

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