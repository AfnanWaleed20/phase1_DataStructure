package application;

public class Location {
private String Location;
	public Location() {
		super();
		
		
	}
	
	public Location(String location) {
		Location = location;
	}

	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}

	@Override
	public String toString() {
		return "Location=" + Location ;
	}
	
	
}
