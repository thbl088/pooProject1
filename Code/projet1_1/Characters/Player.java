package Characters;

import java.util.HashMap;
import Items.*;
import Locations.*;

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

	}

	public void addDefensePotion() {

		this.defensePotion ++ ;


	}

	public void addAttackPotion() {

		this.attackPotion ++ ;

	
	}

	public void addCritPotion() {

		this.critPotion++ ;


	}

	/**
	 * 
	 * @param newLoc
	 */
	public void move(Map newLoc) {
		
		this.currentLocation = newLoc;

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


	}

	public void printInventory() {

		for (String i : inventory.keySet()) {
			System.out.println(i);
		  }

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

	}

	/**
	 * 
	 * @param item
	 */
	public void addInventory(Item item) {

		inventory.put(item.getName(), item);

	}

	/**
	 * 
	 * @param item
	 *
	 * 
	*/
	/*public void addEquipment(Item item) {
	
		if ( item instanceof Weapon )
		{

		equiWeapon(((Weapon)item));

		}
<<<<<<< Updated upstream
		else if 
		throw new UnsupportedOperationException();
	}*/
=======
		else if ( item instanceof Armor ){

			equiArmor(((Armor)item));

		}

	
	}
>>>>>>> Stashed changes

	public void equiWeapon(Weapon item) {
		
		this.weapon = item;


	}

	public void equiArmor(Armor item) {
		
		this.armor = item;

	}

	public void showEquipement(){

		System.out.println("Vous êtes équipé de l'arme suivante :" + this.weapon + "de l'amurmue suivante :" + this.armor );
	}

	/**
	 * 
	 * @param item
	 */
	public void removeInventory(Item item) {

		inventory.remove(item.getName());

	}

}