
import Fight;
import Items.*;
import Stats.StatisticsPlayer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import junit.framework.*;

public class FightTest {
	private Fight fight ;
	private Player player ;

	@beforeALL
	public testinitFight() {

		StatisticsPlayer stats = new StatisticsPlayer(30, 30, 30, 30, 100);
		this.player = new Player("test", stats);
        this.fight = new Fight(this.player);
		
	}

	@Test
	public void  testattackCrit(){ this.fight.attackCrit(this.player);
		assertEquals(60,this.player.getAttack()*coeffCrit);}


	}

	


	