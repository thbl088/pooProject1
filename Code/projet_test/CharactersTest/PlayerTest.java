package CharacterTest;

import Characters.Player;
import Items.*;
import Locations.*;
import Stats.*;

public class PlayerTest extends Character {
	
	private Player player ;
	private Weapon item = new Weapon("test", "test", 20, 10);
	private Item buy = new Item("buy","buy", 6);

	@beforeALL
	public testinitPlayer() {
		StatisticsPlayer stat = new StatisticsPlayer(0, 2, 2, 2, 10);
		this.player = new Player("test",stat);
		this.player.maxhealt = 0;
	}

	@test
	public void testuseHealthPotion() { player.useHealthPotion();  // Vérifie si la potion marche bien
		assertEquals(26, player.getHealth()); }
	
	@test
	public void testAttackPotion() { player.useAttackPotion();     
		assertEquals(4, player.getAttack() ); }
	
	@test
	public void testDefensePotion() { player.useDefensePotion();     
			assertEquals(4, player.getAttack()); }
	
	@test
	public void testuseCritPotion() { player.uuseCritPotion();    
				assertEquals(4, player.getCrit()); }
	
	@test
	public void testequiWeapon(Item item){  player.equiWeapon(this.item);  // ajout de l'item test qui donne +5att
		assertEquals(7, player.getAttack()); }

	@test 
	public void testremoveEquipment(){ player.removeEquipment(this.item);     // on l'enleve l'item test on perd 5 att
		assertEquals(2, player.getAttack()); }

	@test
	public void testbuyItem (){ player.buyItem(this.item.getName());
		assertEquals(0, player.getStatistics().getMoney()) ;}

	@test 
	public void testsellItem (){ player.sellItem(this.buy.getName());
		assertEquals(5, player.getStatistics().getMoney()) ;}
	
	@test 
	public void  testbuyPotion(){ player.buyItem("health_potion");
		assertEquals(0, player.getStatistics().getMoney()) ;}


}