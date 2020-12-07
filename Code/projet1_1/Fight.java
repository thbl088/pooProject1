import Characters.*;
import java.util.HashMap;

public class Fight {
	private Player player;
	private Enemy enemy;
	private HashMap<String, Enemy> enemies = new HashMap<String, Enemy>();
	private boolean usedAttackPotion;
	private boolean usedDefensePotion;
	private boolean usedCritPotion;

	private int damage;
	private boolean hasDefend = false;
	private int playerDef = player.getDefense();

	public void instantiateFight(Player player){
		player = this.player;
		enemies = this.player.getMapHero().getEnemy() ;
	}
	

	public int stillFighting(){
		if (player.getHealth()<1){
			return 1;
		}
		if(enemies.size()==0){		
			return 2;
		}
		return 0;
	}

	public void playerAttack(String targetName) {
		
		hasDefend = false;
		System.out.println("You are attacking " + enemies.get(targetName).getName());
		damage = player.getAttack()-enemies.get(targetName).getDefense();
		if (damage>0){
			enemies.get(targetName).getStatistics().removeHealth(damage);
			System.out.println("You inflicted " + damage +" dmg. " + enemies.get(targetName).getName() +" has " + enemies.get(targetName).getHealth() + " HP left.\n");
			if(enemies.get(targetName).getHealth()<1){
				player.getStatistics().addMoney(enemies.get(targetName).getStatistics().getMoney());
				System.out.println("You killed " + enemies.get(targetName).getName());
				enemies.remove(targetName);
			}
		}
		else{
			player.getStatistics().removeHealth(damage);
			System.out.println("You inflict yourself" + damage +"dmg. You have " + player.getHealth() + "HP left.\n");
		}
	}

	public void enemyAttack() {
		for (String i : enemies.keySet()) {
			System.out.println(enemies.get(i).getName() + " is attacking.\n");
			damage = enemies.get(i).getAttack()-playerDef;
			if (damage>0){
				player.getStatistics().removeHealth(damage);
				System.out.println(enemies.get(i).getName() + " has inflicted " + damage +" dmg, you have " + player.getHealth() + " HP remaining.\n");
			}
			else{
				enemies.get(i).getStatistics().removeHealth(damage);
				System.out.println("You have inflicted " + damage +" dmg. "+ enemies.get(i).getName() +" has " + enemies.get(i).getHealth() + " HP.\n");
			}
		}
	}

	public void defend() {
	if(hasDefend){
		System.out.println("You keep your defend. \n");
	}
	else{
		playerDef *= 2;
		System.out.println("You get ready for the next attack.");
		hasDefend = true;
		}
	}

	public String getEnemyName(String targetName){return enemies.get(targetName).getName();}

	public void printEnemiesStats(){
		for (String i : enemies.keySet()) {
			System.out.println(enemies.get(i).getName() + " : " + enemies.get(i).getHealth() + " HP. \n" );
		}
	}
}