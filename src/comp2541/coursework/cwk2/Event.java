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
	
	public Event(List<String> a, String date, String doors, String price, int sold){
		this.artists = a;
		this.date = LocalDate.parse(date);
		this.doors = LocalTime.parse(doors);
		this.ticketPrice = Money.parse(price);
		this.ticketsSold = sold;
	}
	
	public List<String> getArtists() {
		return artists;
	}

	public void setArtists(List<String> artists) {
		this.artists = artists;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getDoors() {
		return doors;
	}

	public void setDoors(LocalTime doors) {
		this.doors = doors;
	}

	public Money getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Money ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getTicketsSold() {
		return ticketsSold;
	}

	public void setTicketsSold(int ticketsSold) {
		this.ticketsSold = ticketsSold;
	}

	public void addArtist(String artist){
		artists.add(artist);
	}
	
	public boolean isPast(){
		if (date != null){
			if (date.compareTo(LocalDate.now()) < 0){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
}
