package Stats;

public class StatisticsPlayer extends Statistics {
	private final int DEFAULT_HEALTH = 5;
	private final int DEFAULT_DEFENSE = 5;
	private final int DEFAULT_ATTACK = 5;
	private final int DEFAULT_CRITICAL = 5;
	private final int DEFAULT_MONEY = 0;

	public StatisticsPlayer(){
		this.maxhealth = DEFAULT_HEALTH;
		this.health = DEFAULT_HEALTH;
		this.defense = DEFAULT_DEFENSE;
		this.attack = DEFAULT_ATTACK;
		this.critical = DEFAULT_CRITICAL;
		this.money = DEFAULT_MONEY;
	}

	public StatisticsPlayer (int hp, int def, int att, int crit, int money){
		this.maxhealth = hp;
		this.health = hp;
		this.defense = def;
		this.attack = att;
		this.critical = crit;
		this.money = money;
	}
}