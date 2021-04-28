package Modeles;

public class Weapon extends Item {
	private final int ATTACK_BONUS;
        
	public Weapon(String name, String description , int price , int attack, int x, int y) {
		super(name, description , price, x, y);
		this.ATTACK_BONUS = attack;
	}

	public Weapon(String name, String description , int price , int attack) {
		super(name, description , price);
		this.ATTACK_BONUS = attack;
	}

	public int getAttackBonus() { return this.ATTACK_BONUS; }

	// public void printAttackBonus() { System.out.println(this.ATTACK_BONUS); }
}