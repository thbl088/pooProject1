package Characters;

import java.util.HashMap;
import Items.*;
import Locations.*;
import Stats.*;

public class Player extends Character {

	private HashMap<String, Item> inventory;
	private int healthPotion = 0;
	private int attackPotion = 0;
	private int defensePotion = 0;
	private int critPotion = 0;
	private Map currentLocation ;
	private Armor armor ;
	private Weapon weapon;
	private final Armor DEFAULT_ARMOR = new Armor("Space suit", "This uniform represents our nation", -1, 0);
	private final Weapon DEFAULT_WEAPON = new Weapon("Ax", "It is used to break the windshield", -1, 0);
	private static final int EXIT_SUCCESS = 0;
	private static final int EXIT_FAILURE = -1;
	private final int COEF_HP_POTION = 25;
	private final int COEF_ATT_POTION = 2;
	private final int COEF_DEF_POTION = 2;
	private final int COEF_CRIT_POTION = 2;
	private final int DEFAULT_ATTACK;
	private final int DEFAULT_DEFENSE;


	public Player(String name){
		
		super(name, new StatisticsPlayer());
		HashMap<String, Item> inv = new HashMap<>();
		this.armor = DEFAULT_ARMOR;
		this.weapon = DEFAULT_WEAPON;
		this.inventory = inv;
		this.DEFAULT_ATTACK = this.stats.getAttack();
		this.DEFAULT_DEFENSE = this.stats.getDefense();
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
			this.getStatistics().addHealth(COEF_HP_POTION);
			return EXIT_SUCCESS;
		}
		else
		{
			System.out.println("You don't have any health potion.");
			return EXIT_FAILURE;
			
		}
	}
	
	public int useAttackPotion() {
			if (this.attackPotion > 0)
			{
				this.attackPotion-- ;
				this.getStatistics().changeAttack(this.getAttack() * COEF_ATT_POTION);
				System.out.println("new attack = " + this.getAttack());
				return  EXIT_SUCCESS;
			}
			else
			{
				System.out.println("You don't have any attack potion.");
				return  EXIT_FAILURE;
			}
		}

	public int useDefensePotion() {
		if (this.defensePotion > 0)
		{
			this.defensePotion-- ;
			this.getStatistics().changeDefense(this.getDefense() * COEF_DEF_POTION);
			System.out.println("new Defense = " + this.getDefense());

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
			this.getStatistics().changeCritical(this.getCrit() * COEF_CRIT_POTION);
			System.out.println("new Critic = " + this.getCrit());

			return EXIT_SUCCESS;
		}
		else
		{
			System.out.println("You don't have any crit potion.");
			return  EXIT_FAILURE;
		}
	}

	public void printInventory() {
		if (!this.inventory.isEmpty()){
			
			for (String i : inventory.keySet()) {
				System.out.println(i);
			}
		}
		else { System.out.println("Inventory is empty."); }
	}

	public void removeEquipment(Item item){
		if ( item instanceof Weapon && item != DEFAULT_WEAPON)
		{
			removeWeapon(((Weapon)item));
			
		}
		else if ( item instanceof Armor && item != DEFAULT_ARMOR){

			removeArmor(((Armor)item));
		}
		else{
			System.out.println(item.getName() + " isn't removable.");
		}		
		showEquipement();
	}

	public void removeWeapon(Weapon item) {  	// Permet d'enlever son arme on vérifie bien qui n'enlève pas celle de base     
		if (item == DEFAULT_WEAPON)
		{
			System.out.println("You can't remove your default weapon.");
		}
		else
		{
			this.stats.changeAttack(this.DEFAULT_ATTACK + DEFAULT_WEAPON.getAttackBonus());
			this.weapon = DEFAULT_WEAPON;
		}
	}

	public void removeArmor(Armor item) {              
		if (item == DEFAULT_ARMOR)
		{
			System.out.println("You can't remove your default armor.");
		}
		else
		{
			this.stats.removeDefense(this.DEFAULT_DEFENSE + DEFAULT_ARMOR.getDefenseBonus());
			this.armor = DEFAULT_ARMOR;
		}
	}

	/**
	 * 
	 * @param item
	 */
	public void addInventory(Item item) {

		this.inventory.put(item.getName(), item);

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
		else{
			System.out.println(item.getName() + "isn't equipable.");
		}
	}

	public void equiWeapon(Weapon item) {                 // On équipe la nouvelle arme

		if ( item != this.weapon){

			this.stats.removeAttack(this.weapon.getAttackBonus());  // On retire l'ancienne arme 
			this.stats.addAttack(item.getAttackBonus());
			this.weapon = item;
			showEquipement();

		}
		else{
			System.out.println("You have already this weapon equiped.");
		}
	}

	public void equiArmor(Armor item) {                 // On équipe la nouvelle défense

		if ( item != this.armor){

			this.stats.removeDefense(this.armor.getDefenseBonus());  // On retire les bonus de def  de l'ancienne arme 
			this.stats.addDefense(item.getDefenseBonus());
			this.armor = item;
			showEquipement();

		}
		else{
			System.out.println("You have already this armor equiped.");
		}	
	}


	public void showEquipement() { System.out.println("You are equipped with the current weapon : " + this.weapon.getName() + " and the current armor : " + this.armor.getName()); }

	/**
	 * 
	 * @param item
	 */
	public void removeInventory(Item item) { this.inventory.remove(item.getName()); }

	public boolean hasItem(String item) {
		return this.inventory.containsKey(item);
	}
	/*
		public void buyItem(String item) {
			if (((Shop) this.getMapHero()).hasItem(item)  && (this.stats.getMoney() >= ((Shop) this.getMapHero()).getItem(item).getPrice())) {
				this.addInventory(((Shop) this.getMapHero()).getItem(item));
				this.stats.removeMoney(((Shop) this.getMapHero()).getItem(item).getPrice());
				((Shop) this.getMapHero()).removeItem(item);
			}
			else { System.out.println("The shop doesn't sell this item"); }
		}
*/


	public void buyItem(String nameItem) {
		Shop shop = (Shop) this.currentLocation ;
		if (shop.getItem(nameItem)!= null ){
			Item item = shop.getItem(nameItem);
			if ( item.getPrice() < this.stats.getMoney() ){

					addInventory(item);
					this.stats.removeMoney(item.getPrice());
					shop.removeItem(nameItem);
			}
			else{
				System.out.println("Xavier [Marchand] :\"Need more money rogue!\" ");
			}
		}
		else { System.out.println("Xavier [Marchand] :\"The shop doesn't sell this item.\""); }
	}


	public void sellItem(String nameItem) {
		if (this.hasItem(nameItem)) {
			Item item = getItem(nameItem);
			if ( item.getPrice() <  0) {
				System.out.println("Xavier [Marchand] :\"This item is so important.\"");
			}
			else{
				if( item == this.weapon || item == this.armor ){

					removeEquipment(item);
				}
				this.stats.addMoney(item.getPrice() / 2);
				removeInventory(item);
				System.out.println("Xavier [Marchand] :\"Thanks for your patronage.\"" );

			}
		}
		else { System.out.println("Xavier [Marchand] :\"You don't have this item.\"" ); }
	}

	public void buyPotion(String potionType){
		Shop shop = (Shop) this.currentLocation ;
		switch (potionType){
			case "health_potion" : 
				this.stats.removeMoney(shop.getPotionCost());
				addHealthPotion();
				break;
			case "attack__potion" : 
				this.stats.removeMoney(shop.getPotionCost());
				addAttackPotion();
				break;
			case "defense_potion" : 
				this.stats.removeMoney(shop.getPotionCost());
				addDefensePotion();
				break;
			case "crit_potion" : 
				this.stats.removeMoney(shop.getPotionCost());
				addCritPotion();
				break;
			default : System.out.println("We don't have that kind of potion here.");
				break;
		}
	}

	@Override
	public String toString() {
		return "player name : " + this.getName() + "\nhealth : " + this.getHealth() + "\nattack : " + this.getAttack() + "\ndefense : " + this.getDefense() + "\ncritical : " + this.getCrit() + "\n";
	}

	public int finish(){

		if( this.getMapHero().getName().equals("Ship") && this.weapon.getName().equals("Reactor"))
		{
			return 1;
		}

		return 0;

	}
}