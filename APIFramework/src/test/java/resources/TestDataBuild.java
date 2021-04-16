package resources;

import java.util.ArrayList;
import java.util.List;

import pojoDemo.AddPlace;
import pojoDemo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayLoad(String name, String language, String address) {
		List<String> type = new ArrayList<String>();
		type.add("Shoe Park");
		type.add("Shoe Shop");
		
		Location loc = new Location();
		loc.setLat(109.76543);
		loc.setLng(987.254678);
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("9876543210");
		p.setWebsite("www.abcxyz.com");
		p.setName(name);
		p.setTypes(type);
		
		p.setLocation(loc);
		return p;
	}
	
	public String deletePlacePayload(String placeId) {		
		return "{\r\n	\"place_id\":\""+placeId+"\"\r\n}";		
	}

}
