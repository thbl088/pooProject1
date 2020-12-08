package Items;

public class Weapon extends Item {
	private int attackBonus;

	public Weapon(String name, String description , int price , int attack) {
		super(name, description , price);
		this.attackBonus = attack;
	}

	public int getAttackBonus() { return this.attackBonus; }

	public void printAttackBonus() { System.out.println(this.attackBonus); }
}