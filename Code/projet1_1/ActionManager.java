import Doors.LockedDoor;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import Locations.*;

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
				case "attack" -> fight.playerAttack(parsedCommands[1].toLowerCase());
				case "defend" -> fight.defend();
				case "help" -> actionHelp();
				case "use" -> actionUse(parsedCommands[1]);
				case "quit" -> actionQuit();
				default -> System.out.println("You can't do this");
			}
		}
		else{ //actions disponibles hors combats
			switch (parsedCommands[0].toLowerCase()) {
				case "go" -> actionGo(parsedCommands[1]);
				case "help" -> actionHelp();
				case "look" -> actionLook(parsedCommands[1]);
				case "take" -> actionTake(parsedCommands[1]);
				case "use" -> actionUse(parsedCommands[1]);
				case "fight" -> actionFight();
				case "quit" -> actionQuit();
				case "buy" -> actionBuy(parsedCommands[1]);
				case "sell" -> actionSell(parsedCommands[1]);
				default -> System.out.println("You can't do this");
			}
		}
	}

	/**
	 * 
	 * @param direction
	 */
	public void actionGo(String direction) {
		Map northDir = this.currentGame.player.getMapHero().getNorth().getDestination();
		Map southDir = this.currentGame.player.getMapHero().getSouth().getDestination();
		Map eastDir = this.currentGame.player.getMapHero().getEast().getDestination();
		Map westDir = this.currentGame.player.getMapHero().getWest().getDestination();
		Map shop = this.currentGame.player.getMapHero().getShop();
		Map currentLoc = this.currentGame.player.getMapHero();
		Player currentPlayer = this.currentGame.player;


		switch (direction.toLowerCase()) {
			case "north" :
				if (currentLoc.isNorth() && (!(currentLoc.getNorth() instanceof LockedDoor) || !((LockedDoor) currentLoc.getNorth()).isLocked())) {
					currentPlayer.move(northDir);
				}
				else if (!currentLoc.isNorth()) { System.out.println("Impossible to go north"); }
				else if (((LockedDoor) currentLoc.getNorth()).isLocked()) { System.out.println("North door is locked"); }
				break;
			case "south" :
				if (currentLoc.isSouth() && (!(currentLoc.getSouth() instanceof LockedDoor) || !((LockedDoor) currentLoc.getSouth()).isLocked())) {
					currentPlayer.move(southDir);
				}
				else if (!currentLoc.isSouth()) { System.out.println("Impossible to go south"); }
				else if (((LockedDoor) currentLoc.getSouth()).isLocked()) { System.out.println("South door is locked"); }
				break;
			case "east" :
				if (currentLoc.isEast() && (!(currentLoc.getEast() instanceof LockedDoor) || !((LockedDoor) currentLoc.getEast()).isLocked())) {
					currentPlayer.move(eastDir);
				}
				else if (!currentLoc.isEast()) { System.out.println("Impossible to go east"); }
				else if (((LockedDoor) currentLoc.getEast()).isLocked()) { System.out.println("East door is locked"); }
				break;
			case "west" :
				if (currentLoc.isWest() && (!(currentLoc.getWest() instanceof LockedDoor) || !((LockedDoor) currentLoc.getWest()).isLocked())) {
					currentPlayer.move(westDir);
				}
				else if (!currentLoc.isWest()) { System.out.println("Impossible to go west"); }
				else if (((LockedDoor) currentLoc.getWest()).isLocked()) { System.out.println("West door is locked"); }
				break;
			case "shop" :
				if (currentLoc.isShop()) { currentPlayer.move(shop); }
				else { System.out.println("There is no shop"); }
				break;
			case "back", "out" :
				if (currentLoc instanceof Shop) { currentPlayer.move(((Shop) currentLoc).getExitShop()); }
				else { System.out.println("You cannot exit current location"); }
				break;
			default :
				System.out.println("You can't go there");
				break;
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
		switch (item.toLowerCase()) {
			case "here", "around" -> System.out.println(this.currentGame.getMapDescription());
			case "inventory" -> this.currentGame.player.printInventory();
			case "enemy", "enemies" -> this.currentGame.player.getMapHero().getEnemiesList();
			default -> System.out.println("You can't look at this");
		}
	}

	/**
	 * 
	 * @param item
	 */
	public void actionTake(String item) {
		// TODO - implement ActionManager.actionTake
		throw new UnsupportedOperationException();
	}

	public void actionQuit() { System.exit(0); }

	/**
	 * 
	 * @param potion
	 */
	public void actionUse(String potion) {
		final String UNUSABLE = "You can't use that right now";
		switch (potion) {
			case "healthPotion" -> currentGame.player.useHealthPotion();
			case "attackPotion" -> {
									if(isFighting) {
										currentGame.player.useAttackPotion();
									}
									else{
										System.out.println(UNUSABLE);
									}
								}
				
			case "defensePotion" -> {
									if(isFighting) {
										currentGame.player.useDefensePotion();
										}
										else{
											System.out.println(UNUSABLE);
										}
									}
			case "critPotion" -> {
								if(isFighting){
									currentGame.player.useCritPotion();
								}
								else{
										System.out.println(UNUSABLE);
								}
							}
		}
	}

	public void actionFight() {
		if(currentGame.player.getMapHero().getEnemies().isEmpty()){
			System.out.println("There are no enemies here");
		}
		else{
			startFight(); 
		}
	}


	public void actionBuy(String item) {
		this.currentGame.player.buyItem(item.toLowerCase());
	}

	public void actionSell(String item) {
		this.currentGame.player.sellItem(item.toLowerCase());
	}


	public void startFight() {
		isFighting = true;
		int turnCounter = 0;
		while(fight.stillFighting() == 0){
			System.out.println("Turn " + turnCounter + "\n");
			System.out.println("Enter your action : ");

			getAction();			
			fight.enemyAttack();
			turnCounter++;
		}
		if(fight.stillFighting() == 1){
			System.out.println("You are dead\n");
			actionQuit();
		}
		if(fight.stillFighting() == 2){
			System.out.println("You have win this fight\n");
			endFight();
		}
	}

	public void endFight() {
		isFighting = false;
	}

}