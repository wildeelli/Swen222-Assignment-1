package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import GamePieces.Person;
import GamePieces.Hand;
import GamePieces.Card;
import java.util.ArrayList;

public class PersonTests {
	@Test public void testCol(){
		Person per = new Person("Orange", null, new Hand(new ArrayList<Card>()));
		if(!per.getCol().equals("Orange")){
			fail();
		}
		if(per.getCol().equals("Fredrico")){
			fail();
		}
	}
}
