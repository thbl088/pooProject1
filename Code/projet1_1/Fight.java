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
	private int formerAtt;
	private int formerDef;
	private int formerCrit;

	
	public Fight(Player playerEnter){
		this.player = playerEnter;
		this.enemies = playerEnter.getMapHero().getEnemies();
		this.formerAtt = playerEnter.getAttack();
		this.formerDef = playerEnter.getDefense();
		this.formerCrit = playerEnter.getCrit();
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
			if(enemies.get(targetName).getObject() != null){
				player.addInventory(enemies.get(targetName).getObject());
			}
		}
	}

	public void remEnemyDeath(){
		int size = this.player.getMapHero().getEnemies().size();
		String[] deathNote = new String[size];
		int i =0;
		for (String j : enemies.keySet()) {
			if(enemies.get(j).getHealth()<1){
				deathNote[i] = j;
				i++;
			}
		}
		for (int k = 0; k < size; k++) {
			enemies.remove(deathNote[k]);
		  }
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
		if(hasDefend){this.player.getStatistics().changeDefense(this.player.getDefense()/2);}
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
			System.out.println(i + " is attacking.\n");
			damage = attackCrit(enemies.get(i))-player.getDefense();
			if (damage>0){
				player.getStatistics().removeHealth(damage);
				System.out.println(i + " has inflicted " + damage +" dmg, you have " + player.getHealth() + " HP remaining.\n");
			}
			else{
				enemies.get(i).getStatistics().removeHealth(-damage);
				System.out.println("You have inflicted " + -damage +" dmg. "+ i +" has " + enemies.get(i).getHealth() + " HP.\n");
			}
		}
		for (String i : enemies.keySet()) {
			checkEnemyDeath(i);
		}
	}

	public void defend() {
	if(hasDefend){
		System.out.println("You keep your defend. \n");
	}
	else{
		player.getStatistics().addDefense(this.player.getDefense());
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
		System.out.println("Player : " + player.getName() + " : " + player.getHealth() + " HP, " + player.getAttack() + " att, "+ player.getDefense() + " def." );
		System.out.println("_____________________");
	}

	public Player getPlayerPostFight(){
		System.out.println("Player : " + player.getName() + " : " + player.getHealth() + " HP, " + player.getAttack() + " att, "+ player.getDefense() + " def, " + player.getStatistics().getMoney() + " golds.");
		return player;
	}
}