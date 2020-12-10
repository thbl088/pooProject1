import Characters.*;
import Characters.Character;

import java.util.HashMap;

public class Fight {
	private Player player;
	private HashMap<String, Enemy> enemies = new HashMap<String, Enemy>();
	private int damage;
	private boolean hasDefend = false;
	private int randomMax = 100;
	private int coeffCrit = 2;
	private int playerDef;
	private Player savePlayerBaseStat;
	
	public Fight(Player playerEnter){
		this.player = playerEnter;
		this.enemies = playerEnter.getMapHero().getEnemies();
		this.playerDef = playerEnter.getDefense();
		this.savePlayerBaseStat = playerEnter;
	}
	
	
	public int attackCrit(Character attacker){
		int random100 = (int)(Math.random() * randomMax);

		if(attacker.getCrit()>random100){
			System.out.println("CRITIC !!!!!!!!!!\n");
			return attacker.getAttack()*coeffCrit;
		}
		else{
			return attacker.getAttack();
		}
	}

	public void checkEnemyDeath(String targetName){
		if(enemies.get(targetName).getHealth()<1){
			System.out.println("You killed " + enemies.get(targetName).getName()+ " and got " + enemies.get(targetName).getStatistics().getMoney() + " money.");
			player.getStatistics().addMoney(enemies.get(targetName).getStatistics().getMoney());
			enemies.remove(targetName);
		}
	}

	public int stillFighting(){
		if (player.getHealth()<1){
			return 1;
		}
		if(enemies.size()==0){		
			player.getStatistics().changeAttack(savePlayerBaseStat.getAttack());
			player.getStatistics().changeDefense(savePlayerBaseStat.getDefense());
			player.getStatistics().changeCritical(savePlayerBaseStat.getCrit());
			return 2;
		}
		return 0;
	}

	public void playerAttack(String targetName) {
		
		hasDefend = false;
		System.out.println("You are attacking " + enemies.get(targetName).getName());
		damage = attackCrit(player)-enemies.get(targetName).getDefense();
		if (damage>0){
			enemies.get(targetName).getStatistics().removeHealth(damage);
			System.out.println("You inflicted " + damage +" dmg. " + enemies.get(targetName).getName() +" has " + enemies.get(targetName).getHealth() + " HP left.\n");
			checkEnemyDeath(enemies.get(targetName).getName());
		}
		else{
			player.getStatistics().removeHealth(-damage);
			System.out.println("You inflict yourself " + -damage +" dmg. You have " + player.getHealth() + " HP left.\n");
		}
	}

	public void enemyAttack() {
		for (String i : enemies.keySet()) {
			System.out.println(enemies.get(i).getName() + " is attacking.\n");
			damage = attackCrit(enemies.get(i))-playerDef;
			if (damage>0){
				player.getStatistics().removeHealth(damage);
				System.out.println(enemies.get(i).getName() + " has inflicted " + damage +" dmg, you have " + player.getHealth() + " HP remaining.\n");
			}
			else{
				enemies.get(i).getStatistics().removeHealth(-damage);
				System.out.println("You have inflicted " + -damage +" dmg. "+ enemies.get(i).getName() +" has " + enemies.get(i).getHealth() + " HP.\n");
				checkEnemyDeath(enemies.get(i).getName());
			}
		}
	}

	public void defend() {
	if(hasDefend){
		System.out.println("You keep your defend. \n");
	}
	else{
		this.playerDef *= 2;
		System.out.println("You get ready for the next attack.");
		hasDefend = true;
		}
	}

	public String getEnemyName(String targetName){return enemies.get(targetName).getName();}

	public void printEnemiesStats(){
		for (String i : enemies.keySet()) {
			System.out.println(enemies.get(i).getName() + " : " + enemies.get(i).getHealth() + " HP." );
		}
		System.out.println("_____________________");
	}

	public void printPlayerStats(){
		System.out.println("Player : " + player.getName() + " : " + player.getHealth() + " HP, " + player.getAttack() + " att, "+ playerDef + " def." );
		System.out.println("_____________________");
	}

}