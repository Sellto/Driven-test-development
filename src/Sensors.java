package tddMav.tddMav;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class Sensors {
	// Dictionary that contains all the places and their status.
	private Map<String, Boolean> map = new HashMap<String, Boolean>();
//	private int numberOfSensors=0;
	public Sensors(int numberOfSensors){
		//this.numberOfSensors = numberOfSensors;
		String key = "";
		// Create the dictionary according to the number of sensors.
		for(int i=1; i <= numberOfSensors; i++) {
			key = "Spot "+ Integer.toString(i);
			this.map.put(key, false);
		}
	}
	// Change state of one place
	public void changeState(String nameSpot, boolean bool) {
		this.map.put(nameSpot, bool);
	}
	// Set state for many places, argument is a dictionary that contains all the updates parking places.
	public void setState(Map<String, Boolean> dic) {
		String key = "";
		Set<String> keyCollection = dic.keySet();
		Object[] keyArray = keyCollection.toArray();
		int size = keyCollection.size();
		for(int i=0; i<size; i++) {
			key = (String) keyArray[i];
			this.map.put(key, dic.get(key));
		}
	}
	// Add new place in the collection initiated at false.
	public void addName(String nameSpot) {
		this.map.put(nameSpot, false);
	}
	// Returns the entire dictionary
	public Map<String, Boolean> getChange() {
		return this.map;
	}
	// Get state of one single place
	public boolean getState(String nameSpot) {
		return this.map.get(nameSpot);
	}
}
