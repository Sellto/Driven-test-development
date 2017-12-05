import java.util.HashMap;
import java.util.Map;

public class Program {
	public static void main(String[]args)
	{
	    Map<String,Boolean> map = new HashMap<String, Boolean>();

		map.put("test",false);
		System.out.println(map.get("test"));
		Parking test = new Parking();
		test.setCode("test");
		System.out.println(test.checkCode());
	}
}
