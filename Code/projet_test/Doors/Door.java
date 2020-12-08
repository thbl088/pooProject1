package Doors;

import Locations.*;

public class Door
{
	protected Map destination;

	public Door(Map dest) { this.destination = dest; }
	public Door(){ this.destination = null; }

	public Map getDestination() {
		return this.destination;
	}

}