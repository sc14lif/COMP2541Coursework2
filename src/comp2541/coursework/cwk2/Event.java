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
}
