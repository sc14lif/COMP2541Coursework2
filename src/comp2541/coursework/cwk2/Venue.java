package comp2541.coursework.cwk2;

import java.net.MalformedURLException;
import java.net.URL;

public class Venue
{
	private String name;
	private String address;
	private String phoneNumber;
	private URL website;
	private int capacity;
	
	public Venue (String n, String a, String num, String url, int c) throws MalformedURLException, IllegalArgumentException{
		this.name = n;
		this.address = a;
		this.phoneNumber = num;
		this.website = new URL(url);
		this.capacity = c;
	}
	
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public URL getWebsite() {
		return website;
	}
	public int getCapacity() {
		return capacity;
	}
}
