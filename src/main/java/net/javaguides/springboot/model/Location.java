package net.javaguides.springboot.model;

public class Location {

	private String country;
	private String area;
	private String street;
	private String nr;
	private String postalCode;

	public Location(String address, String country, String area, String street, String nr, String postalCode) {
		super();
		this.country = country;
		this.area = area;
		this.street = street;
		this.nr = nr;
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Street: " + street + ", nr. " + nr + ", " + postalCode + " , " + area + " , " + country;
	}

}
