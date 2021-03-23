package CharactersTest;

import Items.*;
import org.junit.jupiter.api.Test;
import Characters.Npc;
import static org.junit.jupiter.api.Assertions.*;
import junit.framework.*;

public class NpcTest extends Enemy {
    private Npc npc ;
    private Item item;

    @beforeALL
	public testinitnpc() {
        
        this.item = new Item("test name", "test descrip item ", 2);
		this.npc = new Npc("samuel", item , "blablabla");
	}

    @Test
    public Item getItem() { assertEquals(this.item, npc.getItem()); 
        assertEquals(("Samuel : \" Now you can save the world.\""),this.npc.getDialog()); }

}
