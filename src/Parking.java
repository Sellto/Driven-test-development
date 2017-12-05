import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Scanner;
import java.io.File;

public class Parking {
    private String code;
    int counter = 0;
    private Map<String, Boolean> map = new HashMap<String, Boolean>();
    public Parking()
	{
		map.put("test", true);
		System.out.println(map.get("test"));
	}
    public Boolean checkCode()
    {

    	Boolean result;
    	//int counter = 0;
    	Path path =  FileSystems.getDefault().getPath(".\\src\\Nouveau.txt");
    	//System.out.println(FileSystems.getDefault().getPath("") + "test");
    	//String currentDirectory;
    	//File file = new File(".");
    	//currentDirectory = file.getAbsolutePath();
    	//System.out.println(currentDirectory);
    	
    	//Path path =  Paths.get("C:\\Users\\14040\\Desktop\\Nouveau dossier\\src\\Nouveau document texte.txt");
		// Path path =  Paths.get("C:\\Users\\13022\\Desktop\\TDD lab2\\psw.txt");
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
		
		//lines.forEach(s -> System.out.println(s));
		
		lines.forEach(s ->  {
							 if (s.equals(this.code)){
							  this.counter ++;
							  System.out.println("Yes");
							 }
							 else {
							  System.out.println("No");
							 }
		
							}
		);
		
    	
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
    public int numberFreeSpaces()
    {
    	int freeSpaces = 0;
    	String key;
    	Set<String> keyCollection = this.map.keySet();
    	Object[] keyArray = keyCollection.toArray();
    	int size = keyCollection.size();
    	Boolean testBool;
    	for(int i=0; i<size; i++)
    	{
    		key = (String) keyArray[i];
    		
    		testBool = this.map.get(key);
    		if (testBool == true)
    		{
    			freeSpaces ++;
    		}
    	}

    	return freeSpaces;
    }
    public void update(Map<String, Boolean> newValues)
    {
    	this.map = newValues;
    }
    public void openGate()
    {
    	
    }
}
  