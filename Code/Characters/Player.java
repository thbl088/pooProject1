package Characters;

import Locations.*;

public class Player {

	private HashMap<String, Item> Inventory;
	private int HealthPotion;
	private int ForcePotion;
	private int DefensePotion;
	private int CritPotion;
	private Map CurrentLocation;
	private int Money;
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

	/**
	 * 
	 * @param item
	 */
	public void addInventory(Item item) {
		// TODO - implement Player.addInventory
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
		throw new UnsupportedOperationException();
	}

	public void addDefensePotion() {
		// TODO - implement Player.addDefensePotion
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param coins
	 */
	public void addMoney(int coins) {
		// TODO - implement Player.addMoney
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
	 * @param item
	 */
	public void removeInventory(Item item) {
		// TODO - implement Player.removeInventory
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
		throw new UnsupportedOperationException();
	}

	public void endFight() {
		// TODO - implement Player.endFight
		throw new UnsupportedOperationException();
	}

	public void useHealthPotion() {
		// TODO - implement Player.useHealthPotion
		throw new UnsupportedOperationException();
	}

	public void useDefensePotion() {
		// TODO - implement Player.useDefensePotion
		throw new UnsupportedOperationException();
	}

	public void useCritPotion() {
		// TODO - implement Player.useCritPotion
		throw new UnsupportedOperationException();
	}

	public void printInventory() {
		// TODO - implement Player.printInventory
		throw new UnsupportedOperationException();
	}

	public int getMoney() {
		// TODO - implement Player.getMoney
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