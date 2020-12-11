package Locations;

import Characters.*;
import java.util.HashMap;
import Doors.*;
import Items.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import junit.framework.*;

public class MapTest {

    private Map mapTest;
    private Enemy enemy;
    private Item item;
    private Npc npc;
    private Door door;
    private Shop shop;
    private String desc;


    @beforeALL
    void MapTest() {
        this.mapTest = new Map("mapTest");
        this.enemy = new Enemy("enemyTest", new Item("itemTest", "just to test", 0), new StatisticsEnemy());
        this.item = new Item("itemTest", "just to test", 0);
        this.npc = new Npc("npcTest", this.item, "just to test");
        this.door = new Door(mapTest);
        this.shop = new Shop("shopTest");
        this.desc = "just to test";
    }

    @Test
    public void testchangeName(String name) throws Exception { assert.assertEquals (name, this.mapTest.getName()); }

    @Test
    public void testaddEnemy(Enemy newEnemy) throws Exception { assert.assertEquals (this.mapTest.getEnemies.get(newEnemy.getName()), this.enemy); }

    @Test
    public void testaddItem(Item newItem) throws Exception { assert.assertEquals (this.mapTest.getItem(newItem.getName()), this.item); }

    @Test
    public void testaddNpc(Npc newNPC) throws Exception { assert.assertEquals (this.mapTest.getNpc(newItem.getName()), this.npc); }

    @Test
    public void testsetNorth(Door newNorth) throws Exception { assert.assertEquals (this.mapTest.getNorth(), this.door); }

    @Test
    public void testsetSouth(Door newSouth) throws Exception { assert.assertEquals (this.mapTest.getSouth(), this.door); }

    @Test
    public void testsetEast(Door newEast) throws Exception { assert.assertEquals (this.mapTest.getEast(), this.door); }

    @Test
    public void testsetWest(Door newWest) throws Exception { assert.assertEquals (this.mapTest.getWest(), this.door); }

    @Test
    public void testsetShop(Door newshop) throws Exception { assert.assertEquals (this.mapTest.getShop(), this.shop); }

    @Test
    public void testsetDescription(String desc) throws Exception { assert.assertEquals (this.mapTest.getDescription(), this.mapTest.getName() + " : " + this.desc); }

    @Test
    public boolean testisNorth() throws Exception { assert.assertEquals (this.mapTest.isNorth, true); }

    @Test
    public boolean testisSouth() throws Exception { assert.assertEquals (this.mapTest.isSouth, true); }

    @Test
    public boolean testisEast() throws Exception { assert.assertEquals (this.mapTest.isEast, true); }

    @Test
    public boolean testisWest() throws Exception { assert.assertEquals (this.mapTest.isWest, true); }

    @Test
    public boolean testisShop() throws Exception { assert.assertEquals (this.mapTest.isShop, true); }

    @Test
    public Door testgetNorth() throws Exception { assert.assertEquals (this.mapTest.getNorth(), this.door); }

    @Test
    public Door testgetSouth() throws Exception { assert.assertEquals (this.mapTest.getSouth(), this.door); }

    @Test
    public Door testgetEast() throws Exception { assert.assertEquals (this.mapTest.getEast(), this.door); }

    @Test
    public Door testgetWest() throws Exception { assert.assertEquals (this.mapTest.getWest(), this.door); }

    @Test
    public Door testgetShop() throws Exception { assert.assertEquals (this.mapTest.getShop(), this.shop); }

    @Test
    public String testgetName() throws Exception { assert.assertEquals (this.mapTest.getName(), "mapTest"); }

    @Test
    public String testgetDescription() throws Exception { assert.assertEquals (this.mapTest.getDescription(), "mapTest" + " : " + this.desc); }

    @Test
    public HashMap<String, Enemy> testgetEnemies() throws Exception { assert.assertEquals (this.mapTest.getEnemies().get(enemy.getName()), enemy); }

    @Test
    public Item testgetItem() throws Exception { assert.assertEquals(this.mapTest.getItem(this.item.getName()), this.item); }

    @Test
    public Npc testgetNpc(String Npc) throws Exception { assert.assertEquals(this.mapTest.getNpc(this.npc.getName()), this.npc); }

    @Test
    public String testgetEnemiesList() throws Exception { assert.assertEquals(this.mapTest.getEnemiesList(), "There is " + 1 + " enemy on this map : " + this.enemy.getName(); }

    @Test
    public String testgetGroundItemsList() throws Exception { assert.assertEquals(this.mapTest.getGroundItemsList(), "There is " + 1 + " item on this map : " + this.item.getName()); }

    @Test
    public String testgetNpcsList() throws Exception { assert.assertEquals(this.mapTest.getNpcsList(), "There is " + 1 + " NPC on this map : " + this.npc.getName()); }

    @Test
    public String testtoString() throws Exception { assert.assertEquals(this.mapTest.toString(), this.mapTest.getName() + " : " + this.mapTest.getDescription() + "\n" + "Shop : " + this.mapTest.isShop()); }
}
}