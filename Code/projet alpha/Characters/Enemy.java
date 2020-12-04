package Characters;

public class Enemy extends Character {

	private Item Object;

	/**
	 * 
	 * @param object
	 * @param type
	 */
	public Enemy(String name, Item object, Stats type) {
		// TODO - implement Enemy.Enemy
		this.Object = object;
		super(name);
		super(type);
		throw new UnsupportedOperationException();
	}

}