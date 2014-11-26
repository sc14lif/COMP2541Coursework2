package comp2541.coursework.cwk2;
import java.util.List;
import org.joda.money.Money;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

/**
 * Event is a class that holds information and contains methods on one particular event (gig).
 * @author Lucy
 *
 */
public class Event
{
	private List<String> artists; 
	private LocalDate date;
	private LocalTime doors;
	private Money ticketPrice;
	private int ticketsSold;
	private Venue venue;
	
	/**
	 * Constructor for the Event class.
	 * 
	 * @param a A list of Strings containing the artists names for the event
	 * @param date A string of the date of the event, will be parsed into a LocalDate object.
	 * @param doors A string containing the time the doors open for the event, will be parsed into a LocalTime object.
	 * @param price A string containing the ticket price. Will be parsed into a Money object.
	 * @param sold An int representing how many tickets sold. Often will be 0 when object is first constructed.
	 * @param v A venue object holding information about the venue that the event is being held at.
	 * @throws IllegalArgumentException Throws exception if it has been passed an incorrect argument.
	 */
	public Event(List<String> a, String date, String doors, String price, int sold, Venue v) throws IllegalArgumentException {
		if (a.isEmpty()|| date.isEmpty() || doors.isEmpty() || price.isEmpty()){
			throw new IllegalArgumentException("All fields must have a value, Strings and Lists cannot be empty.");
		}
		else if (sold < 0){
			throw new IllegalArgumentException("ticketsSold value cannot be less than zero.");
		}
		this.artists = a; //assumes Event has been passed a list of artists, containing 1..* artists
		this.date = LocalDate.parse(date);
		this.doors = LocalTime.parse(doors);
		this.ticketPrice = Money.parse(price);
		this.ticketsSold = sold;
		this.venue = v;
	}
	
	/**
	 * Gets the List of artists.
	 * @return A List<String> containing the names of the artists performing at the event.
	 */
	public List<String> getArtists() {
		return artists;
	}

	/**
	 * Gets the date of the event.
	 * @return A LocalDate object that has the date the event is being held.
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Gets the time the doors open.
	 * @return A LocalTime object that has the time the doors open at the event.
	 */
	public LocalTime getDoors() {
		return doors;
	}

	/**
	 * Gets the price of the ticket.
	 * @return A Money object that contains the price of a ticket for the event. 
	 */
	public Money getTicketPrice() {
		return ticketPrice;
	}

	/**
	 * Gets the number of tickets sold.
	 * @return An int representing the number of tickets sold for the event. 
	 */
	public int getTicketsSold() {
		return ticketsSold;
	}

	/**
	 * Add an artist to the List of artists performing at the event.
	 * @param artist Passed a String representing the name of the artist performing.
	 */
	public void addArtist(String artist){
		if (!artist.isEmpty() && !artists.contains(artist)){
		this.artists.add(artist);
		}
	}
		
	/**
	 * Checks if the event is in the past, therefore has already occurred.
	 * @return true if in past, false if it is in the future.
	 */
	public boolean isPast(){
		if (this.date != null){
			if (this.date.compareTo(LocalDate.now()) < 0){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Checks if the event is upcoming.
	 * @return true if event is coming up, false if it is in the past.
	 */
	public boolean isUpcoming(){
		if (this.date != null){
			if (this.date.compareTo(LocalDate.now()) >= 0){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Checks if the event is sold out.
	 * @return true if the event is sold out, false if it is not sold out.
	 */
	public boolean isSoldOut(){
		if (this.venue != null){
			int capacity = this.venue.getCapacity();
			if (this.ticketsSold >= capacity){
				return true;
			}
			else{
				return false;
			}
			
		}
		return false;
	}
	
	/**
	 * Checks if there are any tickets still available for the event.
	 * @return int - 0 if event is sold out, -1 if venue doesn't exist, otherwise returns the number of tickets available.
	 */
	public int ticketsAvailable(){ 
		if (this.venue != null){
			int capacity = this.venue.getCapacity();
			if (this.isSoldOut()){
				return 0;
			}
			else{
				return capacity - ticketsSold;
			}
		}
		return -1; 
	}
	
	/**
	 * Sell a specified number of tickets to the event.
	 * @param numTickets the number of tickets to be sold.
	 * @return true if there were enough tickets left, false if venue doesn't exist, or if event is sold out, or if buying the value of numTickets makes the event go over capacity.
	 */
	public boolean sellTickets(int numTickets){ 
		if (this.venue != null && !this.isSoldOut()){
			if ((this.ticketsSold + numTickets) > this.venue.getCapacity()){
				return false;
			}
			else{
				this.ticketsSold += numTickets;
			}
		}
		return false;
	}
	
	/**
	 * Calculates box office takings. 
	 * @return Money object representing amount of money made at the box office. 
	 */
	public Money boxOfficeTakings(){
		return ticketPrice.multipliedBy(ticketsSold, java.math.RoundingMode.HALF_DOWN);
	}
}
