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
	private final Armor DEFAULT_ARMOR = new Armor("space suit", "This uniform represents our nation", -1, 5);
	private final Weapon DEFAULT_WEAPON = new Weapon("axe", "It is used to break the windshield", -1, 10);
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


	public void useHealthPotion() {
            this.healthPotion -- ;
            this.getStatistics().addHealth(COEF_HP_POTION);
	}
	
	public void useAttackPotion() {
            this.attackPotion-- ;
            this.getStatistics().changeAttack(this.getAttack() * COEF_ATT_POTION);
        }

	public void useDefensePotion() {
            this.defensePotion-- ;
	    this.getStatistics().changeDefense(this.getDefense() * COEF_DEF_POTION);
	}

	public void useCritPotion() {
            this.critPotion-- ;
            this.getStatistics().changeCritical(this.getCrit() * COEF_CRIT_POTION);
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
	}

	public void removeWeapon(Weapon item) {  	// Permet d'enlever son arme 

            int attaque_base = this.stats.getAttack() - item.getAttackBonus();            //On récupère l'attaque de base pour récuper son bonus (potion) si il en a un
            this.stats.changeAttack(attaque_base + DEFAULT_WEAPON.getAttackBonus());
            this.weapon = DEFAULT_WEAPON;
	}

	public void removeArmor(Armor item) {
            
            int def_base = this.stats.getDefense()- item.getDefenseBonus();             
            this.stats.changeDefense(def_base + DEFAULT_ARMOR.getDefenseBonus());
            this.armor = DEFAULT_ARMOR;
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
	}

	public void equiWeapon(Weapon item) {                 // On équipe la nouvelle arme
            this.stats.removeAttack(this.weapon.getAttackBonus());  // On retire l'ancienne arme 
	    this.stats.addAttack(item.getAttackBonus());
            this.weapon = item;
	}

	public void equiArmor(Armor item) {                 // On équipe la nouvelle défense
            this.stats.removeDefense(this.armor.getDefenseBonus());  // On retire les bonus de def  de l'ancienne arme 
            this.stats.addDefense(item.getDefenseBonus());
            this.armor = item;	
	}

	public Armor getArmor() {
		return this.armor;
	}

	public Weapon getWeapon() {
		return this.weapon;
	}

	public void removeInventory(Item item) { this.INVENTORY.remove(item.getName()); }

	public boolean hasItem(String item) {return this.INVENTORY.containsKey(item);}
        
        public void removeBonusPotion(){  //On remet le joueur sans potion
            stats.changeAttack(getWeapon().getAttackBonus());
            stats.changeDefense(getArmor().getDefenseBonus());
            stats.changeCritical(5);
        }

	public int getHealthPotion(){
		return this.healthPotion;
	}

	public int getAttackPotion(){
		return this.attackPotion;
	}

	public int getDefensePotion(){
		return this.defensePotion;
	}

	public int getCritPotion(){
		return this.critPotion;
	}


}
