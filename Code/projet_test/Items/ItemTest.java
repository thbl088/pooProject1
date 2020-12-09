package Items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Items.Item;
import jdk.jfr.Timestamp;
import junit.framework.*;

public class ItemTest{

	@Test
	public void testgetName() throws Exception { assertEquals(this.name,Item.getname()); }

	public String getDescription() { return this.description ; }

	public int getPrice() { return this.price ; }
}