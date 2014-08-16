package Tests;


import static org.junit.Assert.*;

import org.junit.Test;

import GamePieces.Card;

public class CardTests {
	
	@Test public void testNameOne(){
		Card cd = new Card("Jack", null, Card.Type.PERSON);
		assertEquals(cd.getName(), "Jack");
	}
	
	@Test public void testNameTwo(){
		Card cd = new Card("Jhon", null, Card.Type.ROOM);
		assertEquals(cd.getName(), "Jhon");
	}
	
	@Test public void testNameThree(){
		Card cd = new Card("Knife", null, Card.Type.WEAPON);
		assertFalse(cd.getName().equals("Elliot"));
	}
	
	@Test public void testTypeOne(){
		Card cd = new Card("Knife", null, Card.Type.WEAPON);
		assertEquals(cd.getType(), Card.Type.WEAPON);
	}
	
	@Test public void testTypeTwo(){
		Card cd = new Card("Knife", null, Card.Type.WEAPON);
		assertFalse(cd.getType() == Card.Type.ROOM);
	}
	
	@Test public void testTypeThree(){
		Card cd = new Card("Knife", null, Card.Type.WEAPON);
		assertFalse(cd.getType() == Card.Type.PERSON);
	}
	
	@Test public void testTypeFour(){
		Card cd = new Card("Kitchen", null, Card.Type.ROOM);
		assertEquals(cd.getType(), Card.Type.ROOM);
	}
	
	@Test public void testTypeFive(){
		Card cd = new Card("Kitchen", null, Card.Type.ROOM);
		assertFalse(cd.getType() == Card.Type.PERSON);
	}
	
	@Test public void testTypeSix(){
		Card cd = new Card("Kitchen", null, Card.Type.ROOM);
		assertFalse(cd.getType() == Card.Type.WEAPON);
	}
	
	@Test public void testTypeSeven(){
		Card cd = new Card("Jhon", null, Card.Type.PERSON);
		assertEquals(cd.getType(), Card.Type.PERSON);
	}
	
	@Test public void testTypeEight(){
		Card cd = new Card("Jhon", null, Card.Type.PERSON);
		assertFalse(cd.getType() == Card.Type.ROOM);
	}
	
	@Test public void testTypeNine(){
		Card cd = new Card("Jhon", null, Card.Type.PERSON);
		assertFalse(cd.getType() == Card.Type.WEAPON);
	}
	
	@Test public void testEquals(){
		Card cd = new Card("Jhon", null, Card.Type.PERSON);
		if(!cd.equals(cd)){
			fail();
		}
		Card cd2 = new Card("Jhon", null, Card.Type.PERSON);
		if(!cd.equals(cd2)){
			fail();
		}
		Card cd3 = new Card("Jhon", null, Card.Type.WEAPON);
		if(cd.equals(cd3)){
			fail();
		}
	}
}
