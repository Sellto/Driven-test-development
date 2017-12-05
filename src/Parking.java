import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Parking extends Observer{
	
	//The client receives the code when he buys something in the store
    private String code;
	
	//Let the system know if it has to open the gate or not
    private boolean gate;
	
    //Used in checkCode to determine if the attribute "code" is valid
	int counter = 0;
	
	//Each key is a parking spot and each value is the status : 
	//false if it's a free spot and inversely if it's true
    private Map<String, Boolean> parkingSpots = new HashMap<String, Boolean>();
	
    public Parking()
    {
	}
	
    //Check the barcode or QRcode given by the client to the parking system
    public Boolean checkCode()
    {
		//Variable "result" is true if the barcode is valid
    	Boolean result;
		
		//The attribute "code" is compared to the valid barcodes contained 
		//in the file located in this path
		//The valid codes are determined and created by the store and written in this file
    	Path path =  FileSystems.getDefault().getPath(".//src//Nouveau.txt");
		
		//Read the .txt file
		Stream<String> lines = null;
		
		try 
		{
			
			lines = Files.lines(path);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Compare each line to the attribute "code"
		lines.forEach(s ->  {
							//The code is valid
							if (s.equals(this.code)){
							  this.counter ++;
							  //System.out.println("Yes");
							 }
							 else {
							 // System.out.println("No");
							 }
		
							}
		);
		
    	//The attribute "code" is valid as the same exists in the file containing the valid codes
    	if(this.counter == 1)
    	{
    		result = true;
    	}
    	else
    	{
    		result = false;
    	}
    	
    	return result;
    }
	
    public void setCode(String code)
    {
    	this.code = code;
    }
	
	//Determines and returns the number of free spaces to park a car
    public int numberFreeSpaces()
    {
    	int freeSpaces = 0;
		//Initialize all the variables used to analyze the parkingSpot dictionary
    	String key;
    	Set<String> keyCollection = this.parkingSpots.keySet();
    	Object[] keyArray = keyCollection.toArray();
    	int size = keyCollection.size();
    	Boolean testBool;
    	for(int i=0; i<size; i++)
    	{
    		key = (String) keyArray[i];
    		//Get the value corresponding to each parking spot to know if it's free or not
    		testBool = this.parkingSpots.get(key);
    		if (testBool == false)
    		{
    			freeSpaces ++;
    		}
    	}

    	return freeSpaces;
    }
	
	//Update the dictionary containing the state of each parking spot
    public void update(Map<String, Boolean> newValues)
    {
    	this.parkingSpots = newValues;
    }
	
	//Used when the attribute "code" has been verified and is valid
    public void openGate()
    {
    	this.gate = true;
    }
	//Used after a car passed the gate
	public void closeGate()
    {
    	this.gate = false;
    }
}
  
