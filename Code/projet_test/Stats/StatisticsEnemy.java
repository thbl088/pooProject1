package Stats;

public class StatisticsEnemy extends Statistics {

	private int MAX_HEALTH = 100;
	private int MAX_DEFENSE = 100;
	private int MAX_ATTACK = 100;
	private int MAX_CRITICAL = 100;


	public StatisticsEnemy(){

		this.health = MAX_HEALTH;
		this.defense = MAX_DEFENSE;
		this.attack = MAX_ATTACK;
		this.critical = MAX_CRITICAL;
	}

	public StatisticsEnemy (int maxhp, int def, int att, int crit){
		
		this.MAX_HEALTH = maxhp;
		this.MAX_DEFENSE = def ;
		this.MAX_ATTACK = att ;
		this.MAX_CRITICAL = crit ;
	}
}