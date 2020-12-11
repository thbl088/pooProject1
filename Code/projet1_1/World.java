import Items.Armor;
import Items.Item;
import Items.Weapon;
import Locations.*;
import Characters.*;
import Doors.*;
import Stats.StatisticsEnemy;

import java.util.HashMap;
import java.util.Scanner;

public class World {

	private HashMap<String, Map> maps;
	public Player player;
	private int numberMap = 22;

	public String getMapDescription(){
		return this.player.getMapHero().getDescription();
	}

	public void addMap(Map newMap){
		maps.put(newMap.getName(), newMap);
	}

	public World() {
		player = new Player("José");
		this.maps = new HashMap<>();
	}

	public String[] nameMap(){

		String[] dataName = new String[23];
		
		dataName[0] = "Ship";
		dataName[1] = "Crash Site";
		dataName[2] = "Village Bonville";
		dataName[3] = "End Portal";
		dataName[4] = "Barracks";
		dataName[5] = "Forest North";
		dataName[6] = "Slender's Woods";
		dataName[7] = "Forest West";
		dataName[8] = "Forest";
		dataName[9] = "Skatepark";
		dataName[10] = "Forest South";
		dataName[11] = "Beehdow";
		dataName[12] =	"Daltons Rooms";
		dataName[13] =	"Four Seasons Meadow";
		dataName[14] =	"Meadow";
		dataName[15] =	"Ravenholm";
		dataName[16] =	"Enter Stone Quarry";
		dataName[17] = "Garage";
		dataName[18] =	"Enter Lac Colère";
		dataName[19] =	"Lac Colère";
		dataName[20] =	"The Big Red Fish";
		dataName[21] =  "Fighting Gold";
		dataName[22] =  "NetBeans";

		return dataName;
	}

	public String[] descriptionMap(){

		String[] dataDescription =  new String[23];
		
		dataDescription[0] = "You are in your ship, you can see at the north your crash site.";
		dataDescription[1] = "The ground is red, the Sky is blue, your ship is blocked by a huge rock in the south and you see a village in the north.";
		dataDescription[2] = "You are in a big village. You can see the mayor and a shop. At the north, there is a big door, at the south the crash site, at the west a forest and at the east a meadow.";
		dataDescription[3] = "You are in front of a huge door made of steel, you can see 2 round holes in it, one of 5 centimeters and one of 20 centimeters. There is also a crazy man who is shouting at you. At the north, there is the closed huge door, at the south the village, at the east a stone quarry.";
		dataDescription[4] = "You are in front of a huge tank in the south there is the big door.";
		dataDescription[5] = "You are in the north forest. You can see a hard pen hiding behind a tree. At the west is the deep wood, at the south the edge forest.";
		dataDescription[6] = "You are in the deeper part of the forest. you can see in a skylight a cube with hearths on the side. At the south is the west forest, at the east the north forest.";
		dataDescription[7] = "You are in the west forest. You can see a feather pencil. At the north is the deep wood, at the south a skatepark.";
		dataDescription[8] = "You are at the edge of the forest. You can see a tender pen monster in a bush. At the north there is the north forest, at the south the south forest, and at the east the village.";
		dataDescription[9] = "You are in a skatepark. You can see a giant skateboard in front of you. In the north there is the west forest, at the east the south forest.";
		dataDescription[10] = "You are in the south forest. In the north, there is the west forest, at the west the skatepark.";
		dataDescription[11] = "You are in a sheepfold, you see a shepherdess and a sheep’s herd. At the north, there is the meadow, at the east the plain.";
		dataDescription[12] = "You are in a plain and you are seeing 4 pens of different heights align from the tallest to the taller. At the north there is the 4 colors meadow, at the west is the sheepfold, at the east the lakeside.";
		dataDescription[13] = "You are in a 4 colors meadow. A 4 colored pen is at the center of it. At the north there is the mining town, at the south the plain, at the west  the meadow and at the east the entrance from the lake.";
		dataDescription[14] = "You are in a meadow. You are seeing an alcoholic man staggering with a bottle in his hand yelling for no reason. At the north, there is a stone quarry, at the south a sheepfold, at the west the city and at the east the 4 colors meadow.";
		dataDescription[15] = "You are in a mining town. You can see a man near the entrance to the mine and a pickaxe next to him. At the south the 4 colors meadow, at the west a stone quarry, and the east a garage.";
		dataDescription[16] = "You are near the entrance to the stone quarry. At the south the meadow, at the west the huge door and, east the mining town.";
		dataDescription[17] = "You are in a garage, facing a car. At the west the mining town and the south the enter from the lake";
		dataDescription[18] = "You are at the enter from the lake. At the north there is the garage, at the south the lake, at the west the 4 colors meadow.";
		dataDescription[19] = "You are at the lakeside. You are seeing a fisher trying to catch something. At the west the plain and you think you can jump into the lake.";
		dataDescription[20] = "You are in the lake. In front of you a red Leviathan ready to eat you. You can leave the lake in the north.";
		dataDescription[21] = "You have walked through the continuum of space-time and found a golden pen guarding a cave at the east.";
		dataDescription[22] = "Inside the cave you are seeing a young man who seems to possess all the knowledge of this world. With an object in front of him. You can leave this place in the west.";

		return dataDescription;
	}

	public Map[] createTiles(){
		Map[] tiles = new Map[23];

		for(int i = 0 ; i < numberMap ; i++){

			Map map = new Map();
			tiles[i] = map ;

		}

		return tiles;
	}

	public  void addnameMap(String[] name, Map[] map ,String[] description){

		for(int  i = 0 ; i < name.length ; i++ ){
			map[i] = new Map();
			map[i].changeName(name[i]);
			map[i].setDescription(description[i]);
			maps.put(name[i], map[i]);
		}
		
		Shop shop = new Shop();
		maps.put("Shop", shop);
	}

	public Enemy[] createAllEnemies(){
		Enemy[] enemies = new Enemy[16];

		// Map 4 Dernier Boss
		StatisticsEnemy statsLeclerc = new 	StatisticsEnemy( 100 , 50 , 60 , 15, 80);
		Item crik = new Item("Jack", "Useful for lifting heavy stones.", -1);
		Enemy leclerc = new Enemy("Leclerc" , crik, statsLeclerc);

		enemies[0] = leclerc;

		// Map 5 Crayon trés dur
		StatisticsEnemy stats9H = new 	StatisticsEnemy( 5 , 1 , 15 , 5);
		Enemy crayon9H = new Enemy("9H" , stats9H);

		enemies[1] = crayon9H;

		// Map 7 Stylo Plume

		StatisticsEnemy statsStyloPlume = new 	StatisticsEnemy( 20 , 15 , 20 , 20);
		Enemy styloPLume = new Enemy("Cartier" ,statsStyloPlume);

		enemies[2] = styloPLume;

		// Map 8 Robot Crayon tendre

		StatisticsEnemy statsRobcrayontendre = new 	StatisticsEnemy( 5 , 15 , 1 , 5);
		Enemy robcrayontendre = new Enemy("9B" ,statsRobcrayontendre);
		
		enemies[3] = robcrayontendre;

		// Map 9 Boss Tony

		StatisticsEnemy statsTony = new StatisticsEnemy( 20 , 30 , 20 , 5);
		Item littleWheel = new Item("Little Wheel", "It's a shining skateboard wheel", -1);
		Enemy tony = new Enemy("Tony", littleWheel,statsTony);
				
		enemies[4] = tony;

		// Map 12  [3 Criterium]

		StatisticsEnemy statsCriterium = new StatisticsEnemy( 1 , 8 , 2 , 100 , 5);
		Enemy criterium2mm = new Enemy("2mm" ,statsCriterium);
		Enemy criterium5mm = new Enemy("5mm" ,statsCriterium);
		Enemy criterium7mm = new Enemy("7mm" ,statsCriterium);

		enemies[5] = criterium2mm;
		enemies[6] = criterium5mm;
		enemies[7] = criterium7mm;

		// Map  13 Bicolor

		StatisticsEnemy statsBic = new 	StatisticsEnemy( 20 , 16 , 12 , 20);
		Enemy bicolor = new Enemy("Bicolor",statsBic);
				
		enemies[8] = bicolor;

		// Map  14 Robert l'alcoolo 

		StatisticsEnemy statsRobert = new 	StatisticsEnemy( 5 , 5 , 5 , 2);
		Weapon bottle = new Weapon("Bottle", "It's a bottle.", 2, 1);
		Enemy robert = new Enemy("Robert",bottle ,statsRobert);
						
		enemies[9] = robert;

		// Map  16 robot crayon HB

		StatisticsEnemy statsHB = new StatisticsEnemy( 10 , 10 , 10 , 10);
		Enemy hB = new Enemy("hB",statsHB);
				
		enemies[10] = hB;

		// Map  17 Boss Twingy

		StatisticsEnemy statsTwingy = new StatisticsEnemy( 20 , 20 , 20 , 20);
		Item carwheel = new Item("CarWheel","It's a glowing car wheel.", -1);
		Enemy twingy = new Enemy("Twingy",carwheel ,statsTwingy);
				
		enemies[11] = twingy;

		// Map  18 Les frères crayons 2B crayon tendre et 2H crayon dur

		Enemy crayon2B = new Enemy("2B",statsRobcrayontendre);
		Enemy crayon2H = new Enemy("2H",stats9H);
				
		enemies[12] = crayon2B;
		enemies[13] = crayon2H;

		// Map  20 Le Léviathan

		StatisticsEnemy statsLeviathan = new StatisticsEnemy( 15 , 15 , 15 , 20);
		Weapon redfish = new Weapon("Léviathan", "The big red fish.", 50, 15);
		Enemy leviathan = new Enemy("Bicolor",redfish ,statsLeviathan);
						
		enemies[14] = leviathan;

		// Map  21 Le crayon d'oré

		StatisticsEnemy statsCrayondore = new StatisticsEnemy( 1 , 1 , 9999999 , 100 , 200);
		Enemy crayonDore = new Enemy("Crayon D'oré", statsCrayondore);
								
		enemies[15] = crayonDore;

		return enemies;
	}

	public Item[] initItemInGround(){
		Item[] ground = new Item[10];

		ground[0] = new Weapon("Pickaxe", "A pickaxe hard enough to mine netherite.", 12, 5);
		ground[1] = new Weapon("Rock", "It's rock like Malphite.", 2 , 2 );
		ground[2] = new Weapon( "Fish", "A smelly fish.", 6 , 4);
		ground[3] = new Weapon( "Fish", "A smelly fish.", 6 , 4);
		ground[4] = new Item("Sheep wool", "This wool is so soft.", 10);
		ground[5] = new Item("Sheep wool", "This wool is so soft.", 10);
		ground[6] = new Item("Companion Cube", "A cube with pink heart on the side.", 60);
		ground[7] = new Item("Package", "A package which contains a nvidia geforce 3080." , 20);
		ground[8] = new Item("Package", "A package which contains a nvidia geforce 3080." , 20);
		ground[9] = new Weapon( "Reactor", "This is the key to get out of here.", -1 , 5);
		
		return ground;
	}

	public void addItemMap(Item[]ground,String[] namemap){

		// Ajout des Ennemis dans les Hashmap de leur map
		maps.get(namemap[4]).addItem(ground[9]);
		maps.get(namemap[6]).addItem(ground[6]);
		maps.get(namemap[10]).addItem(ground[7]);
		maps.get(namemap[10]).addItem(ground[8]);
		maps.get(namemap[11]).addItem(ground[4]);
		maps.get(namemap[11]).addItem(ground[5]);
		maps.get(namemap[15]).addItem(ground[1]);
		maps.get(namemap[15]).addItem(ground[0]);
		maps.get(namemap[19]).addItem(ground[2]);
		maps.get(namemap[19]).addItem(ground[3]);
		


	}

	public  void addEnnmiesMap(Enemy[] tabEnemies,String[] namemap){

		// Ajout des Ennemis dans les Hashmap de leur map
		maps.get(namemap[4]).addEnemy(tabEnemies[0]);
		maps.get(namemap[5]).addEnemy(tabEnemies[1]);
		maps.get(namemap[7]).addEnemy(tabEnemies[2]);
		maps.get(namemap[8]).addEnemy(tabEnemies[3]);
		maps.get(namemap[9]).addEnemy(tabEnemies[4]);
		maps.get(namemap[12]).addEnemy(tabEnemies[5]);
		maps.get(namemap[12]).addEnemy(tabEnemies[6]);
		maps.get(namemap[12]).addEnemy(tabEnemies[7]);
		maps.get(namemap[13]).addEnemy(tabEnemies[8]);
		maps.get(namemap[14]).addEnemy(tabEnemies[9]);
		maps.get(namemap[16]).addEnemy(tabEnemies[10]);
		maps.get(namemap[17]).addEnemy(tabEnemies[11]);
		maps.get(namemap[18]).addEnemy(tabEnemies[12]);
		maps.get(namemap[18]).addEnemy(tabEnemies[13]);
		maps.get(namemap[20]).addEnemy(tabEnemies[14]);
		maps.get(namemap[21]).addEnemy(tabEnemies[15]);

	}

	public void initDoorMap(String[] namemap){
		// map 0
		maps.get(namemap[0]).setNorth(new Door(maps.get(namemap[1])));

		// map 1
		LockedDoor finDoor = new LockedDoor(maps.get(namemap[0]));
		maps.get(namemap[1]).setNorth(new Door(maps.get(namemap[2])));
		maps.get(namemap[1]).setSouth(finDoor);
		

		//map 2 
		maps.get(namemap[2]).setNorth(new Door(maps.get(namemap[3])));
		maps.get(namemap[2]).setEast(new Door(maps.get(namemap[14])));
		maps.get(namemap[2]).setSouth(new Door(maps.get(namemap[1])));
		maps.get(namemap[2]).setWest(new Door(maps.get(namemap[8])));
		maps.get(namemap[2]).setShop();

		//map 3
		LockedDoor finalBossDoor = new LockedDoor(maps.get(namemap[4]));
		maps.get(namemap[3]).setNorth(finalBossDoor);
		maps.get(namemap[3]).setEast(new Door(maps.get(namemap[16])));
		maps.get(namemap[3]).setSouth(new Door(maps.get(namemap[2])));
		maps.get(namemap[3]).setWest(new Door(maps.get(namemap[5])));

		//map 4
		maps.get(namemap[4]).setSouth(new Door(maps.get(namemap[3])));

		//map 5
		maps.get(namemap[5]).setEast(new Door(maps.get(namemap[3])));
		maps.get(namemap[5]).setSouth(new Door(maps.get(namemap[8])));
		maps.get(namemap[5]).setWest(new Door(maps.get(namemap[6])));

		//map 6
		maps.get(namemap[6]).setEast(new Door(maps.get(namemap[5])));
		maps.get(namemap[6]).setSouth(new Door(maps.get(namemap[7])));

		//map 7
		maps.get(namemap[7]).setNorth(new Door(maps.get(namemap[6])));
		maps.get(namemap[7]).setEast(new Door(maps.get(namemap[8])));
		maps.get(namemap[7]).setSouth(new Door(maps.get(namemap[9])));

		//map 8
		maps.get(namemap[8]).setNorth(new Door(maps.get(namemap[5])));
		maps.get(namemap[8]).setEast(new Door(maps.get(namemap[2])));
		maps.get(namemap[8]).setSouth(new Door(maps.get(namemap[10])));
		maps.get(namemap[8]).setWest(new Door(maps.get(namemap[7])));

		//map 9
		maps.get(namemap[9]).setNorth(new Door(maps.get(namemap[7])));
		maps.get(namemap[9]).setEast(new Door(maps.get(namemap[10])));

		//map 10 
		maps.get(namemap[10]).setNorth(new Door(maps.get(namemap[8])));
		maps.get(namemap[10]).setWest(new Door(maps.get(namemap[9])));

		//map 11
		maps.get(namemap[11]).setNorth(new Door(maps.get(namemap[14])));
		maps.get(namemap[11]).setEast(new Door(maps.get(namemap[12])));
		
		//map 12
		maps.get(namemap[12]).setNorth(new Door(maps.get(namemap[13])));
		maps.get(namemap[12]).setEast(new Door(maps.get(namemap[19])));
		maps.get(namemap[12]).setWest(new Door(maps.get(namemap[11])));

		//map 13
		maps.get(namemap[13]).setNorth(new Door(maps.get(namemap[15])));
		maps.get(namemap[13]).setEast(new Door(maps.get(namemap[18])));
		maps.get(namemap[13]).setSouth(new Door(maps.get(namemap[12])));
		maps.get(namemap[13]).setWest(new Door(maps.get(namemap[14])));

		//map 14
		maps.get(namemap[14]).setNorth(new Door(maps.get(namemap[16])));
		maps.get(namemap[14]).setEast(new Door(maps.get(namemap[13])));
		maps.get(namemap[14]).setSouth(new Door(maps.get(namemap[11])));
		maps.get(namemap[14]).setWest(new Door(maps.get(namemap[2])));

		//map 15
		maps.get(namemap[15]).setEast(new Door(maps.get(namemap[17])));
		maps.get(namemap[15]).setSouth(new Door(maps.get(namemap[13])));
		maps.get(namemap[15]).setWest(new Door(maps.get(namemap[16])));

		//map 16
		maps.get(namemap[16]).setEast(new Door(maps.get(namemap[15])));
		maps.get(namemap[16]).setSouth(new Door(maps.get(namemap[14])));
		maps.get(namemap[16]).setWest(new Door(maps.get(namemap[3])));

		//map 17
		maps.get(namemap[17]).setSouth(new Door(maps.get(namemap[18])));
		maps.get(namemap[17]).setWest(new Door(maps.get(namemap[15])));

		//map 18
		maps.get(namemap[18]).setNorth(new Door(maps.get(namemap[17])));
		maps.get(namemap[18]).setEast(new Door(maps.get(namemap[21])));
		maps.get(namemap[18]).setSouth(new Door(maps.get(namemap[19])));
		maps.get(namemap[18]).setWest(new Door(maps.get(namemap[13])));

		//map 19
		maps.get(namemap[19]).setNorth(new Door(maps.get(namemap[18])));
		maps.get(namemap[19]).setSouth(new Door(maps.get(namemap[20])));
		maps.get(namemap[19]).setWest(new Door(maps.get(namemap[12])));

		//map20
		maps.get(namemap[20]).setNorth(new Door(maps.get(namemap[19])));

		//map 21
		maps.get(namemap[21]).setEast(new Door(maps.get(namemap[22])));
		maps.get(namemap[21]).setWest(new Door(maps.get(namemap[18])));

		//map 22
		maps.get(namemap[22]).setWest(new Door(maps.get(namemap[21])));
	}
	
	public Npc[] initNpc(){

		Npc[] village = new Npc[11];

		village[0] = new Npc("Mayor", null,"Henry [Mayor] : “Welcome "+ this.player.getName() + " as I can see on your suit, I have seen you falling from the sky. I’m sure you’re the man of the prophecy. I’m sure you will find what you need behind the door behind me. But before that you’ll need to find the 2 objects needed to open the door. If you need help you can ask our merchant, he should have some object useful for you.”" );
		village[1] = new Npc("Villager", null, "Josette [Villager] : “Hello there. The weather is nice, isn’t it?”");
		village[2] = new Npc("Children", null,"Loïc Choulet [Children] : “Do you have a SolidWorks license?”" );
		Item tankTrack = new Item("Tank Track", "This chariot caterpillar is shining.", -1);
		village[3] = new Npc("Crazy man",tankTrack, "Mark [Crazy man] : “HEY YOU! I have found this big thing around, I was trying to sleep on it but it’s too hard so take it!”");
		village[4] = new Npc("Factor", null,"Sebastien [Factor] : “I need to deliver those important packages but those monsters block the road.”" );
		village[5] = new Npc("Shepherdess", null,"Anne [Shepherdess] : “Sometimes I found weird trace on the earth around my herd and a big ball appear.”" );
		village[6] = new Npc("Alcoholic", null,"Robert [alcoholic]: “BEURGHHHH.”" );
		village[7] = new Npc("Miner", null,"José [Miner] : “I hope I’ll found diamond this time but there is too much lava down there.”" );
		village[8] = new Npc("Lumberjack", null,"Franck [Lumberjack] :“Thank you a lot now I can go back see my wife Josette.”" );
		village[9] = new Npc("Fisher", null,"Hena [Fisher] : “I hope I’ll catch this big fish this time.”" );
		Weapon grabage = new Weapon("Garbage Collector", "This weapon allows to put any entity to state null.", -1, 99999999);
		village[10] = new Npc("Samuel", grabage,"Samuel : “Congratulation for looking at the game file for founding this area. Take this The Garbage Collector.”" );

		return village;
	}

	public void implentNpc(String[]namemap , Npc[] pnj){

		maps.get(namemap[2]).addNpc(pnj[0]);
		maps.get(namemap[2]).addNpc(pnj[1]);
		maps.get(namemap[2]).addNpc(pnj[2]);
		maps.get(namemap[3]).addNpc(pnj[3]);
		maps.get(namemap[18]).addNpc(pnj[4]);
		maps.get(namemap[11]).addNpc(pnj[5]);
		maps.get(namemap[14]).addNpc(pnj[6]);
		maps.get(namemap[16]).addNpc(pnj[7]);
		maps.get(namemap[18]).addNpc(pnj[8]);
		maps.get(namemap[19]).addNpc(pnj[9]);
		maps.get(namemap[22]).addNpc(pnj[10]);
	}

	public Item[] initShopItem(){

		Item[] shop = new Item[6];
		shop[0] = new Armor("Leather Tunic","Tunic made of leather." , 12, 5);
		shop[1] = new Armor("Titanium Armour","Made with remnants of pencil robots." , 25, 20);
		shop[2] = new Armor("Nethererite Armour","Made with a coming ore Ravenholm." , 25, 20);
		shop[3] = new Weapon("Stone Sword","A sword stronger than wood.", 12, 15);
		shop[4] = new Weapon("Japanese Sword","Take the soul of your enemies.", 12, 15);
		shop[5] = new Weapon("Energie Sword","Sword recover from an old ship that once crashed here.", 70, 50);
		return shop;
	}

	public void addItemInShop(Item[]items){

		for(int i=0 ; i < items.length ; i++){

			maps.get("Shop").addItem(items[i]);

		}

	}

	public void initWorld(){

			String[] tabName = nameMap();
			String[] tabDescription = descriptionMap();
			Map[] tabMap = createTiles();
			Enemy[] tabEnemies = createAllEnemies();
			Item[]  tabItemGround = initItemInGround();
			Item[]	shopInit = initShopItem();
			Npc[]	tabNpc = initNpc();

			addnameMap(tabName, tabMap, tabDescription);  // ajout des nom au map et leurs description
			addEnnmiesMap(tabEnemies, tabName); // ajout des ennemis 
			addItemMap(tabItemGround, tabName);	// ajout des items
			addItemInShop(shopInit);       // ajout de la banque d 'item dans le shop
			implentNpc(tabName, tabNpc);   // ajout des pnj
			initDoorMap(tabName);		// Chaque map coté ses porte 

			initPlayer(tabName);  // Joueur crée

	}

	public void initPlayer(String[] namemap){
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your name : ");
		String name = keyboard.nextLine();
		Player hero = new Player(name);
		this.player = hero;
		System.out.println("Welcome "+ hero.getName() +".");
		System.out.println("Your ship has crashed and you need a jack and a new motor to leave this planet.");
		hero. move(maps.get(namemap[0]));
		System.out.println("You Enter : "+this.player.getMapHero().getName() + ".");
		System.out.println(this.player.getMapHero().getDescription());

		
	}

	public int play(ActionManager action){


		action.getAction();
		

		if( this.player.getHealth() <= 0 ){

			return -1;
		}
		else if( this.player.finish() == 1 ) {

			return 1;
		}
		else{

			return 0;
		}
	}

	public static void main(String[] args){
		int finish = 0 ;
		World monde = new World();
		monde.initWorld();

		ActionManager action  = new ActionManager();

		// ------------------------ INTRODUCTION -----------------------------------


		while ( finish == 0){

			finish = monde.play(action);

		}

		action.scanner.close();

		// ------------------------ Fin du jeu -----------------------------------

		if(finish == 1 ){

			System.out.println("Congratulations you have escaped the planet and saved everyone on it.\n ✶ ✶ ✶ ✶ ✶ ✶ ✶ ✶ ✶\n Thanks playing my video games.");
			System.out.println("        Credit      \nBoue Alexis\nLuneteau Thomas\nVialle Charlie");
		}
		else{

			System.out.println("☠ You Die. ☠");

		}
	}
}