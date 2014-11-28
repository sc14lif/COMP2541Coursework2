package comp2541.coursework.cwk2;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.money.Money;
import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest
{
	/**
	 * Test to check that creating an event works, also tests to of the getter methods to test the joda LocalDate and joda Money classes.
	 */
	@Test public void createEvent(){
		List<String> artists = new ArrayList<String>();
		artists.add("Coldplay");
		artists.add("The Killers");
		artists.add("Artic Monkeys");
		
		try {
			Venue O2Arena = new Venue("O2 Arena", "London", "5551234", "www.theO2.co.uk", 20000);
			Event IndieRockConcert = new Event(artists, "2014-11-26", "19:30", "GBP 17.50", 0, O2Arena);
			
			assertEquals(IndieRockConcert.getDate(), new LocalDate("2014-11-26"));
			assertEquals(IndieRockConcert.getTicketPrice().toString(), "GBP 17.50");
		}
			catch (IllegalArgumentException e) {
				e.printStackTrace();
				fail("Threw IllegalArgumentException");
		}
	
	}
	
	/**
	 * Tests all of the methods (excluding Getters) of the Event class. 
	 */
	@Test public void eventMethods(){
		try{
			List<String> artists = new ArrayList<String>();
			artists.add("Taylor Swift");
			artists.add("Rihanna");
			artists.add("Katy Perry");
			
			Venue wembley = new Venue("Wembley Stadium", "Wembley Park, London", "5559876", "www.wembleystadium.com", 90000);
			Event popConcert = new Event(artists, "2014-12-13", "20:00", "GBP 50.00", 10000, wembley); //testing with 10,000 tickets 'presold'
			
			assertFalse(popConcert.isPast());
			
			assertTrue(popConcert.isUpcoming());
			
			List<String> artistsUpdated = new ArrayList<String>();
			artistsUpdated.add("Taylor Swift");
			artistsUpdated.add("Rihanna");
			artistsUpdated.add("Katy Perry");
			artistsUpdated.add("Justin Timberlake");
			popConcert.addArtist("Justin Timberlake");
			assertEquals(artistsUpdated, popConcert.getArtists());
			
			assertEquals(80000, popConcert.ticketsAvailable());

			assertTrue(popConcert.sellTickets(80000));
			
			assertTrue(popConcert.isSoldOut());
			
			assertEquals(Money.parse("GBP 4500000"), popConcert.boxOfficeTakings());
		}
			catch (IllegalArgumentException e){
				e.printStackTrace();
				fail("Threw IllegalArgumentException");
			}
	}
	
	/**
	 * Testing that Event throws an IllegalArgumentException if you pass the constructor an empty String as a parameter
	 */
	@Test(expected=IllegalArgumentException.class) public void eventStringExceptions(){
		List<String> artists = new ArrayList<String>();
		artists.add("Santa");
		artists.add("Christmas Elves");
		artists.add("The Reindeer");
		
		Venue northPole = new Venue("The North Pole", "Artic Circle", "5559876", "www.northpole.com", 500);
		Event xmasConcert = new Event(artists, "", "20:00", "GBP 50.00", 0, northPole);
	}
	
	/**
	 * Testing that Event throws an IllegalArgumentException if you pass the constructor an invalid int as the tickets sold parameter
	 */
	@Test(expected=IllegalArgumentException.class) public void eventIntegerExceptions(){
		List<String> artists = new ArrayList<String>();
		artists.add("Santa");
		artists.add("Christmas Elves");
		artists.add("The Reindeer");
		
		Venue northPole = new Venue("The North Pole", "Artic Circle", "5559876", "www.northpole.com", 500);
		Event xmasConcert = new Event(artists, "2014-12-13", "20:00", "GBP 50.00", -15, northPole);
	}
	
	/**
	 * Test to check that the compareTo method works. 
	 */
	@Test public void compareToTest1(){
		List<String> artists = new ArrayList<String>();
		artists.add("Taylor Swift");
		artists.add("Rihanna");
		artists.add("Katy Perry");
		
		Venue wembley = new Venue("Wembley Stadium", "Wembley Park, London", "5559876", "www.wembleystadium.com", 90000);
		Event popConcert = new Event(artists, "2014-12-13", "20:00", "GBP 50.00", 10000, wembley);
		
		List<String> artists2 = new ArrayList<String>();
		artists2.add("Coldplay");
		artists2.add("The Killers");
		artists2.add("Artic Monkeys");

		Venue O2Arena = new Venue("O2 Arena", "London", "5551234", "www.theO2.co.uk", 20000);
		Event IndieRockConcert = new Event(artists2, "2014-11-26", "19:30", "GBP 17.50", 0, O2Arena);

		assertEquals(popConcert.compareTo(IndieRockConcert), 1);
	}
	
	/**
	 * Test to check the compareTo method correctly throws a NullPointerException.
	 */
	@Test (expected=NullPointerException.class) public void compareToTest2(){
		List<String> artists = new ArrayList<String>();
		artists.add("Taylor Swift");
		artists.add("Rihanna");
		artists.add("Katy Perry");
		
		Venue wembley = new Venue("Wembley Stadium", "Wembley Park, London", "5559876", "www.wembleystadium.com", 90000);
		Event popConcert = new Event(artists, "2014-12-13", "20:00", "GBP 50.00", 10000, wembley);

		popConcert.compareTo(null);
	}
	
	/**
	 * Test to check that the compareTo method correctly compares events that are on the same day 
	 */
	@Test public void compareToTest3(){
		List<String> artists = new ArrayList<String>();
		artists.add("Taylor Swift");
		artists.add("Rihanna");
		artists.add("Katy Perry");
		
		Venue wembley = new Venue("Wembley Stadium", "Wembley Park, London", "5559876", "www.wembleystadium.com", 90000);
		Event popConcert = new Event(artists, "2014-12-13", "20:00", "GBP 50.00", 10000, wembley);
		
		List<String> artists2 = new ArrayList<String>();
		artists2.add("The Killers");
		artists2.add("Coldplay");
		artists2.add("Artic Monkeys");

		Venue O2Arena = new Venue("O2 Arena", "London", "5551234", "www.theO2.co.uk", 20000);
		Event IndieRockConcert = new Event(artists2, "2014-12-13", "19:30", "GBP 17.50", 0, O2Arena);

		assertEquals(popConcert.compareTo(IndieRockConcert), -1);
	}
}
