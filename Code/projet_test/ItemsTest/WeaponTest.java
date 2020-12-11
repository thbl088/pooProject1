package ItemsTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Items.Item;
import jdk.jfr.Timestamp;
import junit.framework.*;

public class WeaponTest extends ItemTest {
	private int attackBonus;

	@beforeALL
	public WeaponTest(String name, String description , int price , int attack) {
		super(name, description , price);
		this.attackBonus = attack;
	}

	@Test
	public int testgetAttackBonus() throws Exception { assertEquals(this.attackBonus, item.getAttackBonus()); }


}