public class ActionManager {
	private String scanner;
	private String command;
	private boolean isFighting;
	private World currentGame;
	private Fight fight;

	/**
	 * 
	 * @param CommandLine
	 */
	public void getAction(String CommandLine) {
		// TODO - implement ActionManager.getAction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param direction
	 */
	public void actionGo(String direction) {
		// TODO - implement ActionManager.actionGo
		this.currentGame.player.move(direction);
		throw new UnsupportedOperationException();
	}

	public void actionHelp() {
		// TODO - implement ActionManager.actionHelp
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void actionLook(String item) {
		this.currentGame.player.map.getMapDescription();
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void actionTake(String item) {
		// TODO - implement ActionManager.actionTake
		throw new UnsupportedOperationException();
	}

	public void actionQuit() {
		System.exit(0);
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param potion
	 */
	public void actionUse(String potion) {
		// TODO - implement ActionManager.actionUse
		throw new UnsupportedOperationException();
	}

	public void actionFight() {
		startFight();
		throw new UnsupportedOperationException();
	}

	public void startFight() {
		this.isFighting = true;
		int turnCounter = 0;
		while(this.fight.stillFighting() == 0){
			System.out.println("Tour " + turnCounter);
			System.out.println("Entrez votre action");
			// TODO - implement Enter choice
			//getAction(scanner);
			
			this.fight.enemyAttack();
			turnCounter++;
		}
		if(this.fight.stillFighting() == 1){
			System.out.println("Vous etes mort");
			actionQuit();
		}
		if(this.fight.stillFighting() == 2){
			System.out.println("Vous avez vaincu" + this.fight.getEnemyName());
			endFight();
		}
		throw new UnsupportedOperationException();
	}

	public void endFight() {
		this.isFighting = false;
		throw new UnsupportedOperationException();
	}

}