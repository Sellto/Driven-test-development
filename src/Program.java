import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Program {
	public static void main(String [] args) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("place 1", false);
		map.put("place 2", false);
		map.put("place 3", false);
		map.put("place 4", false);
		map.put("place 5", false);
		map.put("place 6", false);
		Map<String, Boolean> dic = new HashMap<String, Boolean>();
		dic.put("place 1", true);
		dic.put("place 3", true);
		dic.put("place 5", true);
		String key = "";
		Set<String> keyCollection = dic.keySet();
		Object[] keyArray = keyCollection.toArray();
		int size = keyCollection.size();
		for(int i=0; i<size; i++) {
			key = (String) keyArray[i];	
			map.put(key, dic.get(key));
		}
		key = "";
		keyCollection = map.keySet();
		keyArray = keyCollection.toArray();
		size = keyCollection.size();
		for(int i=0; i<size; i++) {
			key = (String) keyArray[i];	
			System.out.println("Key :" + key + " , value :" + map.get(key));
		}
	}
}
