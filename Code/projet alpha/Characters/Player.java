package Characters;
import java.util.HashMap;
import Locations.*;

public class Player extends Character{

	private HashMap<String, Item> Inventory;
	private int HealthPotion;
	private int ForcePotion;
	private int DefensePotion;
	private int CritPotion;
	private Map currentLocation;
	private int money;
	private Item[] Equipment;
	private boolean isFighting;
	private boolean usedForcePotion;
	private boolean usedDefensePotion;
	private boolean usedCritPotion;
	private HashMap<String, Action> PlayerChoices;

	public Player() {
		// TODO - implement Player.Player
		throw new UnsupportedOperationException();
	}
	public Player(String name){
		super(name);
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
	public void removeInventory(Item item) {
		// TODO - implement Player.removeInventory

		Inventory.remove(Item.getName());

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

	public void addHealthPotion() {
		// TODO - implement Player.addHealthPotion
		this.HealthPotion ++;

		throw new UnsupportedOperationException();
	}

	public void addDefensePotion() {
		// TODO - implement Player.addDefensePotion
		this.DefensePotion ++ ;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param coins
	 */
	public void addMoney(int coins) {
		// TODO - implement Player.addMoney
		assert coins > 0 : "la money ajouté est négatif";
		this.Money = +coins;
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
	public Item getItem(string item) {
		// TODO - implement Player.getItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pos
	 */
	public void removeEquipment(int pos) {
		// TODO - implement Player.removeEquipment
		throw new UnsupportedOperationException();
	}

	public void startFight() {
		// TODO - implement Player.startFight

		this.isFighting = true;
		throw new UnsupportedOperationException();
	}

	public void endFight() {
		// TODO - implement Player.endFight

		this.isFighting = false;
		throw new UnsupportedOperationException();
	}

	public int useHealthPotion() {         // 1 a pu utiliser une potion  ; -1 il n'a pas pu 
		// TODO - implement Player.useHealthPotion

		if (this.HealthPotion > 0)
		{
			this.HealthPotion = -1 ;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion");
			return -1;
		}
		
		throw new UnsupportedOperationException();
	}

	public int useDefensePotion() {			// 1 a pu utiliser une potion  ; -1 il n'a pas pu 		
		// TODO - implement Player.useDefensePotion
		if (this.DefensePotion > 0)
		{
			this.DefensePotion = -1 ;
			this.usedDefensePotion = true;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion");
			return  -1;
		}

		throw new UnsupportedOperationException();
	}

	public int useCritPotion() {         // 1 a pu utiliser une potion  ; -1 il n'a pas pu 
		// TODO - implement Player.useCritPotion

		if (this.CritPotion > 0)
		{
			this.CritPotion = -1 ;
			this.usedCritPotion = true;
			return  1;
		}
		else
		{
			System.out.println("vous ne posséder pas de potion");
			return  -1;
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

	public int getMoney() {
		// TODO - implement Player.getMoney

		return this.money;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param action
	 */
	public void setAction(Action action) {
		// TODO - implement Player.setAction
		throw new UnsupportedOperationException();
	}

	public string getMapActions() {
		// TODO - implement Player.getMapActions
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param action
	 */
	public void doAction(string action) {
		// TODO - implement Player.doAction
		throw new UnsupportedOperationException();
	}

}