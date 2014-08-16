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
	
	@Test public void testDice(){
		Person per = new Person("Purple", null, null);
		for(int i = 0; i < 100; i++){
			int j = per.rollDice();
			if(j <=1 || j > 12){
				fail("Dice failed to roll valied numbers");
			}
		}
	}
}
