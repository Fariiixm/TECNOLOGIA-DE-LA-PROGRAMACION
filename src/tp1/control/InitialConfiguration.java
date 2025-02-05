package tp1.control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InitialConfiguration {
		
	public static final InitialConfiguration NONE = new InitialConfiguration();
	
	private List<String> descriptions;
	
	private InitialConfiguration() {}
	
	private InitialConfiguration(List<String> descriptions) {
		this.descriptions = descriptions;
	}
	
	public List<String> getShipDescription(){
		return Collections.unmodifiableList(descriptions);
	}
	
	public static InitialConfiguration readFromFile(String filename) throws FileNotFoundException, IOException {
			    
		List<String> descriptions = new ArrayList<>();
			    
		BufferedReader buffer = new BufferedReader(new FileReader(filename));	    
		String line = buffer.readLine();
	    	while (line != null) {
	    		descriptions.add(line);
	    		line = buffer.readLine();
	    	}	
	    if(buffer != null) 
		   buffer.close();
		 	    
	   return new InitialConfiguration(descriptions);
	}
	
}