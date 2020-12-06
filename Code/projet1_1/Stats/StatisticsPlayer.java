package Stats;

public class StatisticsPlayer extends Statistics {
	
	private int DEFAULT_MAXHEALTH;
	private int DEFAULT_HEALTH = 100;
	private int DEFAULT_DEFENSE = 100;
	private int DEFAULT_ATTACK = 100;
	private int DEFAULT_CRITICAL = 100;

	public StatisticsPlayer (int maxhp, int def, int att, int crit){

		this.DEFAULT_MAXHEALTH = maxhp;
		this.DEFAULT_HEALTH = maxhp;
		this.DEFAULT_DEFENSE = def ;
		this.DEFAULT_ATTACK = att ;
		this.DEFAULT_CRITICAL = crit ;
	}
}