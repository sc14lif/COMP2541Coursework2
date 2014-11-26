package comp2541.coursework.cwk2;

import java.net.MalformedURLException;


/**
 * The Venue class holds information for one venue where an event can be held. 
 * @author Lucy
 *
 */
public class Venue
{
	private String name;
	private String address;
	private String phoneNumber;
	private String website;
	private int capacity;
	
	/**
	 * Constructor for the Venue class. 
	 * 
	 * @param n String representing the name of the venue.
	 * @param a String representing the address of the venue.
	 * @param num String representing the phone number of the venue. 
	 * @param url String representing the URL (website address) of the venue.
	 * @param c int representing the capacity of the venue.
	 * @throws MalformedURLException if the constructor fails to form a URL from the given String in the url parameter, it will throw a MalformedURLException.
	 * @throws IllegalArgumentException Throws exception if it has been passed an incorrect argument.
	 */
	public Venue (String n, String a, String num, String url, int c) throws IllegalArgumentException{
		if (n.isEmpty() || a.isEmpty() || num.isEmpty() || url.isEmpty()){
			throw new IllegalArgumentException("All fields must have a value, Strings cannot be empty. ");
		}
		else if (c <= 0){
			throw new IllegalArgumentException("Capacity value cannot be less than or equal to 0. ");
		}
		this.name = n;
		this.address = a;
		this.phoneNumber = num;
		this.website = url;
		this.capacity = c;
	}
	
	/**
	 * Gets the name of the venue.
	 * @return String representing the name of the venue.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the address of the venue.
	 * @return String representing the address of the venue.
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Gets the phone number of the venue.
	 * @return String representing the phone number of the venue.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Gets the URL of the venue.
	 * @return URL object containing the website of the venue.
	 */
	public String getWebsite() {
		return website;
	}
	
	/**
	 * Gets the capacity of the venue.
	 * @return int representing the capacity of the venue. 
	 */
	public int getCapacity() {
		return capacity;
	}
}
