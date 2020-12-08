import Items.Item;
import Items.Weapon;
import Locations.*;
import Characters.*;
import Doors.*;
import Stats.StatisticsEnemy;
import Stats.StatisticsPlayer;
import sun.security.util.Length;

import java.util.HashMap;

public class World {

	private HashMap<String, Map> maps;
	public Player player;

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

		String[] dataName;
		
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

	public Map[] createTiles(){
		Map[] tiles;

		for(int i = 0 ; i < 22 ; i++){

			Map map = new Map();
			tiles[i] = map ;

		}

		return tiles;
	}

	public  void addnameMap(String[] name, Map[] map){

		for(int  i = 0 ; i < name.length ; i++ ){
			
			map[i].changeName(name[i]);
			maps.put(name[i], map[i]);
		}
		
	}

	public Enemy[] createAllEnemies(){
		Enemy[] enemies;

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
		Item[] ground;

		ground[0] = new Weapon("Pickaxe", "A pickaxe hard enough to mine netherite.", 12, 5);
		ground[1] = new Weapon("Rock", "It's rock like Malphite.", 2 , 2 );
		ground[2] = new Weapon( "Fish", "A smelly fish.", 6 , 4);
		ground[3] = new Weapon( "Fish", "A smelly fish.", 6 , 4);
		ground[4] = new Item("Sheep wool", "This wool is so soft.", 10);
		ground[5] = new Item("Sheep wool", "This wool is so soft.", 10);
		ground[6] = new Item("Companion Cube", "A cube with pink heart on the side.", 60);
		ground[7] = new Item("Package", "A package which contains a nvidia geforce 3080." , 20);
		ground[8] = new Item("Package", "A package which contains a nvidia geforce 3080." , 20);
		ground[9] = new Weapon("Garbage Collector", "A pickaxe hard enough to mine netherite.", -1, 99999999);
		
		return ground;
	}

	public void addItemMap(Item[]ground,String[] namemap){

		// Ajout des Ennemis dans les Hashmap de leur map
		maps.get(namemap[6]).addItem(ground[6]);
		maps.get(namemap[10]).addItem(ground[7]);
		maps.get(namemap[10]).addItem(ground[8]);
		maps.get(namemap[11]).addItem(ground[4]);
		maps.get(namemap[11]).addItem(ground[5]);
		maps.get(namemap[15]).addItem(ground[1]);
		maps.get(namemap[15]).addItem(ground[0]);
		maps.get(namemap[19]).addItem(ground[2]);
		maps.get(namemap[19]).addItem(ground[3]);
		maps.get(namemap[22]).addItem(ground[9]);


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
		//TODO faire la fonction création de pnj
		Npc[] village;

		return village;
	}

	public void implentNpc(String[]name , Npc[] pnj){
		//TODO ajouter les pnj dans le monde
	}

	public Item[] initShopItem(){
		//TODO faire la banque de donnée du shop
	}

	public void initWorld(){

			String[] tabName = nameMap();
			Map[] tabMap = createTiles();
			Enemy[] tabEnemies = createAllEnemies();
			Item[]  tabItemGround = initItemInGround();


			addnameMap(tabName, tabMap);  // ajout des nom au map 
			addEnnmiesMap(tabEnemies, tabName); // ajout des ennemis 
			addItemMap(tabItemGround, tabName);	// ajout des items

			initDoorMap(tabName);						// Chaque map coté ses porte 

	}


	public static void main(String[] args){

	}
}