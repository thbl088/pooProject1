import Characters.*;

public class Fight {
	private boolean usedAttackPotion;
	private boolean usedDefensePotion;
	private boolean usedCritPotion;
	private Player player;
	private Enemy enemy;

	private int enemyHP = this.enemy.getHealth();
	
	private int playerHP = this.player.getHealth();
	private int playerDef = this.player.getDefense();
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

	public String getEnemyName(){
		return this.enemy.getName();
	}

	public void playerAttack() {
		System.out.println("Vous attaquez" + this.enemy.getName());
		damage = this.player.getAttack()-this.enemy.getDefense();
		if (damage>0){
			enemyHP -= damage;
			System.out.println("Vous faites" + damage +"degats"+ this.enemy.getName() +"a encore" + enemyHP + "points de vie");
		}
		else{
			playerHP -= damage;
			System.out.println("Vous vous faites" + damage +"degats il vous reste" + playerHP + "points de vie");
		}
		throw new UnsupportedOperationException();
	}

	public void enemyAttack() {
		System.out.println(this.enemy.getName() + "Vous attaque");
		damage = this.enemy.getAttack()-this.player.getDefense();
		if (damage>0){
			this.playerHP -= damage;
			System.out.println("L'enemie vous fait" + damage +"degats il vous reste" + playerHP + "points de vie");
		}
		else{
			this.enemyHP -= damage;
			System.out.println("Vous faites" + damage +"degats"+ this.enemy.getName() +"a encore" + enemyHP + "points de vie");
		}
		hasDefend = false;
		throw new UnsupportedOperationException();
	}

	public void defend() {
		this.playerDef *= 2;
		System.out.println("Vous vous préparez pour la prochaine attaque");
		this.hasDefend = true;
		throw new UnsupportedOperationException();
	}
}