package Modeles;



public class Door
{
	protected Map destination;

	public Door(Map dest) { this.destination = dest; }
	public Door(){}

	public Map getDestination() {
		return this.destination;
	}

}