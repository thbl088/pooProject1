package Items;

public class Weapon extends Item {

	private int attackBonus;


	public Weapon(int attack){

		this.attackBonus = attack;
	}

	public int getattack(){

		return this.attackBonus ;
	}
}