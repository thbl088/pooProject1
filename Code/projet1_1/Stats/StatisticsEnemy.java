package Stats;

public class StatisticsEnemy extends Statistics {
	
	private final int DEFAULT_HEALTH = 100;
	private final int DEFAULT_DEFENSE = 50;
	private final int DEFAULT_ATTACK = 10;
	private final int DEFAULT_CRITICAL = 5;
	private final int DEFAULT_MONEY = 5;

	public StatisticsEnemy() {
		this.maxhealth = DEFAULT_HEALTH;
		this.health = DEFAULT_HEALTH;
		this.defense = DEFAULT_DEFENSE;
		this.attack = DEFAULT_ATTACK;
		this.critical = DEFAULT_CRITICAL;
		this.money = DEFAULT_MONEY;
	}

	public StatisticsEnemy(int hp, int att, int def,int money) {
		this.maxhealth = hp;
		this.health = hp;
		this.defense = def;
		this.attack = att;
		this.critical = DEFAULT_CRITICAL;
		this.money = money;
	}

	public StatisticsEnemy(int hp, int att, int def, int crit, int money) {
		this.maxhealth = hp;
		this.health = hp;
		this.defense = def;
		this.attack = att;
		this.critical = crit;
		this.money = money;
	}
}