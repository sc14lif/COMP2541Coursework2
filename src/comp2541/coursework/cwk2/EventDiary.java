package comp2541.coursework.cwk2;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class EventDiary {
	
	SortedSet<Event> events;
	
	public EventDiary(){
		events = new TreeSet<Event>();
	}
	
	public boolean addEvent(List<String> artists, String date, String doors, String price, int sold, Venue venue){
		Event e = new Event(artists, date, doors, price, sold, venue);
		return events.add(e);
	}
	
	public boolean cancelEvent(Event e){
		if (events.contains(e)){
			return events.remove(e);
		}
		return false;
	}
	
	public void displayAll(){
		System.out.println("---------Displaying All Events---------");
		for (Event e : events){
			System.out.println("Artist(s): \t " + e.getArtists().get(0));
			
			if (e.getArtists().size() > 1){
				for (int i = 1; i < e.getArtists().size(); i++){
					System.out.println("\t \t "+e.getArtists().get(i));
				}
			}
			System.out.println("Date: \t \t "+ e.getDate().toString());
			DateTimeFormatter fmt = DateTimeFormat.forPattern("k:m");
			System.out.println("Doors open at: \t " + e.getDoors().toString(fmt));
			System.out.println("Ticket Price: \t " + e.getTicketPrice().toString());
			System.out.println("Tickets Sold: \t " + e.getTicketsSold() ); 
			System.out.println("----------------------------------");
			System.out.println();
		}
	}
	
	public void displayUpcoming(){
		System.out.println("-------------Upcoming Events----------------");
		for (Event e : events){
			if (e.isUpcoming()){
				System.out.println("Artist(s): \t " + e.getArtists().get(0));
				
				if (e.getArtists().size() > 1){
					for (int i = 1; i < e.getArtists().size(); i++){
						System.out.println("\t \t "+e.getArtists().get(i));
					}
				}
				System.out.println("Date: \t \t "+ e.getDate().toString());
				DateTimeFormatter fmt = DateTimeFormat.forPattern("k:m");
				System.out.println("Doors open at: \t " + e.getDoors().toString(fmt));
				System.out.println("Ticket Price: \t " + e.getTicketPrice().toString());
				System.out.println("Tickets Sold: \t " + e.getTicketsSold() ); 
				System.out.println("----------------------------------");
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		EventDiary diary = new EventDiary();
		ArrayList<String> artists1  = new ArrayList<String>();
		artists1.add("Ed Sheeran");
		artists1.add("Taylor Swift");
		artists1.add("Hozier");
		Venue venue = new Venue("O2 Arena", "London", "5551234", "www.theO2.co.uk", 20000);
		diary.addEvent(artists1, "2014-12-13", "19:30", "GBP 17.50", 0, venue);
		
		ArrayList<String> artists2 = new ArrayList<String>();
		artists2.add("Led Zeppelin");
		artists2.add("The Who");
		artists2.add("The Rolling Stones");
		diary.addEvent(artists2, "2014-11-13", "20:00", "EUR 50.00", 10, venue);
		
		ArrayList<String> artists3 = new ArrayList<String>();
		artists3.add("Lorde");
		artists3.add("James Blake");
		artists3.add("Alt-J");
		diary.addEvent(artists3, "2014-11-13", "22:30", "NZD 25.00", 1000, venue);
		
		diary.displayAll();
		
		diary.displayUpcoming();
		
	}

}
