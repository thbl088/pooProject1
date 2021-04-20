package Modeles;

import java.util.HashMap;

public class Player extends Character {
	private final HashMap<String, Item> INVENTORY;
	private int healthPotion = 0;
	private int attackPotion = 0;
	private int defensePotion = 0;
	private int critPotion = 0;
	private Map currentLocation ;
	private Armor armor ;
	private Weapon weapon;
	private final Armor DEFAULT_ARMOR = new Armor("Space suit", "This uniform represents our nation", -1, 0);
	private final Weapon DEFAULT_WEAPON = new Weapon("Ax", "It is used to break the windshield", -1, 0);
	private final int COEF_HP_POTION;
	private final int COEF_ATT_POTION;
	private final int COEF_DEF_POTION;
	private final int COEF_CRIT_POTION;
	private final int DEFAULT_ATTACK;
	private final int DEFAULT_DEFENSE;


	public Player(String name){
		super(name, new StatisticsPlayer());
		HashMap<String, Item> inv = new HashMap<>();
		this.armor = DEFAULT_ARMOR;
		this.weapon = DEFAULT_WEAPON;
		this.INVENTORY = inv;
		this.COEF_HP_POTION = 25;
		this.COEF_ATT_POTION = 2;
		this.COEF_DEF_POTION = 2;
		this.COEF_CRIT_POTION = 2;
		this.DEFAULT_ATTACK = this.stats.getAttack();
		this.DEFAULT_DEFENSE = this.stats.getDefense();
	}

	public void addHealthPotion() { this.healthPotion ++; }

	public void addDefensePotion() { this.defensePotion ++; }

	public void addAttackPotion() { this.attackPotion ++; }

	public void addCritPotion() { this.critPotion++; }

	public void move(Map newLoc) { this.currentLocation = newLoc; }

	public Map getMapHero() { return this.currentLocation; }

	public Item getItem(String item) { return this.INVENTORY.get(item); }

	public String getNbPotion(){
		return "health potion : " + this.healthPotion
						+ "\ndefense potion : " + this.defensePotion
						+ "\nattack potion : " + this.attackPotion
						+ "\ncrit potion : " + this.critPotion;
	}

	public void useHealthPotion() {
		if (this.healthPotion > 0)
		{
			this.healthPotion -- ;
			this.getStatistics().addHealth(COEF_HP_POTION);
		}
		else
		{
			System.out.println("You don't have any health potion.");
			
		}
	}
	
	public void useAttackPotion() {
			if (this.attackPotion > 0)
			{
				this.attackPotion-- ;
				this.getStatistics().changeAttack(this.getAttack() * COEF_ATT_POTION);
				System.out.println("new attack = " + this.getAttack());
			}
			else
			{
				System.out.println("You don't have any attack potion.");
			}
		}

	public void useDefensePotion() {
		if (this.defensePotion > 0)
		{
			this.defensePotion-- ;
			this.getStatistics().changeDefense(this.getDefense() * COEF_DEF_POTION);
			System.out.println("new Defense = " + this.getDefense());
		}
		else
		{
			System.out.println("You don't have any defense potion.");
		}
	}

	public void useCritPotion() {
		if (this.critPotion > 0)
		{
			
			this.critPotion-- ;
			this.getStatistics().changeCritical(this.getCrit() * COEF_CRIT_POTION);
			System.out.println("new Critic = " + this.getCrit());
		}
		else
		{
			System.out.println("You don't have any crit potion.");
		}
	}

	public void printInventory() {
		if (!this.INVENTORY.isEmpty()){
			
			for (String i : this.INVENTORY.keySet()) {
				System.out.println(i);
			}
		}
		else { System.out.println("Inventory is empty."); }
	}

	public HashMap<String, Item> getInventory() {
		return this.INVENTORY;
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


	public void addInventory(Item item) { this.INVENTORY.put(item.getName(), item); }


	public void addEquipment(Item item) {          // Permet d'équiper un objet retour avec un print si on peut pas
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


	public void removeInventory(Item item) { this.INVENTORY.remove(item.getName()); }

	public boolean hasItem(String item) {return this.INVENTORY.containsKey(item);}

	public void buyItem(String nameItem) {                                   //Permet d'acheter un item
		Shop shop = (Shop) this.currentLocation ;
		if (shop.getItem(nameItem)!= null ){
			Item item = shop.getItem(nameItem);
			if ( item.getPrice() < this.stats.getMoney() ){          // Vérifie si le joueur possède accés d'argent  puis on l'ajoute à dans l'inventaire et l iteme n'ai plus dans le shop

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
			if ( item.getPrice() <  0) {                                        // Vérifie si le prix de litem est supérieur à 0 car les items pour avancer dans l'histoire on un prix négatif
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
		switch (potionType) {
			case "health_potion" -> {
				this.stats.removeMoney(shop.getPotionCost());
				addHealthPotion();
			}
			case "attack_potion" -> {
				this.stats.removeMoney(shop.getPotionCost());
				addAttackPotion();
			}
			case "defense_potion" -> {
				this.stats.removeMoney(shop.getPotionCost());
				addDefensePotion();
			}
			case "crit_potion" -> {
				this.stats.removeMoney(shop.getPotionCost());
				addCritPotion();
			}
			default -> System.out.println("We don't have that kind of potion here.");
		}
	}

	@Override
	public String toString() {
		return "player name : " + this.getName() + "\nhealth : " + this.getHealth() + "\nattack : " + this.getAttack() + "\ndefense : " + this.getDefense() + "\ncritical : " + this.getCrit() + "\n";
	}

}