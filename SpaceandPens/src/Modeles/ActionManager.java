package Modeles;


import Controllers.TalkController;
import java.util.ArrayList;
import java.util.Scanner;


public class ActionManager {
	public final Scanner SCANNER;
	private boolean isFighting;
	private final WorldIHM CURRENT_GAME;
	private Fight fight;

	public ActionManager(WorldIHM monde)
	{
		this.SCANNER = new Scanner(System.in);
		this.CURRENT_GAME = monde;
	}


	public void getAction() {
		System.out.print("Enter your action : ");
		String command = SCANNER.nextLine();
		String[] parsedCommands = command.split(" ");

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
						if ("item".equalsIgnoreCase(parsedCommands[1])) {
							actionLookItem(parsedCommands[2].toLowerCase());
						} else {
							System.out.println("Do you want to look at an item?");
						}
					}
					else {
						System.out.println("What do you want to look at ?");
					}
					break;
				case "use" :
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
				case "talk" :
					if (parsedCommands.length > 1) {
						//actionTalk(parsedCommands[1].toLowerCase());
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
						if ("item".equalsIgnoreCase(parsedCommands[1])) {
							actionLookItem(parsedCommands[2].toLowerCase());
						} else {
							System.out.println("Do you want to look at an item?");
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
				case "use" :
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
							case "item" : actionBuyItem(parsedCommands[2].toLowerCase());
							case "potion" : actionBuyPotion(parsedCommands[2].toLowerCase());
                                                        default : System.out.println("Do you want to buy a potion or an item?");
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


	public Object[] actionGo(String direction) { //déplace le joueur sur le monde
		Map currentLoc = this.CURRENT_GAME.player.getMapHero();
		Player currentPlayer = this.CURRENT_GAME.player;


		switch (direction.toLowerCase()) {
			case "north" :
				if (currentLoc.isNorth() && (!(currentLoc.getNorth() instanceof LockedDoor) || !((LockedDoor) currentLoc.getNorth()).isLocked()))
				 {
					currentPlayer.move(currentLoc.getNorth().getDestination());
					return new Object[]{true, "You Enter : " + currentPlayer.getMapHero().getName()};
				 }
				else if (!currentLoc.isNorth())
				{
					return new Object[]{false, "Impossible to go north"};
				}
				else if (((LockedDoor) currentLoc.getNorth()).isLocked())
				{
                                        
					return new Object[]{false, "North door is locked"};
				}
				break;
			case "south" :
				if (currentLoc.isSouth() && (!(currentLoc.getSouth() instanceof LockedDoor) || !((LockedDoor) currentLoc.getSouth()).isLocked()) ||
				 ( currentLoc.getName().equals("Crash Site") &&  currentPlayer.hasItem("jack") ))
				{
					currentPlayer.move(currentLoc.getSouth().getDestination());
					return new Object[]{true, "You Enter : " + currentPlayer.getMapHero().getName()};
				}
				else if (!currentLoc.isSouth())
				{
					return new Object[]{false, "Impossible to go south"};
				}
				else if (((LockedDoor) currentLoc.getSouth()).isLocked())
				{
					return new Object[]{false, "South door is locked"};
				}
				break;
			case "east" :
				if (currentLoc.isEast() && (!(currentLoc.getEast() instanceof LockedDoor) || !((LockedDoor) currentLoc.getEast()).isLocked()))
				{
					currentPlayer.move(currentLoc.getEast().getDestination());
					return new Object[]{true, "You Enter : " + currentPlayer.getMapHero().getName()};
				}
				else if (!currentLoc.isEast())
				{
					return new Object[]{false, "Impossible to go east"};
				}
				else if (((LockedDoor) currentLoc.getEast()).isLocked())
				{
					return new Object[]{false, "East door is locked"};
				}
				break;
			case "west" :
				if (currentLoc.isWest() && (!(currentLoc.getWest() instanceof LockedDoor) || !((LockedDoor) currentLoc.getWest()).isLocked()))
				{
					currentPlayer.move(currentLoc.getWest().getDestination());
					return new Object[]{true, "You Enter : " + currentPlayer.getMapHero().getName()};
				}
				else if (!currentLoc.isWest())
				{
					return new Object[]{false, "Impossible to go west"};
				}
				else if (((LockedDoor) currentLoc.getWest()).isLocked())
				{
					return new Object[]{false, "West door is locked"};
				}
				break;

				/*
			case "shop" : //entre magasin
				if (currentLoc.isShop()) {
					currentPlayer.move(currentLoc.getShop().getDestination());
					System.out.println("You Enter : " + currentPlayer.getMapHero().getName() + "\n" + currentPlayer.getMapHero().getDescription());}
				else { System.out.println("There is no shop"); }
				break;
			case "back", "out" : //sort du magasin
				if (currentLoc instanceof Shop) {
					currentPlayer.move(((Shop) currentLoc).getExitShop());
					System.out.println("Xavier [Marchand] :\"Goodbye Hero.\"");
					System.out.println("You Enter : " + currentPlayer.getMapHero().getName() + "\n" + currentPlayer.getMapHero().getDescription());
				}
				else { System.out.println("You cannot exit current location"); }
				break;

				 */
			default :
				return new Object[]{false, "You can't go there"};
		}
		return new Object[]{false, "You can't go there"};
	}

	public void actionHelp() { //affiche les commandes dispo
		if (isFighting){
			System.out.println(" ----------------------------------------- Available actions : ATTACK DEFEND USE + item QUIT-----------------------------------------");
		}
		else{
			System.out.println(" -----------------------------------------  Available actions : LOOK + location(here), inventory, stat, potion, enemy, npc, equipment, ground, money or shop(if in a shop) LOOK ITEM + item TALK + name GO + direction(cardinal points, shop if available and back to leave the shop) TAKE + item USE + item REMOVE + item FIGHT BUY ITEM + name of the item you want to buy BUY POTION + name of the potion you want to buy SELL + name of the item you want to sell QUIT ----------------------------------------- ");
		}
	}


	public void actionLook(String item) { //permet de partager l'intel du personnage avec le joueur
		WorldIHM currentGame = this.CURRENT_GAME;

		switch (item.toLowerCase()) {
			case "here" : System.out.println(currentGame.getMapDescription()); //affiche description de la map sur laquelle le joueur est présent
				break;
			case "inventory" : currentGame.player.printInventory(); //affiche inventaire du joueur
				break;
			case "stat" : System.out.println("Player : " + currentGame.player.getName() + " : " + currentGame.player.getHealth() + " HP, " + currentGame.player.getAttack() + " att, "+ currentGame.player.getDefense() + " def." ); //affiche les stats du joueur
				break;
			case "potion" : System.out.println(currentGame.player.getNbPotion()); //nombre de potion détennues
				break;
			case "enemy" : System.out.println(currentGame.player.getMapHero().getEnemiesList()); //liste des ennemies
			break;
			case "npc" :  System.out.println(currentGame.player.getMapHero().getNpcsList()); // liste des pnj
				break;
			case "equipment" : currentGame.player.showEquipement(); //équipement du joueur
				break;
			case "shop" : if( currentGame.player.getMapHero() instanceof Shop){ //inventaire du shop
					Shop shop = (Shop) currentGame.player.getMapHero();
					System.out.println("This is what we have :");

					System.out.println(" ----------- |  item   | ----------- ________________________________________________");
					shop.printItems();
					System.out.println(" ------------- |  potion   | -------------________________________________________________ ");
					shop.printPotions();
					System.out.println("________________________________________________");
				}
				else{System.out.println("You're not in a shop.");}
				break;
			case "money" : System.out.println(currentGame.player.getStatistics().getMoney()); //argent
				break;
			case "ground" : System.out.println(currentGame.player.getMapHero().getGroundItemsList()); //objet sur le sol
				break;
			default : System.out.println("You can't look at this");
				break;
		}
	}

	public void actionLookItem(String lookedAt){ //affiche la description d'un item
		Item item = this.CURRENT_GAME.player.getItem(lookedAt);
		if(item != null)
			System.out.println(item.getDescription());
	}

	public void actionTake(String item) { //récupere un objet sur le sol
		WorldIHM currentGame = this.CURRENT_GAME;

		Item takeItem = currentGame.player.getMapHero().takeItem(item);
		if(takeItem != null){
			currentGame.player.addInventory(takeItem);
		}
		else{
			System.out.println("Nothing to take.");
		}
	}

	public void actionTalk(String name, TalkController talk){ //lance le dialogue d'un pnj
		Player p = this.CURRENT_GAME.player;
                
		if ( p.getMapHero().getNpc(name) != null ){      // vérifie si l'entité est bien un pnj
			talk.setDescription(p.getMapHero().getNpc(name).getDialog()); // récupére et affiche son dialogue


			if ( ((name.equals("crazy man")|| name.equals("samuel")) && p.getMapHero().getNpc(name).getItem() != null )    //vérifie le pnj si c'est  le crazy_man ou samuel deux pnj qui donne des items et on vérifie si ils ont déjà pas donnée les items
			) {

				Item objet_pnj = p.getMapHero().getNpc(name).getItem();
                                talk.setDescription("You obtain " + objet_pnj.getName() + ".");
                                p.getMapHero().getNpc(name).removeItem();
				p.addInventory(objet_pnj);
			}
		}
		else {
			System.out.println("Wrong name");
		}
	}

	public void actionQuit() { System.exit(0); } //ferme le jeu


	public void actionUse(String item) { //utilise une potion ou équipe un item
		WorldIHM currentGame = this.CURRENT_GAME;

		final String UNUSABLE = "You can't use that right now";
		switch (item) {
			case "health_potion" :
			System.out.println("You drink a health potion.");
				currentGame.player.useHealthPotion(); 
				break;
			case "attack_potion" :
				if(isFighting) {
					System.out.println("You drink an attack potion.");
					currentGame.player.useAttackPotion();
					}
				else{
					System.out.println(UNUSABLE);
				}
				break;
				
			case "defense_potion" :
				if(isFighting) {
					System.out.println("You drink a defense potion.");
					currentGame.player.useDefensePotion();
				}
				else{
					System.out.println(UNUSABLE);
					}
				break;
			case "crit_potion" :
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

	public void actionRemove(String item) { //déséquipe un item
		WorldIHM currentGame = this.CURRENT_GAME;

		if (currentGame.player.hasItem(item) ) {

			currentGame.player.removeEquipment(currentGame.player.getItem(item));

		}
		else{

			System.out.println("You can't remove this.");
		}
	}


	public void actionEquip(String name_item){ //équipe un item et déséquipe le précédant et vérifie si c'est un item
		WorldIHM currentGame = this.CURRENT_GAME;

		Item item = currentGame.player.getItem(name_item);

		if( item != null ){
			currentGame.player.addEquipment(item);
		}
		else{
			System.out.println("It's not an item.");
		}
	}

	public void actionFight() { //vérifie si il y a des enemies et lance le combat si oui

		if(this.CURRENT_GAME.player.getMapHero().getEnemies().isEmpty()){
			System.out.println("There are no enemies here");
		}
		else{
			startFight(); 
		}
	}

	public void startFight() { // lance et gère le dérouler du combat
		WorldIHM currentGame = this.CURRENT_GAME;
		isFighting = true;
		this.fight = new Fight(currentGame.player);
		int turnCounter = 0;
		while(fight.stillFighting() == 0){ //pendant le combat
			System.out.println("Turn " + turnCounter + "\n");
			fight.printPlayerStats();
			fight.printEnemiesStats();

			getAction();			
			fight.enemyAttack();
			fight.remEnemyDeath();
			turnCounter++;
		}
		if(fight.stillFighting() == 1){ //si le joueur est mort
			//System.out.println("You are dead\n");
			//actionQuit();
		}
		if(fight.stillFighting() == 2){ //si il n'y a plus d'enemi en face
			System.out.println("You have won this fight\n");
			endFight();
			currentGame.player = fight.getPlayerPostFight();
		}
	}

	public void endFight() { //met isFighting a false
		isFighting = false;
	}

	public void actionBuyItem(String item) { //achete un item


		this.CURRENT_GAME.player.buyItem(item.toLowerCase());
	}

	public void actionBuyPotion(String potion) { //achete une potion

		this.CURRENT_GAME.player.buyPotion(potion.toLowerCase());

	}

	public void actionSell(String item) { //vend un object
		this.CURRENT_GAME.player.sellItem(item.toLowerCase());
	}
}