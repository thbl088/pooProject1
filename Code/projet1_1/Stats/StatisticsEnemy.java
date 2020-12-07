package Stats;

public class StatisticsEnemy extends Statistics {
	private final int MAX_HEALTH;
	private final int DEFAULT_HEALTH = 100;
	private final int DEFAULT_DEFENSE = 100;
	private final int DEFAULT_ATTACK = 100;
	private final int DEFAULT_CRITICAL = 100;
	private final int DEFAULT_MONEY = 100;

	public StatisticsEnemy() {
		this.MAX_HEALTH = DEFAULT_HEALTH;
		this.health = DEFAULT_HEALTH;
		this.defense = DEFAULT_DEFENSE;
		this.attack = DEFAULT_ATTACK;
		this.critical = DEFAULT_CRITICAL;
		this.money = DEFAULT_MONEY;
	}

	public StatisticsEnemy(int hp, int def, int att, int crit, int money) {
		this.MAX_HEALTH = hp;
		this.health = hp;
		this.defense = def;
		this.attack = att;
		this.critical = crit;
		this.money = money;
	}
}