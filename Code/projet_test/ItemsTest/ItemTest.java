package ItemsTest;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Items.Item;
import junit.framework.*;

public class ItemTest{

	private Item item;

	@beforAll
	void ItemTest()
	{
	  this.item = new Item("Wheel", "It's a wheel", 15); 
	}

	@Test
	public void testgetName() throws Exception { assertEquals("Wheel", item.getName()); }

	@Test
	public String testgetDescription() throws Exception { assertEquals("It's a wheel" , item.getDescription()); }

	@Test
	public int testgetPrice() throws Execption { assertEquals(15 , item.getPrice()); }

}