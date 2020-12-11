package Items;

public class Armor extends Item {
	private final int DEFENSE_BONUS;

	public Armor(String name, String description , int price , int defense){
		super(name, description , price);
		this.DEFENSE_BONUS = defense;
	}

	public int getDefenseBonus() { return this.DEFENSE_BONUS; }

	// public void printDefenseBonus() { System.out.println(this.DEFENSE_BONUS); }
}