package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import GamePieces.Person;
import GamePieces.Card;
import java.util.ArrayList;

public class PersonTests {
	@Test public void testCol(){
		Person per = new Person("fred","Orange", 0,0);
		if(!per.getName().equals("Orange")){
			fail();
		}
		if(per.getName().equals("Fredrico")){
			fail();
		}
	}
	
	@Test public void testDice(){
		Person per = new Person("Mable","Purple", 0,0);
		for(int i = 0; i < 100; i++){
			int j = per.rollDice();
			if(j <=1 || j > 12){
				fail("Dice failed to roll valied numbers");
			}
		}
	}
}
