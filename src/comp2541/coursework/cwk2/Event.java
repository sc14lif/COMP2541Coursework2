package comp2541.coursework.cwk2;
import java.util.List;
import org.joda.money.Money;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class Event
{
	private List<String> artists; 
	private LocalDate date;
	private LocalTime doors;
	private Money ticketPrice;
	private int ticketsSold;
	private Venue venue;
	
	public Event(List<String> a, String date, String doors, String price, int sold, Venue v){
		this.artists = a; //assumes Event has been passed a list of artists, containing 1..* artists
		this.date = LocalDate.parse(date);
		this.doors = LocalTime.parse(doors);
		this.ticketPrice = Money.parse(price);
		this.ticketsSold = sold;
		this.venue = v;
	}
	
	public List<String> getArtists() {
		return artists;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getDoors() {
		return doors;
	}

	public Money getTicketPrice() {
		return ticketPrice;
	}

	public int getTicketsSold() {
		return ticketsSold;
	}

	public void addArtist(String artist){
		this.artists.add(artist);
	}
	
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
	
	public int ticketsAvailable(){ //returns 0 if sold out, -1 if venue doesn't exist, otherwise returns number of tickets available
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
	
	public boolean sellTickets(int numTickets){ //returns false if venue doesn't exist, or if event is sold out, or if buying the value of numTickets makes the event go over capacity
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
}
