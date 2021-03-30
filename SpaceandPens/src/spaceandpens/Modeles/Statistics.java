package spaceandpens.Modeles;

public abstract class Statistics {

	protected int maxhealth;
	protected int health;
	protected int defense;
	protected int attack;
	protected int critical;
	protected int money;

	public int getMaxHealth() { return this.maxhealth; }

	public int getHealth() {
		return this.health;
	}

	public int getDefense() {
		return this.defense;
	}

	public int getAttack() {
		return this.attack;
	}

	public int getCritical() {
		return this.critical;
	}

	public int getMoney() {
		return this.money;
	}

	/**
	 * 
	 * @param hp
	 */
	public void addHealth(int hp) {
		
		if( this.health == this.maxhealth)
		{

		}
		else
		{
			this.health += hp ;

			if (this.health >= this.maxhealth)
			{
				this.health = this.maxhealth;
			}
		}
		
	}

	/**
	 * 
	 * @param def
	 */
	public void addDefense(int def) {
		
		this.defense += def;
	}

	/**
	 * 
	 * @param atk
	 */
	public void addAttack(int atk) {

		this.attack += atk;
	}

	/**
	 * 
	 * @param crit
	 */
	public void addCritical(int crit) {

		this.critical += crit;
	}

	/**
	 * 
	 * @param coins
	 */
	public void addMoney(int coins) {

		this.money += coins;
	}

	/**
	 * 
	 * @param hp
	 */
	public void removeHealth(int hp) {
		
		this.health -= hp;

	}

	public void changeHealth(int hp){
		this.health = hp;
	}

	/**
	 * 
	 * @param def
	 */
	public void removeDefense(int def) {

		this.defense -= def;
	}
	public void changeDefense(int def){
		this.defense = def;
	}

	/**
	 * 
	 * @param crit
	 */
	public void removeCritical(int crit) {
		
		this.critical -= crit;
	}
	public void changeCritical(int crit){
		this.critical = crit;
	}

	/**
	 * 
	 * @param att
	 */
	public void removeAttack(int att) {
		
		this.attack -= att ;
	}
	public void changeAttack(int att){
		this.attack = att;
	}

	/**
	 * 
	 * @param coins
	 */
	public void removeMoney(int coins) {
		
		this.money -= coins;
	}
}