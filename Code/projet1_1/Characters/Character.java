package projet1_1.Characters;

import projet1_1.Stats.Statistics;


public abstract class Character {

	private String name;
	private Statistics stats;


	/**
	 * 
	 * @param String
	 */
	protected Character(String name){
		this.name = name ;
	}

	protected Character(String name, Statistics stats) {

		this.name = name;
		this.stats = stats;
		throw new UnsupportedOperationException();
	}

	public String getName(){

		return this.name;
	}

	public void printName(){

		System.out.println(this.name);
		
	}

	public int getMaxHealth() {
		

		return this.stats.getMaxHealth();
	
	}

	public int getHealth() {
		

		return this.stats.getHealth();
		
	}

	public int getAttack() {
		

		return this.stats.getAttack();
		
	}

	public int getDefense() {
		

		return this.stats.getDefense();
		
	}

	public int getCrit() {

		return this.stats.getCritical();
		
	}

}