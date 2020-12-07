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
	private static final int EXIT_SUCCESS = 0;
	private static final int EXIT_FAILURE = -1;

	public Player(String name){
		super(name, new StatisticsPlayer());
		this.armor = DEFAULT_ARMOR;
		this.weapon = DEFAULT_WEAPON;
	}

	public void addHealthPotion() { this.healthPotion ++; }

	public void addDefensePotion() { this.defensePotion ++; }

	public void addAttackPotion() { this.attackPotion ++; }

	public void addCritPotion() { this.critPotion++; }

	/**
	 * 
	 * @param newLoc
	 */
	public void move(Map newLoc) { this.currentLocation = newLoc; }

	public Map getMapHero() { return this.currentLocation; }

	/**
	 * 
	 * @param item
	 */
	public Item getItem(String item) { return inventory.get(item); }

	public String getNbPotion(){
		return "health potion : " + this.healthPotion
						+ "\ndefense potion : " + this.defensePotion
						+ "\nattack potion : " + this.attackPotion
						+ "\ncrit potion : " + this.critPotion;
	}

	public int useHealthPotion() {
		if (this.healthPotion > 0)
		{
			this.healthPotion -- ;
			this.getStatistics().addHealth(25);
			return EXIT_SUCCESS;
		}
		else
		{
			System.out.println("You don't have any health potion.");
			return EXIT_FAILURE;
			
		}
	}

	public int useDefensePotion() {
		if (this.defensePotion > 0)
		{
			this.defensePotion-- ;
			return EXIT_SUCCESS;
		}
		else
		{
			System.out.println("You don't have any defense potion.");
			return  EXIT_FAILURE;
		}
	}

	public int useCritPotion() {
		if (this.critPotion > 0)
		{
			this.critPotion-- ;
			return EXIT_SUCCESS;
		}
		else
		{
			System.out.println("You don't have any crit potion.");
			return  EXIT_FAILURE;
		}
	}

	public int useAttackPotion() {
		if (this.attackPotion > 0)
		{
			this.attackPotion-- ;
			return  EXIT_SUCCESS;
		}
		else
		{
			System.out.println("You don't have any attack potion.");
			return  EXIT_FAILURE;
		}
	}

	public void printInventory() {
		if (!(this.inventory == null)){
			for (String i : inventory.keySet()) {
				System.out.println(i);
			}
		}
		else { System.out.println("Inventory is empty."); }
	}

	public void removeWeapon() {
		if (this.weapon == DEFAULT_WEAPON)
		{
			System.out.println("You can't remove your default weapon.");
		}
		else
		{
			this.weapon = DEFAULT_WEAPON;
		}
	}

	public void removeArmor() {
		if (this.armor == DEFAULT_ARMOR)
		{
			System.out.println("You can't remove your default armor.");
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
	public void addEquipment(Item item) {
		if ( item instanceof Weapon )
		{
		equiWeapon(((Weapon)item));
		}
		else if ( item instanceof Armor ){

			equiArmor(((Armor)item));
		}
	}

	public void equiWeapon(Weapon item) { this.weapon = item; }

	public void equiArmor(Armor item) { this.armor = item; }

	public void showEquipement() { System.out.println("You are equipped with the current weapon : " + this.weapon.getName() + " and the current armor : " + this.armor.getName()); }

	/**
	 * 
	 * @param item
	 */
	public void removeInventory(Item item) { this.inventory.remove(item.getName()); }

	@Override
	public String toString() {
		return "player name : " + this.getName() + "\nhealth : " + this.getHealth() + "\nattack : " + this.getAttack() + "\ndefense : " + this.getDefense() + "\ncritical : " + this.getCrit() + "\n";
	}
}