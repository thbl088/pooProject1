package ItemsTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Items.Armor;
import junit.framework.*;

public class ArmorTest extends ItemTest {
	
	private Armor item;

	@beforAll
	public testinitArmor(){
		
		this.item = new Armor("test", "test", 12 ,13);
	}

	@Test
	public void testgetDefenseBonus() { assertEquals(13, item.getDefenseBonus()); }

}