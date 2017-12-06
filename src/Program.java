import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
	public static void main(String [] args) {
		Parking mypark = new Parking();
		Sensors sensors = new Sensors(5);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int free = mypark.numberFreeSpaces();
			System.out.println("Place(s) libre(s): " +free);
			System.out.println(sensors.getChange());
			System.out.print("Enter something:");
			try{
				String spot = br.readLine();
				sensors.changeState(spot,!sensors.getState(spot));
				mypark.update(sensors.getChange());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
