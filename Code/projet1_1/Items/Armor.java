package Items;

public class Armor extends Item {

	private int defenseBonus;


	public Armor(String name, String description , int price , int defense){
		super(name, description , price);
		this.defenseBonus = defense;
	}

	public int getDefenseBonus(){

		return this.defenseBonus;
	}

	public void printDefenseBonus(){

		System.out.println(this.defenseBonus);
	}
	
}