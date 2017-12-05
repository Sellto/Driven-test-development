import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class Sensors {
	
	private Map<String, Boolean> map = new HashMap<String, Boolean>();
//	private int numberOfSensors=0;
	
	public Sensors(int numberOfSensors){
		//this.numberOfSensors = numberOfSensors;
		String key = "";
		// Create the dictionary according to the number of sensors.
		for(int i=1; i <= numberOfSensors; i++) {
			key = "Place "+ Integer.toString(i);
			this.map.put(key, false);
		}
	}
	public void changeState(String namePlace, boolean bool) {
		this.map.put(namePlace, bool);
	}
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
	public void addName(String namePlace) {
		this.map.put(namePlace, false);
	}
	
	public Map<String, Boolean> getChange() {
		return this.map;
	}
	public boolean getState(String namePlace) {
		return this.map.get(namePlace);
	}
}
		