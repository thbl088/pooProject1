import Locations.*;
import Characters.*;
import java.util.HashMap;

public class World {

	private HashMap<String, Map> maps;
	public Player player;

	public String getMapDescription(){
		return this.player.getMapHero().getDescription();
	}

	public World() {
		// TODO - implement World.World
		throw new UnsupportedOperationException();
	}

}