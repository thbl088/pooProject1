package Characters;
import Stats.Statistics;

public abstract class Character {

	private String name;
	private Statistics stats;


	/**
	 * 
	 * @param String
	 */
	protected Character(String name) {

		this.name = name;
		throw new UnsupportedOperationException();
	}

	public int getMaxHealth() {
		// TODO - implement Character.getMaxHealth

		return this.stats.getMaxHealth();
		throw new UnsupportedOperationException();
	}

	public int getHealth() {
		// TODO - implement Character.getHealth

		return this.stats.getHealth();
		throw new UnsupportedOperationException();
	}

	public int getAttack() {
		// TODO - implement Character.getAttack

		return this.stats.getAttack();
		throw new UnsupportedOperationException();
	}

	public int getDefense() {
		// TODO - implement Character.getDefense

		return this.stats.getDefense();
		throw new UnsupportedOperationException();
	}

	public int getCrit() {
		// TODO - implement Character.getCrit

		return this.stats.getCrit();
		throw new UnsupportedOperationException();
	}

}