package spaceandpens.Modeles;





public abstract class Character {
	protected String name;
	protected Statistics stats;

	public Character(String name, Statistics stats) {
		this.name = name;
		this.stats = stats;
	}

	public Character(){}

	public String getName(){ return this.name; }

	// public void printName(){ System.out.println(this.name); }

	// public int getMaxHealth() { return this.stats.getMaxHealth(); }

	public int getHealth() { return this.stats.getHealth(); }

	public int getAttack() { return this.stats.getAttack(); }

	public int getDefense() { return this.stats.getDefense(); }

	public int getCrit() { return this.stats.getCritical(); }

	public Statistics getStatistics(){return this.stats;}
}