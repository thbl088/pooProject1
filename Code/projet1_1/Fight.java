import Characters.*;

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
		System.out.println("Vous attaquez" + enemy.getName());
		damage = player.getAttack()-enemy.getDefense();
		if (damage>0){
			enemyHP -= damage;
			System.out.println("Vous faites" + damage +"degats"+ enemy.getName() +"a encore" + enemyHP + "points de vie");
		}
		else{
			playerHP -= damage;
			System.out.println("Vous vous faites" + damage +"degats il vous reste" + playerHP + "points de vie");
		}
	}

	public void enemyAttack() {
		System.out.println(enemy.getName() + "Vous attaque");
		damage = enemy.getAttack()-player.getDefense();
		if (damage>0){
			playerHP -= damage;
			System.out.println("L'enemie vous fait" + damage +"degats il vous reste" + playerHP + "points de vie");
		}
		else{
			enemyHP -= damage;
			System.out.println("Vous faites" + damage +"degats"+ enemy.getName() +"a encore" + enemyHP + "points de vie");
		}
		hasDefend = false;
	}

	public void defend() {
		playerDef *= 2;
		System.out.println("Vous vous préparez pour la prochaine attaque");
		hasDefend = true;
	}

	public String getEnemyName(){return enemy.getName();}
}