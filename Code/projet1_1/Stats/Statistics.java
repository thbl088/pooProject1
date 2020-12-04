package projet1_1.Stats;

public abstract class Statistics {

	private int maxhealth;
	private int health;
	private int defense;
	private int attack;
	private int critical;
	private int money;

	public int getMaxHealth() {
		return this.maxhealth;
	}

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
		
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param def
	 */
	public void addDefense(int def) {
		
		this.defense += def;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param atk
	 */
	public void addAttack(int atk) {

		this.attack += atk;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param crit
	 */
	public void addCritical(int crit) {

		this.critical += crit;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param coins
	 */
	public void addMoney(int coins) {

		this.money += coins;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param hp
	 */
	public void removeHealth(int hp) {
		// TODO - implement Statistics.removeHealth
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param def
	 */
	public void removeDefense(int def) {

		this.defense -= def;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param crit
	 */
	public void removeCritical(int crit) {
		
		this.critical -= crit;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param att
	 */
	public void removeAttack(int att) {
		
		this.attack -= att;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param coins
	 */
	public void removeMoney(int coins) {
		
		this.money -= coins;
		throw new UnsupportedOperationException();
	}

}