package Stats;

public class StatisticsPlayer extends Statistics {
	private final int DEFAULT_HEALTH = 20;
	private final int DEFAULT_ATTACK = 10;
	private final int DEFAULT_DEFENSE = 5;
	private final int DEFAULT_CRITICAL = 5;
	private final int DEFAULT_MONEY = 0;

	public StatisticsPlayer(){
		this.maxhealth = DEFAULT_HEALTH ;
		this.health = DEFAULT_HEALTH;
		this.attack = DEFAULT_ATTACK;
		this.defense = DEFAULT_DEFENSE;
		this.critical = DEFAULT_CRITICAL;
		this.money = DEFAULT_MONEY;
	}

	public StatisticsPlayer (int hp, int def, int att, int crit, int money){
		this.maxhealth = hp;
		this.health = hp;
		this.attack = att;
		this.defense = def;
		this.critical = crit;
		this.money = money;
	}
}