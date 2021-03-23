package ItemsTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Items.Weapon;
import junit.framework.*;

public class WeaponTest extends ItemTest {

	private Weapon item;

	@beforeALL
	public testinitWeapon() {
		
		this.item = new Weapon("test", "test", 12, 13);
	}

	@Test
	public int testgetAttackBonus()  { assertEquals(13, item.getAttackBonus()); }


}