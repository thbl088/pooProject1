import Doors.LockedDoor;
import Items.Armor;
import Items.Weapon;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.Action;



import Locations.*;
import Locations.Shop;
import Characters.Enemy;
import Characters.Player;
import Characters.Npc;
import Items.Item;

public class ActionManager {
	private Scanner scanner;
	private String command;
	private boolean isFighting;
	private World currentGame;
	private Fight fight;
	private String[] parsedCommands;

	public ActionManager(World monde)
	{
		this.scanner = new Scanner(System.in);
		this.currentGame = monde;
	}


	public void getAction() {
		System.out.print("Enter your action : ");
		command = scanner.nextLine();
		parsedCommands = command.split(" ");

		if(isFighting){ //actions disponibles pendant un combat
			switch (parsedCommands[0].toLowerCase()) {
				case "attack" :
					if (parsedCommands.length > 1) {
						this.fight.playerAttack(parsedCommands[1].toLowerCase());
					}
					else {
						System.out.println("Who do you want to attack ?");
					}
					break;
				case "defend" :
					this.fight.defend();
					break;
					case "help" :
					actionHelp();
					break;
				case "look" :
					if (parsedCommands.length == 2) {
						actionLook(parsedCommands[1].toLowerCase());
					}
					else if(parsedCommands.length == 3){
						switch (parsedCommands[1].toLowerCase()){
							case "item" -> actionLookItem(parsedCommands[2].toLowerCase());
							default -> System.out.println("Do you want to look at an item?");
						}
					}
					else {
						System.out.println("What do you want to look at ?");
					}
					break;
				case "use", "drink", "equip" :
					if (parsedCommands.length > 1) {
						actionUse(parsedCommands[1].toLowerCase());
					}
					else {
						System.out.println("What do you want to use ?");
					}
					break;
				case "remove" :
					if (parsedCommands.length > 1) {
						actionRemove(parsedCommands[1].toLowerCase());
					}
					else {
						System.out.println("What do you want to remove ?");
					}
					break;
				case "quit" :
					actionQuit();
					break;
				default :
					System.out.println("You can't do this");
					break;
			}
		}
		else{ //actions disponibles hors combats
			switch (parsedCommands[0].toLowerCase()) {
				case "go" :
					if (parsedCommands.length > 1) {
						actionGo(parsedCommands[1].toLowerCase());
					}
					else {
						System.out.println("Where do you want to go ?");
					}
					break;
				case "talk", "speak" :
					if (parsedCommands.length > 1) {
						actionTalk(parsedCommands[1].toLowerCase());
					}
					else {
						System.out.println("Who do you want to talk to ?");
					}
					break;
				case "help" :
					actionHelp();
					break;
				case "look" :
					if (parsedCommands.length == 2) {
						actionLook(parsedCommands[1].toLowerCase());
					}
					else if(parsedCommands.length == 3){
						switch (parsedCommands[1].toLowerCase()){
							case "item" -> actionLookItem(parsedCommands[2].toLowerCase());
							default -> System.out.println("Do you want to look at an item?");
						}
					}
					else {
						System.out.println("What do you want to look at ?");
					}
					break;
				case "take" :
					if (parsedCommands.length > 1) {
						actionTake(parsedCommands[1].toLowerCase());
					}
					else {
						System.out.println("What do you want to take ?");
					}
					break;
				case "use", "drink", "equip" :
					if (parsedCommands.length > 1) {
						actionUse(parsedCommands[1].toLowerCase());
					}
					else {
						System.out.println("What do you want to use ?");
					}
					break;
				case "remove" :
					if (parsedCommands.length > 1) {
						actionRemove(parsedCommands[1].toLowerCase());
					}
					else {
						System.out.println("What do you want to remove ?");
					}
					break;
				case "fight" :
					actionFight();
					break;
				case "quit" :
					actionQuit();
					break;
				case "buy" :
					if (parsedCommands.length > 2) {
						switch (parsedCommands[1].toLowerCase()){
							case "item" -> actionBuyItem(parsedCommands[2].toLowerCase());
							case "potion" -> actionBuyPotion(parsedCommands[2].toLowerCase());
							default -> System.out.println("Do you want to buy potion or item?");
						}
					}
					else {
						System.out.println("What do you want to buy ?");
					}
					break;
				case "sell" :
					if (parsedCommands.length > 1) {
						actionSell(parsedCommands[1].toLowerCase());
					}
					else {
						System.out.println("What do you want to sell ?");
					}
					break;
				default :
					System.out.println("You can't do this");
					break;
			}
		}
	}

	/**
	 * 
	 * @param direction
	 */
	public void actionGo(String direction) {
		Map currentLoc = this.currentGame.player.getMapHero();
		Player currentPlayer = this.currentGame.player;


		switch (direction.toLowerCase()) {
			case "north", "n" :
				if (currentLoc.isNorth() && (!(currentLoc.getNorth() instanceof LockedDoor) || !((LockedDoor) currentLoc.getNorth()).isLocked()) ||
				 (currentLoc.getName().equals("End Portal") &&  currentPlayer.hasItem("car_wheel") && currentPlayer.hasItem("little_wheel") && currentPlayer.hasItem("tank_track")))
				 {
					currentPlayer.move(currentLoc.getNorth().getDestination());
					System.out.println("You Enter : " + currentPlayer.getMapHero().getName() + "\n" + currentPlayer.getMapHero().getDescription());
				}
				else if (!currentLoc.isNorth()) { System.out.println("Impossible to go north"); }
				else if (((LockedDoor) currentLoc.getNorth()).isLocked()) { System.out.println("North door is locked"); }
				break;
			case "south", "s" :
				if (currentLoc.isSouth() && (!(currentLoc.getSouth() instanceof LockedDoor) || !((LockedDoor) currentLoc.getSouth()).isLocked()) ||
				 ( currentLoc.getName().equals("Crash Site") &&  currentPlayer.hasItem("jack") )) {
					currentPlayer.move(currentLoc.getSouth().getDestination());
					System.out.println("You Enter : " + currentPlayer.getMapHero().getName() + "\n" + currentPlayer.getMapHero().getDescription());
				}
				else if (!currentLoc.isSouth()) { System.out.println("Impossible to go south"); }
				else if (((LockedDoor) currentLoc.getSouth()).isLocked()) { System.out.println("South door is locked"); }
				break;
			case "east", "e" :
				if (currentLoc.isEast() && (!(currentLoc.getEast() instanceof LockedDoor) || !((LockedDoor) currentLoc.getEast()).isLocked())) {
					currentPlayer.move(currentLoc.getEast().getDestination());
					System.out.println("You Enter : " + currentPlayer.getMapHero().getName() + "\n" + currentPlayer.getMapHero().getDescription());
				}
				else if (!currentLoc.isEast()) { System.out.println("Impossible to go east"); }
				else if (((LockedDoor) currentLoc.getEast()).isLocked()) { System.out.println("East door is locked"); }
				break;
			case "west","w" :
				if (currentLoc.isWest() && (!(currentLoc.getWest() instanceof LockedDoor) || !((LockedDoor) currentLoc.getWest()).isLocked())) {
					currentPlayer.move(currentLoc.getWest().getDestination());
					System.out.println("You Enter : " + currentPlayer.getMapHero().getName() + "\n" + currentPlayer.getMapHero().getDescription());
				}
				else if (!currentLoc.isWest()) { System.out.println("Impossible to go west"); }
				else if (((LockedDoor) currentLoc.getWest()).isLocked()) { System.out.println("West door is locked"); }
				break;
			case "shop" :
				if (currentLoc.isShop()) {
					currentPlayer.move(currentLoc.getShop().getDestination());
					System.out.println("You Enter : " + currentPlayer.getMapHero().getName() + "\n" + currentPlayer.getMapHero().getDescription());}
				else { System.out.println("There is no shop"); }
				break;
			case "back", "out" :
				if (currentLoc instanceof Shop) {
					currentPlayer.move(((Shop) currentLoc).getExitShop());
					System.out.println("Xavier [Marchand] :\"Good Bye Hero.\"");
					System.out.println("You Enter : " + currentPlayer.getMapHero().getName() + "\n" + currentPlayer.getMapHero().getDescription());
				}
				else { System.out.println("You cannot exit current location"); }
				break;
			default :
				System.out.println("You can't go there.");
				break;
		}
	}

	public void actionHelp() {
		if (isFighting){
			System.out.println("""
					-----------------------------------------
					Available actions : 
					ATTACK
					DEFEND
					USE + item
					QUIT
					-----------------------------------------""");
		}
		else{
			System.out.println("""
					-----------------------------------------
					Available actions : 
					LOOK + location(here), inventory, stat, potion, enemy, npc, equipment, ground, money or shop(if in a shop)
					LOOK ITEM + item
					TALK + name
					GO + direction(cardinal points, shop if available and back to leave the shop)
					TAKE + item
					USE + item
					REMOVE + item
					FIGHT
					QUIT
					-----------------------------------------""");
		}
	}

	/**
	 * 
	 * @param item
	 */
	public void actionLook(String item) {
		switch (item.toLowerCase()) {
			case "here", "around" : System.out.println(this.currentGame.getMapDescription());
				break;
			case "inventory" : this.currentGame.player.printInventory();
				break;
			case "stat" : System.out.println("Player : " + this.currentGame.player.getName() + " : " + this.currentGame.player.getHealth() + " HP, " + this.currentGame.player.getAttack() + " att, "+ this.currentGame.player.getDefense() + " def." );
				break;
			case "potion" : System.out.println(this.currentGame.player.getNbPotion());
				break;
			case "enemy", "enemies" : System.out.println(this.currentGame.player.getMapHero().getEnemiesList());
			break;
			case "npc" :  System.out.println(this.currentGame.player.getMapHero().getNpcsList());
				break;
			case "equipment" : this.currentGame.player.showEquipement();
				break;
			case "shop" : if( this.currentGame.player.getMapHero() instanceof Shop){
					Shop shop = (Shop) this.currentGame.player.getMapHero();
					System.out.println("This is what we have :");

					System.out.println("""
					-----------
					|  item   |
					-----------
					________________________________________________
					""");
					shop.printItems();
					System.out.println("""
					-------------
					|  potion   |
					-------------
					________________________________________________
					""");
					shop.printPotions();
					System.out.println("________________________________________________");
				} 
				else{System.out.println("You're not in a shop.");}
				break;
			case "money" : System.out.println(this.currentGame.player.getStatistics().getMoney());
				break;
			case "ground" : System.out.println(this.currentGame.player.getMapHero().getGroundItemsList());
				break;
			default : System.out.println("You can't look at this");
				break;
		}
	}

	public void actionLookItem(String lookedAt){
		Item item = this.currentGame.player.getItem(lookedAt);
		if(item != null)
			System.out.println(item.getDescription());
	}
	/**
	 * 
	 * @param item
	 */
	public void actionTake(String item) {
		Item takeItem = currentGame.player.getMapHero().getItem(item);
		if(takeItem != null){
			currentGame.player.addInventory(takeItem);
		}
		else{
			System.out.println("Nothing to take.");
		}
	}

	public void actionTalk(String name){

		Player p = this.currentGame.player;

		if ( p.getMapHero().getNpc(name) != null ){      // vérifie si l'entité est bien un pnj
			System.out.println( p.getMapHero().getNpc(name).getDialog()); // récupére et affiche son dialogue

														
			if ( (name.equals("crazy_man") && !(p.hasItem("tank_track")) )    //vérifie le pnj si c'est  le crazy_man ou samuel deux pnj qui donne des items et on vérifie si ils ont déjà pas donnée les items
			|| name.equals("samuel") && !(p.hasItem("garbage_collector"))) {  
				
				Item objet_pnj = p.getMapHero().getNpc(name).getItem();
				System.out.println("You obtain " + objet_pnj.getName() + ".");

				p.addInventory(objet_pnj);
			}
		}
		else {
			System.out.println("Wrong name");
		}
	}

	public void actionQuit() { System.exit(0); }

	/**
	 * 
	 * @param item
	 */
	public void actionUse(String item) {
		final String UNUSABLE = "You can't use that right now";
		switch (item) {
			case "health_potion", "hp" : 
			System.out.println("You drink a health potion.");
				currentGame.player.useHealthPotion(); 
				break;
			case "attack_potion", "ap" : 
				if(isFighting) {
					System.out.println("You drink an attack potion.");
					currentGame.player.useAttackPotion();
					}
				else{
					System.out.println(UNUSABLE);
				}
				break;
				
			case "defense_potion", "dp" :
				if(isFighting) {
					System.out.println("You drink a defense potion.");
					currentGame.player.useDefensePotion();
				}
				else{
					System.out.println(UNUSABLE);
					}
				break;
			case "crit_potion", "cp" : 
				if(isFighting){
					System.out.println("You drink a critic potion.");
					currentGame.player.useCritPotion();
				}
				else{
						System.out.println(UNUSABLE);
				}
				break;		
			default :
				actionEquip(item);		
				break;		
		}

	}

	public void actionRemove(String item) {

		if (this.currentGame.player.hasItem(item) ) {
			
			this.currentGame.player.removeEquipment(this.currentGame.player.getItem(item));

		}
		else{

			System.out.println("You can't remove this.");
		}

	}


	public void actionEquip(String name_item){
		
		Item item = this.currentGame.player.getItem(name_item);

		if( item != null ){
			this.currentGame.player.addEquipment(item);
		}
		else{
			System.out.println("It's not a item.");
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

	public void startFight() {
		isFighting = true;
		this.fight = new Fight(currentGame.player);
		int turnCounter = 0;
		while(fight.stillFighting() == 0){
			System.out.println("Turn " + turnCounter + "\n");
			fight.printPlayerStats();
			fight.printEnemiesStats();

			getAction();			
			fight.enemyAttack();
			fight.remEnemyDeath();
			turnCounter++;
		}
		if(fight.stillFighting() == 1){
			//System.out.println("You are dead\n");
			//actionQuit();
		}
		if(fight.stillFighting() == 2){
			System.out.println("You have win this fight\n");
			endFight();
			currentGame.player = fight.getPlayerPostFight();
		}
	}

	public void endFight() {
		isFighting = false;
	}
	
	public void actionBuyItem(String item) {

		this.currentGame.player.buyItem(item.toLowerCase());
	}

	public void actionBuyPotion(String potion) {

		this.currentGame.player.buyPotion(potion.toLowerCase());

	}

	public void actionSell(String item) {
		this.currentGame.player.sellItem(item.toLowerCase());
	}
}