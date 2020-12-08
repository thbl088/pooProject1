import Characters.*;
import Items.Weapon;
import Stats.StatisticsEnemy;

public class Fight {
	private boolean usedAttackPotion;
	private boolean usedDefensePotion;
	private boolean usedCritPotion;
	private Player player;
	private Enemy enemy;

	private int enemyHP = enemy.getHealth();
	private int playerHP = player.getHealth();
	private int playerDef = player.getDefense();
	private boolean hasDefend = false;


	private int damage;

	public int stillFighting(){
		if (playerHP<=0){
			return 1;
		}
		if(enemyHP<=0){		
			usedAttackPotion = false;
			usedDefensePotion = false;
			usedCritPotion = false;
			return 2;
		}
		return 0;
	}

	public void playerAttack() {
		System.out.println("You are attacking " + enemy.getName());
		damage = player.getAttack()-enemy.getDefense();
		if (damage>0){
			enemyHP -= damage;
			System.out.println("You inflicted " + damage +" dmg. "+ enemy.getName() +" has " + enemyHP + " HP left.");
		}
		else{
			playerHP -= damage;
			System.out.println("You inflict yourself" + damage +"dmg. You have " + playerHP + "HP left.");
		}
	}

	public void enemyAttack() {
		System.out.println(enemy.getName() + " is attacking.");
		damage = enemy.getAttack()-player.getDefense();
		if (damage>0){
			playerHP -= damage;
			System.out.println("The enemy has inflicted " + damage +" dmg, you have " + playerHP + " HP remaining.");
		}
		else{
			enemyHP -= damage;
			System.out.println("You have inflicted " + damage +" dmg. "+ enemy.getName() +" has " + enemyHP + " HP.");
		}
		hasDefend = false;
	}

	public void defend() {
		playerDef *= 2;
		System.out.println("You get ready for the next attack.");
		hasDefend = true;
	}

	public String getEnemyName(){return enemy.getName();}
}