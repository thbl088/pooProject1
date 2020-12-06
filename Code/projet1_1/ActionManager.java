import Doors.LockedDoor;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import Characters.Enemy;
import Characters.Player;

public class ActionManager {
	private Scanner scanner;
	private String command;
	private boolean isFighting;
	private World currentGame;
	private Fight fight;


	public void getAction() {
		String[] parsedCommands = command.split(" ");

		if(isFighting){ //actions disponibles pendant un combat
			switch (parsedCommands[0].toLowerCase()) {
				case "attack" :
					fight.playerAttack();
					break;
				case "defend" :
					fight.defend();
					break;
				case "help" :
					actionHelp();
					break;
				case "use" :
					actionUse(parsedCommands[1]);
					break;
				case "quit" :
					actionQuit();
					break;
			}
		}
		else{ //actions disponibles hors combats
			switch (parsedCommands[0].toLowerCase()) {
				case "go" :
					actionGo(parsedCommands[1]);
					break;
				case "help" :
					actionHelp();
					break;
				case "look" :
					actionLook(parsedCommands[1]);
					break;
				case "take" :
					actionTake(parsedCommands[1]);
					break;
				case "use" :
					actionUse(parsedCommands[1]);
					break;
				case "fight" :
					actionFight();
					break;
				case "quit" :
					actionQuit();
					break;
			}
		}
	}

	/**
	 * 
	 * @param direction
	 */
	public void actionGo(String direction) {
		if (direction.equalsIgnoreCase("North")){
			if (this.currentGame.player.getMapHero().isNorth() && !(this.currentGame.player.getMapHero().getNorth() instanceof LockedDoor))
			{
				this.currentGame.player.move(this.currentGame.player.getMapHero().getNorth().getDestination());
			}
			else if (!this.currentGame.player.getMapHero().isNorth()){
				System.out.println("Impossible to go north");
			}
			else if (this.currentGame.player.getMapHero().getNorth() instanceof LockedDoor){
				System.out.println("North door is locked");
			}
		}
		else if (direction.equalsIgnoreCase("South")){
			if (this.currentGame.player.getMapHero().isSouth() && !(this.currentGame.player.getMapHero().getSouth() instanceof LockedDoor))
			{
				this.currentGame.player.move(this.currentGame.player.getMapHero().getSouth().getDestination());
			}
			else if (!this.currentGame.player.getMapHero().isSouth()){
				System.out.println("Impossible to go south");
			}
			else if (this.currentGame.player.getMapHero().getSouth() instanceof LockedDoor){
				System.out.println("South door is locked");
			}
		}
		else if (direction.equalsIgnoreCase("East")){
			if (this.currentGame.player.getMapHero().isEast() && !(this.currentGame.player.getMapHero().getEast() instanceof LockedDoor))
			{
				this.currentGame.player.move(this.currentGame.player.getMapHero().getEast().getDestination());
			}
			else if (!this.currentGame.player.getMapHero().isEast()){
				System.out.println("Impossible to go east");
			}
			else if (this.currentGame.player.getMapHero().getEast() instanceof LockedDoor){
				System.out.println("East door is locked");
			}
		}
		else if (direction.equalsIgnoreCase("West")){
			if (this.currentGame.player.getMapHero().isWest() && !(this.currentGame.player.getMapHero().getWest() instanceof LockedDoor))
			{
				this.currentGame.player.move(this.currentGame.player.getMapHero().getWest().getDestination());
			}
			else if (!this.currentGame.player.getMapHero().isWest()){
				System.out.println("Impossible to go west");
			}
			else if (this.currentGame.player.getMapHero().getWest() instanceof LockedDoor){
				System.out.println("West door is locked");
			}
		}
	}

	public void actionHelp() {
		if (isFighting){
			System.out.println("You can use attack, defend, use an item, quit the game");
		}
		else{
			System.out.println("You can look, go to a direction, take an object, fight, use an item, quit the game");
		}
	}

	/**
	 * 
	 * @param item
	 */
	public void actionLook(String item) {
		this.currentGame.player.getMapHero().getDescription();
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
	}

	/**
	 * 
	 * @param potion
	 */
	public void actionUse(String potion) {
		switch (potion) {
			case "healthPotion" :
				currentGame.player.useHealthPotion();
				break;
			case "attackPotion" :
				currentGame.player.useAttackPotion();
				break;
			case "defensePotion" :
				currentGame.player.useDefensePotion();
				break;
			case "critPotion" :
				currentGame.player.useCritPotion();
				break;
		}
	}

	public void actionFight() {
		if(currentGame.player.getMapHero().getEnemy().isEmpty()){
			System.out.println("There is no enemies");
		}
		else{
			startFight(); 
		}
	}

	public void startFight() {
		//currentGame.player.getMapHero().getEnemy().get(currentGame.player.getMapHero().getEnemy().keySet().toArray()[0])
		isFighting = true;
		int turnCounter = 0;
		while(fight.stillFighting() == 0){
			System.out.println("Turn " + turnCounter);
			System.out.println("Enter your action : ");

			getAction();			
			fight.enemyAttack();
			turnCounter++;
		}
		if(fight.stillFighting() == 1){
			System.out.println("You are dead");
			actionQuit();
		}
		if(fight.stillFighting() == 2){
			System.out.println("You have defeated " + fight.getEnemyName());
			endFight();
		}
	}

	public void endFight() {
		isFighting = false;
	}

}