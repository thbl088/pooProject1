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

	private final HashMap<String, Map> MAPS;
	public Player player;

	public String getMapDescription(){
		return this.player.getMapHero().getDescription();
	}

	

	public World() {
		this.MAPS = new HashMap<>();
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
		dataName[12] =	"Dalton's Rooms";
		dataName[13] =	"Four Seasons Meadow";
		dataName[14] =	"Meadow";
		dataName[15] =	"Ravenholm";
		dataName[16] =	"Enter Stone Quarry";
		dataName[17] = "Garage";
		dataName[18] =	"Enter Lake Colère";
		dataName[19] =	"Lake Colère";
		dataName[20] =	"The Big Red Fish";
		dataName[21] =  "Fighting Gold";
		dataName[22] =  "NetBeans";

		return dataName;
	}

	public String[] descriptionMap(){
		String[] dataDescription =  new String[23];
		
		dataDescription[0] = "You are in your ship, you can see in the north your crash site.";
		dataDescription[1] = "The ground is red, the Sky is blue, your ship is blocked by a huge rock in the south and you see a village in the north.";
		dataDescription[2] = "You are in a big village. You can see the mayor and a shop. In the north, there is a big door, in the south the crash site, in the west a forest and in the east a meadow.";
		dataDescription[3] = "You are in front of a huge door made of steel, you can see 2 round holes in it, one 5 centimeters and one of 20 centimeters. There is also a crazy man shouting at you. In the north, there is the huge closed door, in the south the village, in the east a stone quarry.";
		dataDescription[4] = "You are in front of a huge tank, in the south there is the big door.";
		dataDescription[5] = "You are in the north forest. You can see a hard pen hiding behind a tree. In the west is the deep wood, in the south the edge of the forest.";
		dataDescription[6] = "You are in the deeper part of the forest. you can see in a skylight a cube with hearths on the side. At the south is the west forest, at the east the north forest.";
		dataDescription[7] = "You are in the west forest. You can see a feather pencil. At the north is the deep wood, at the south a skatepark and at the east the forest.";
		dataDescription[8] = "You are at the edge of the forest. You can see a tender pen monster in a bush. At the north there is the north forest, at the south the south forest, at the west the west forest and at the east the village.";
		dataDescription[9] = "You are in a skatepark. You can see a giant skateboard in front of you. In the north there is the west forest, at the east the south forest.";
		dataDescription[10] = "You are in the south forest. You see a factor with packages around him on the ground. In the north, there is the west forest, at the west the skatepark.";
		dataDescription[11] = "You are in a sheepfold, you see a shepherdess and a sheep’s herd. At the north, there is the meadow, at the east the plain.";
		dataDescription[12] = "You are in a plain and you are seeing 4 pens of different heights align from the tallest to the taller. At the north there is the 4 colors meadow, at the west is the sheepfold, at the east the lakeside.";
		dataDescription[13] = "You are in a 4 colors meadow. A 4 colored pen is at the center of it. At the north there is the mining town, at the south the plain, at the west  the meadow and at the east the entrance from the lake.";
		dataDescription[14] = "You are in a meadow. You are seeing an alcoholic man staggering with a bottle in his hand yelling for no reason. At the north, there is a stone quarry, at the south a sheepfold, at the west the city and at the east the 4 colors meadow.";
		dataDescription[15] = "You are in a mining town. You can see a man near the entrance to the mine and a pickaxe next to him. At the south the 4 colors meadow, at the west a stone quarry, and the east a garage.";
		dataDescription[16] = "You are near the entrance to the stone quarry. A pen is hiding behind a rock. At the south the meadow, at the west the huge door and, east the mining town.";
		dataDescription[17] = "You are in a garage, facing a car. At the west the mining town and the south the enter from the lake";
		dataDescription[18] = "You are at the enter from the lake. 2 pens are attacking a man. At the north there is the garage, at the south the lake, at the west the 4 colors meadow.";
		dataDescription[19] = "You are at the lakeside. You are seeing a fisher trying to catch something. At the west the plain and you think you can jump into the lake.";
		dataDescription[20] = "You are in the lake. In front of you a red Leviathan ready to eat you. You can leave the lake in the north.";
		dataDescription[21] = "You have walked through the continuum of space-time and found a golden pen guarding a cave at the east.";
		dataDescription[22] = "Inside the cave you are seeing a young man who seems to possess all the knowledge of this world. With an object in front of him. You can leave this place in the west.";

		return dataDescription;
	}

	public Map[] createTiles(){
		Map[] tiles = new Map[23];

		for(int i = 0 ; i < tiles.length ; i++){
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
			this.MAPS.put(name[i], map[i]);
		}
	}

	public Enemy[] createAllEnemies(){
		Enemy[] enemies = new Enemy[17];

		// Map 4 Dernier Boss
		StatisticsEnemy statsLeclerc = new 	StatisticsEnemy( 100 , 50 , 60 , 15, 80);
		Item crik = new Item("jack", "Useful for lifting heavy stones.", -1);
		Enemy leclerc = new Enemy("leclerc" , crik, statsLeclerc);

		enemies[0] = leclerc;

		// Map 5 Crayon trés dur
		StatisticsEnemy stats9H = new 	StatisticsEnemy( 5 , 1 , 15 , 5);
		Enemy crayon9H = new Enemy("9h" , stats9H);

		enemies[1] = crayon9H;

		// Map 7 Stylo Plume

		StatisticsEnemy statsStyloPlume = new 	StatisticsEnemy( 20 , 15 , 20 , 20);
		Enemy styloPLume = new Enemy("cartier" ,statsStyloPlume);

		enemies[2] = styloPLume;

		// Map 8 Robot Crayon tendre

		StatisticsEnemy statsRobcrayontendre = new 	StatisticsEnemy( 5 , 15 , 1 , 5);
		Enemy robcrayontendre = new Enemy("9b" ,statsRobcrayontendre);
		
		enemies[3] = robcrayontendre;

		// Map 9 Boss Tony

		StatisticsEnemy statsTony = new StatisticsEnemy( 20 , 30 , 20 , 5);
		Item littleWheel = new Item("little_wheel", "It's a shining skateboard wheel", -1);
		Enemy tony = new Enemy("tony", littleWheel,statsTony);
				
		enemies[4] = tony;

		// Map 12  [4 Criterium]

		StatisticsEnemy statsCriterium = new StatisticsEnemy( 1 , 8 , 2 , 100 , 5);
		Enemy criterium2mm = new Enemy("2mm" ,statsCriterium);
		Enemy criterium5mm = new Enemy("5mm" ,statsCriterium);
		Enemy criterium7mm = new Enemy("7mm" ,statsCriterium);
		Enemy criterium9mm = new Enemy("9mm" ,statsCriterium);

		enemies[5] = criterium2mm;
		enemies[6] = criterium5mm;
		enemies[7] = criterium7mm;
		enemies[8] = criterium9mm;

		// Map  13 Bicolor

		StatisticsEnemy statsBic = new 	StatisticsEnemy( 20 , 16 , 12 , 20);
		Enemy bicolor = new Enemy("bicolor",statsBic);
				
		enemies[9] = bicolor;

		// Map  14 Robert l'alcoolo 

		StatisticsEnemy statsRobert = new 	StatisticsEnemy( 5 , 5 , 5 , 2);
		Weapon bottle = new Weapon("bottle", "It's a bottle.", 2, 1);
		Enemy robert = new Enemy("robert",bottle ,statsRobert);
						
		enemies[10] = robert;

		// Map  16 robot crayon HB

		StatisticsEnemy statsHB = new StatisticsEnemy( 10 , 10 , 10 , 10);
		Enemy hB = new Enemy("hb",statsHB);
				
		enemies[11] = hB;

		// Map  17 Boss Twingy

		StatisticsEnemy statsTwingy = new StatisticsEnemy( 20 , 20 , 20 , 20);
		Item carwheel = new Item("car_wheel","It's a glowing car wheel.", -1);
		Enemy twingy = new Enemy("twingy",carwheel ,statsTwingy);
				
		enemies[12] = twingy;

		// Map  18 Les frères crayons 2B crayon tendre et 2H crayon dur

		Enemy crayon2B = new Enemy("2b",statsRobcrayontendre);
		Enemy crayon2H = new Enemy("2h",stats9H);
				
		enemies[13] = crayon2B;
		enemies[14] = crayon2H;

		// Map  20 Le Léviathan

		StatisticsEnemy statsLeviathan = new StatisticsEnemy( 15 , 15 , 15 , 20);
		Weapon redfish = new Weapon("leviathan", "The big red fish.", 50, 15);
		Enemy leviathan = new Enemy("leviathan",redfish ,statsLeviathan);
						
		enemies[15] = leviathan;

		// Map  21 Le crayon d'oré

		StatisticsEnemy statsCrayondore = new StatisticsEnemy( 1 , 1 , 9999999 , 100 , 200);
		Enemy crayonDore = new Enemy("golden_pen", statsCrayondore);
								
		enemies[16] = crayonDore;
		return enemies;
	}

	public Item[] initItemInGround(){
		Item[] ground = new Item[10];

		ground[0] = new Weapon("pickaxe", "A pickaxe hard enough to mine netherite.", 12, 5);
		ground[1] = new Weapon("rock", "It's a rock like Malphite.", 2 , 2 );
		ground[2] = new Weapon( "fish", "A smelly fish.", 6 , 4);
		ground[3] = new Weapon( "fish", "A smelly fish.", 6 , 4);
		ground[4] = new Item("sheep wool", "This wool is so soft.", 10);
		ground[5] = new Item("sheep wool", "This wool is so soft.", 10);
		ground[6] = new Item("companion Cube", "A cube with a pink heart on the side.", 60);
		ground[7] = new Item("package", "A package which contains an Nvidia GeForce RTX™ 3080." , 20);
		ground[8] = new Item("package", "A package which contains an Nvidia GeForce RTX™ 3080." , 20);
		ground[9] = new Weapon( "reactor", "This is the key to get out of here.", -1 , 5);
		return ground;
	}

	public void addItemMap(Item[]ground,String[] namemap){
		// Ajout des Ennemis dans les Hashmap de leur map
		this.MAPS.get(namemap[4]).addItem(ground[9]);
		this.MAPS.get(namemap[6]).addItem(ground[6]);
		this.MAPS.get(namemap[10]).addItem(ground[7]);
		this.MAPS.get(namemap[10]).addItem(ground[8]);
		this.MAPS.get(namemap[11]).addItem(ground[4]);
		this.MAPS.get(namemap[11]).addItem(ground[5]);
		this.MAPS.get(namemap[15]).addItem(ground[1]);
		this.MAPS.get(namemap[15]).addItem(ground[0]);
		this.MAPS.get(namemap[19]).addItem(ground[2]);
		this.MAPS.get(namemap[19]).addItem(ground[3]);
	}

	public  void addEnnmiesMap(Enemy[] tabEnemies,String[] namemap){
		// Ajout des Ennemis dans les Hashmap de leur map
		this.MAPS.get(namemap[4]).addEnemy(tabEnemies[0]);
		this.MAPS.get(namemap[5]).addEnemy(tabEnemies[1]);
		this.MAPS.get(namemap[8]).addEnemy(tabEnemies[2]);
		this.MAPS.get(namemap[8]).addEnemy(tabEnemies[3]);
		this.MAPS.get(namemap[9]).addEnemy(tabEnemies[4]);
		this.MAPS.get(namemap[12]).addEnemy(tabEnemies[5]);
		this.MAPS.get(namemap[12]).addEnemy(tabEnemies[6]);
		this.MAPS.get(namemap[12]).addEnemy(tabEnemies[7]);
		this.MAPS.get(namemap[12]).addEnemy(tabEnemies[8]);
		this.MAPS.get(namemap[13]).addEnemy(tabEnemies[9]);
		this.MAPS.get(namemap[14]).addEnemy(tabEnemies[10]);
		this.MAPS.get(namemap[16]).addEnemy(tabEnemies[11]);
		this.MAPS.get(namemap[17]).addEnemy(tabEnemies[12]);
		this.MAPS.get(namemap[18]).addEnemy(tabEnemies[13]);
		this.MAPS.get(namemap[18]).addEnemy(tabEnemies[14]);
		this.MAPS.get(namemap[20]).addEnemy(tabEnemies[15]);
		this.MAPS.get(namemap[21]).addEnemy(tabEnemies[16]);
	}

	public void initDoorMap(String[] namemap){
		// map 0
		this.MAPS.get(namemap[0]).setNorth(new Door(this.MAPS.get(namemap[1])));

		// map 1
		LockedDoor finDoor = new LockedDoor(this.MAPS.get(namemap[0]));
		this.MAPS.get(namemap[1]).setNorth(new Door(this.MAPS.get(namemap[2])));
		this.MAPS.get(namemap[1]).setSouth(finDoor);


		//map 2
		this.MAPS.get(namemap[2]).setNorth(new Door(this.MAPS.get(namemap[3])));
		this.MAPS.get(namemap[2]).setEast(new Door(this.MAPS.get(namemap[14])));
		this.MAPS.get(namemap[2]).setSouth(new Door(this.MAPS.get(namemap[1])));
		this.MAPS.get(namemap[2]).setWest(new Door(this.MAPS.get(namemap[8])));



		//map 3
		LockedDoor finalBossDoor = new LockedDoor(this.MAPS.get(namemap[4]));
		this.MAPS.get(namemap[3]).setNorth(finalBossDoor);
		this.MAPS.get(namemap[3]).setEast(new Door(this.MAPS.get(namemap[16])));
		this.MAPS.get(namemap[3]).setSouth(new Door(this.MAPS.get(namemap[2])));
		this.MAPS.get(namemap[3]).setWest(new Door(this.MAPS.get(namemap[5])));

		//map 4
		this.MAPS.get(namemap[4]).setSouth(new Door(this.MAPS.get(namemap[3])));

		//map 5
		this.MAPS.get(namemap[5]).setEast(new Door(this.MAPS.get(namemap[3])));
		this.MAPS.get(namemap[5]).setSouth(new Door(this.MAPS.get(namemap[8])));
		this.MAPS.get(namemap[5]).setWest(new Door(this.MAPS.get(namemap[6])));

		//map 6
		this.MAPS.get(namemap[6]).setEast(new Door(this.MAPS.get(namemap[5])));
		this.MAPS.get(namemap[6]).setSouth(new Door(this.MAPS.get(namemap[7])));

		//map 7
		this.MAPS.get(namemap[7]).setNorth(new Door(this.MAPS.get(namemap[6])));
		this.MAPS.get(namemap[7]).setEast(new Door(this.MAPS.get(namemap[8])));
		this.MAPS.get(namemap[7]).setSouth(new Door(this.MAPS.get(namemap[9])));

		//map 8
		this.MAPS.get(namemap[8]).setNorth(new Door(this.MAPS.get(namemap[5])));
		this.MAPS.get(namemap[8]).setEast(new Door(this.MAPS.get(namemap[2])));
		this.MAPS.get(namemap[8]).setSouth(new Door(this.MAPS.get(namemap[10])));
		this.MAPS.get(namemap[8]).setWest(new Door(this.MAPS.get(namemap[7])));

		//map 9
		this.MAPS.get(namemap[9]).setNorth(new Door(this.MAPS.get(namemap[7])));
		this.MAPS.get(namemap[9]).setEast(new Door(this.MAPS.get(namemap[10])));

		//map 10
		this.MAPS.get(namemap[10]).setNorth(new Door(this.MAPS.get(namemap[8])));
		this.MAPS.get(namemap[10]).setWest(new Door(this.MAPS.get(namemap[9])));

		//map 11
		this.MAPS.get(namemap[11]).setNorth(new Door(this.MAPS.get(namemap[14])));
		this.MAPS.get(namemap[11]).setEast(new Door(this.MAPS.get(namemap[12])));

		//map 12
		this.MAPS.get(namemap[12]).setNorth(new Door(this.MAPS.get(namemap[13])));
		this.MAPS.get(namemap[12]).setEast(new Door(this.MAPS.get(namemap[19])));
		this.MAPS.get(namemap[12]).setWest(new Door(this.MAPS.get(namemap[11])));

		//map 13
		this.MAPS.get(namemap[13]).setNorth(new Door(this.MAPS.get(namemap[15])));
		this.MAPS.get(namemap[13]).setEast(new Door(this.MAPS.get(namemap[18])));
		this.MAPS.get(namemap[13]).setSouth(new Door(this.MAPS.get(namemap[12])));
		this.MAPS.get(namemap[13]).setWest(new Door(this.MAPS.get(namemap[14])));

		//map 14
		this.MAPS.get(namemap[14]).setNorth(new Door(this.MAPS.get(namemap[16])));
		this.MAPS.get(namemap[14]).setEast(new Door(this.MAPS.get(namemap[13])));
		this.MAPS.get(namemap[14]).setSouth(new Door(this.MAPS.get(namemap[11])));
		this.MAPS.get(namemap[14]).setWest(new Door(this.MAPS.get(namemap[2])));

		//map 15
		this.MAPS.get(namemap[15]).setEast(new Door(this.MAPS.get(namemap[17])));
		this.MAPS.get(namemap[15]).setSouth(new Door(this.MAPS.get(namemap[13])));
		this.MAPS.get(namemap[15]).setWest(new Door(this.MAPS.get(namemap[16])));

		//map 16
		this.MAPS.get(namemap[16]).setEast(new Door(this.MAPS.get(namemap[15])));
		this.MAPS.get(namemap[16]).setSouth(new Door(this.MAPS.get(namemap[14])));
		this.MAPS.get(namemap[16]).setWest(new Door(this.MAPS.get(namemap[3])));

		//map 17
		this.MAPS.get(namemap[17]).setSouth(new Door(this.MAPS.get(namemap[18])));
		this.MAPS.get(namemap[17]).setWest(new Door(this.MAPS.get(namemap[15])));

		//map 18
		this.MAPS.get(namemap[18]).setNorth(new Door(this.MAPS.get(namemap[17])));
		this.MAPS.get(namemap[18]).setEast(new Door(this.MAPS.get(namemap[21])));
		this.MAPS.get(namemap[18]).setSouth(new Door(this.MAPS.get(namemap[19])));
		this.MAPS.get(namemap[18]).setWest(new Door(this.MAPS.get(namemap[13])));

		//map 19
		this.MAPS.get(namemap[19]).setNorth(new Door(this.MAPS.get(namemap[18])));
		this.MAPS.get(namemap[19]).setSouth(new Door(this.MAPS.get(namemap[20])));
		this.MAPS.get(namemap[19]).setWest(new Door(this.MAPS.get(namemap[12])));

		//map20
		this.MAPS.get(namemap[20]).setNorth(new Door(this.MAPS.get(namemap[19])));

		//map 21
		this.MAPS.get(namemap[21]).setEast(new Door(this.MAPS.get(namemap[22])));
		this.MAPS.get(namemap[21]).setWest(new Door(this.MAPS.get(namemap[18])));

		//map 22
		this.MAPS.get(namemap[22]).setWest(new Door(this.MAPS.get(namemap[21])));
	}
	
	public Npc[] initNpc(){
		Npc[] village = new Npc[11];

		village[0] = new Npc("mayor", null,"Henry [Mayor] : \"Welcome "+ this.player.getName() + ", as I can see on your suit, I have seen you falling from the sky. I’m sure you’re the man from the prophecy. I’m certain you will find what you need beyond the door behind me. But before that you’ll need to find the 2 objects needed to open the door. If you need help you can ask our merchant, he should have some useful object for you.\" ");
		village[1] = new Npc("villager", null, "Josette [Villager] : \"Hello there. The weather is nice, isn’t it?\"");
		village[2] = new Npc("children", null,"Loïc Choulet [Children] : \"Do you have a SolidWorks license?\"");
		Item tankTrack = new Item("tank_track", "This chariot caterpillar is shining.", -1);
		village[3] = new Npc("crazy_man",tankTrack, "Mark [Crazy man] : \"HEY YOU! I have found this big thing around, I was trying to sleep on it but it’s too hard so take it!\"");
		village[4] = new Npc("factor", null,"Sebastien [Factor] : \"I need to deliver these important packages but these monsters block the road.\"" );
		village[5] = new Npc("shepherdess", null,"Anne [Shepherdess] : \"Sometimes I found weird trace on the earth around my herd and a big ball appear.\"" );
		village[6] = new Npc("alcoholic", null,"Robert [alcoholic]: \"BEURGHHHH.\"");
		village[7] = new Npc("miner", null,"José [Miner] : \"I hope I’ll find a diamond this time but there is too much lava down there.\" " );
		village[8] = new Npc("lumberjack", null,"Franck [Lumberjack] :\"Thank you a lot, now I can go back and see my wife Josette.\"" );
		village[9] = new Npc("fisher", null,"Hena [Fisher] : \"I hope I’ll catch this big fish this time.\"" );
		Weapon grabage = new Weapon("garbage_collector", "This weapon puts any entity reference to null, allowing for the garbage collector to get rid of it.", -1, 99999999);
		village[10] = new Npc("samuel", grabage,"Samuel : \"Congratulations for looking at the game file and finding this area. Take this The Garbage Collector.\"" );
		return village;
	}

	public void implentNpc(String[]namemap , Npc[] pnj){
		this.MAPS.get(namemap[2]).addNpc(pnj[0]);
		this.MAPS.get(namemap[2]).addNpc(pnj[1]);
		this.MAPS.get(namemap[2]).addNpc(pnj[2]);
		this.MAPS.get(namemap[3]).addNpc(pnj[3]);
		this.MAPS.get(namemap[10]).addNpc(pnj[4]);
		this.MAPS.get(namemap[11]).addNpc(pnj[5]);
		this.MAPS.get(namemap[14]).addNpc(pnj[6]);
		this.MAPS.get(namemap[15]).addNpc(pnj[7]);
		this.MAPS.get(namemap[18]).addNpc(pnj[8]);
		this.MAPS.get(namemap[19]).addNpc(pnj[9]);
		this.MAPS.get(namemap[22]).addNpc(pnj[10]);
	}

	public Item[] initShopItem(){
		Item[] shop = new Item[6];

		shop[0] = new Armor("leather_tunic","Tunic made of leather." , 12, 5);
		shop[1] = new Armor("titanium_armour","Made with remnants of pencil robots." , 25, 20);
		shop[2] = new Armor("nethererite_armour","Made with ore from Ravenholm." , 25, 20);
		shop[3] = new Weapon("stone_sword","A sword stronger than wood.", 12, 15);
		shop[4] = new Weapon("japanese_sword","Take the soul of your enemies.", 12, 15);
		shop[5] = new Weapon("energie_sword","A sword recovered from an old ship that once crashed here.", 70, 50);
		return shop;
	}

	public void addItemInShop(Item[]items , Shop shop){
		for (Item item : items) {
			shop.addItem(item);
		}
	}

	public void initShop(String[]namemap, Item[] items){
		Map village = this.MAPS.get(namemap[2]);
		Shop shop = new Shop("Shop Bonville");

		shop.setDescription("Xavier [Marchand] :\"Welcome to my modest shop, hero.\"");
		shop.setReturn(village);
		village.setShop(new Door(shop));
		addItemInShop(items, shop);
	}

	public void initWorld(Scanner keyboard){
			String[] tabName = nameMap();
			String[] tabDescription = descriptionMap();
			Map[] tabMap = createTiles();
			Enemy[] tabEnemies = createAllEnemies();
			Item[]  tabItemGround = initItemInGround();
			Item[]	tabItemShop =  initShopItem();

			addnameMap(tabName, tabMap, tabDescription);  // ajout des nom au map et leurs description
			addEnnmiesMap(tabEnemies, tabName); // ajout des ennemis 
			addItemMap(tabItemGround, tabName);	// ajout des items
			initShop(tabName, tabItemShop);    // ajout de la banque d 'item dans le shop
			initPlayer(tabName, keyboard); // Joueur crée
			Npc[]	tabNpc = initNpc();

			implentNpc(tabName, tabNpc);   // ajout des pnj
			initDoorMap(tabName);		// Chaque map coté ses porte
	}

	public void initPlayer(String[] namemap , Scanner keyboard){
		System.out.print("Enter your name : ");
		String name = keyboard.nextLine();
		Player hero = new Player(name);
		this.player = hero;
		System.out.println("Welcome "+ hero.getName() +".");
		System.out.println("Your ship has crashed, you need a jack and a new motor to leave this planet.");
		hero. move(this.MAPS.get(namemap[0]));
		System.out.println("You Enter : "+this.player.getMapHero().getName() + ".");
		System.out.println(this.player.getMapHero().getDescription());
	}

	public int play(ActionManager action){
		action.getAction();

		if( this.player.getHealth() <= 0 ){

			return -1;
		}
		else if( this.player.getMapHero().getName().equals("Ship") && this.player.hasItem("reactor")) {

			return 1;
		}
		else{

			return 0;
		}
	}

	public static void main(String[] args){
		int finish = 0 ;
		World monde = new World();
		ActionManager action  = new ActionManager(monde);
		monde.initWorld(action.SCANNER);

		

		// ------------------------ INTRODUCTION -----------------------------------
		while ( finish == 0){
			finish = monde.play(action);
		}
		// ------------------------ Fin du jeu -----------------------------------

			action.SCANNER.close();
		if(finish == 1 ){
			System.out.println("\nCongratulations, you have escaped the planet and saved everyone on it.");
			System.out.println("Thanks for playing our video game !!!");
			System.out.println("Credit:\n-Boue Alexis\n-Luneteau Thomas\n-Vialle Charlie");
		}
		else{
			System.out.println("\"☠ You died. ☠ \"");
			
		}
	}
}