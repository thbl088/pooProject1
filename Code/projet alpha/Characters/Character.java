package Characters;

public abstract class Character {

	private String Name;
	private Statistics Stats;        // tableau de int  {MH , H , Att , Def, Crit}

	/**
	 * 
	 * @param String
	 */
	protected Character(String name) {
		// TODO - implement Character.Character
		this.Name = name;
		throw new UnsupportedOperationException();
	}

	public int getMaxHealth() {
		// TODO - implement Character.getMaxHealth

		return this.Stats.getMaxHealth();

		throw new UnsupportedOperationException();
	}

	public int getHealth() {
		// TODO - implement Character.getHealth

		return this.Stats.getHealth();
		throw new UnsupportedOperationException();
	}

	public int getAttack() {
		// TODO - implement Character.getAttack

		return this.Stats.getAttack();

		throw new UnsupportedOperationException();
	}

	public int getDefense() {
		// TODO - implement Character.getDefense

		return this.Stats.getDefense();

		throw new UnsupportedOperationException();
	}


	public int getCrit() {
		// TODO - implement Character.getCrit

		return this.Stats.getCrit();

		throw new UnsupportedOperationException();
	}

}