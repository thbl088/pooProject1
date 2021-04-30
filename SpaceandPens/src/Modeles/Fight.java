package Modeles;

import java.util.HashMap;

public class Fight {
	private final Player PLAYER;
	private final HashMap<String, Enemy> ENEMIES;
	private int damage;
	private boolean hasDefend;
	private final int RANDOM_MAX;
	private final int COEFF_CRIT;
	private final int FORMER_ATT;
	private final int FORMER_DEF;
	private final int FORMER_CRIT;

	
	public Fight(Player playerEnter){ //constructeur fight prend un joueur en entrer
		this.PLAYER = playerEnter;
		this.ENEMIES = playerEnter.getMapHero().getEnemies();
		this.hasDefend = false;
		this.RANDOM_MAX = 100;
		this.COEFF_CRIT = 2;
		this.FORMER_ATT = playerEnter.getAttack();
		this.FORMER_DEF = playerEnter.getDefense();
		this.FORMER_CRIT = playerEnter.getCrit();
	}
	
	
	public int attackCrit(Character attacker){ //fonction calculant si un attaque est un crit et retourne les dégats infliger
		int random100 = (int)(Math.random() * this.RANDOM_MAX);

		if(attacker.getCrit()>random100){
			return attacker.getAttack()*this.COEFF_CRIT;
		}
		else{
			return attacker.getAttack();
		}
	}

	public void checkEnemyDeath(String targetName){ //vérifie si un enemi est mort et ajoute son argent et objet tenu
		if(this.ENEMIES.get(targetName).getHealth()<1){
			this.PLAYER.getStatistics().addMoney(this.ENEMIES.get(targetName).getStatistics().getMoney());
			if(this.ENEMIES.get(targetName).getObject() != null){
				this.PLAYER.addInventory(this.ENEMIES.get(targetName).getObject());
			}
		}
	}

	public void remEnemyDeath(){ //retire les enemies mort de la hashmap
		int size = this.PLAYER.getMapHero().getEnemies().size();
		String[] deathNote = new String[size];
		int i =0;
		for (String j : this.ENEMIES.keySet()) {
			if(this.ENEMIES.get(j).getHealth()<1){
				deathNote[i] = j;
				i++;
			}
		}
		for (int k = 0; k < size; k++) {
			this.ENEMIES.remove(deathNote[k]);
		  }
	}

	public int stillFighting(){ //vérifie si le combat continue
		if (this.PLAYER.getHealth()<1){
                    return 1;
		}
		if(this.ENEMIES.size()==0){
			if(hasDefend){this.PLAYER.getStatistics().changeDefense(this.PLAYER.getDefense()/2);}
			return 2;
		}
		return 0;
	}

	public void playerAttack(String targetName) { //calcule les dégats que le joueur inflige a un enemi
		if(hasDefend){this.PLAYER.getStatistics().changeDefense(this.PLAYER.getDefense()/2);}
		hasDefend = false;
		damage = attackCrit(this.PLAYER)-this.ENEMIES.get(targetName).getDefense();
		if (damage>0){
			this.ENEMIES.get(targetName).getStatistics().removeHealth(damage);
			checkEnemyDeath(this.ENEMIES.get(targetName).getName());
		}
		else{
			this.PLAYER.getStatistics().removeHealth(-damage);
		}
		for (String i : this.ENEMIES.keySet()) {
			checkEnemyDeath(i);
		}
		remEnemyDeath();
	}

	public void enemyAttack() { //calcule les dégats que l'enemi inflige au joueur
		for (String i : this.ENEMIES.keySet()) {
			damage = attackCrit(this.ENEMIES.get(i))-this.PLAYER.getDefense();
			if (damage>0){
				this.PLAYER.getStatistics().removeHealth(damage);
			}
			else{
				this.ENEMIES.get(i).getStatistics().removeHealth(-damage);
			}
		}
		for (String i : this.ENEMIES.keySet()) {
			checkEnemyDeath(i);
		}
	}

	public void defend() { //multiplie la def du joueur par 2 jusqu'a son prochain tour
            
            if(true != hasDefend){
                 this.PLAYER.getStatistics().addDefense(this.PLAYER.getDefense());
                 hasDefend = true;
            }
	}

        
	public void getPlayerPostFight(){   //Après un combat le joueur perd son bonus de potion
            PLAYER.removeBonusPotion();
	}
}
        
