import Items.Weapon;
import Locations.*;
import Characters.*;
import Doors.*;
import Stats.StatisticsEnemy;
import Stats.StatisticsPlayer;

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

	public static void main(String[] args){

	}
}