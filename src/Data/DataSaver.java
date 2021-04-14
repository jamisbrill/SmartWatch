package Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import SQL.SQLConnect;


public class DataSaver {

	public static ArrayList<Double> TemperatureList2 = new ArrayList<Double>();  // create the array lists where the data will be stored 
	public static ArrayList<Double> PressureList2 = new ArrayList<Double>();  
	public static ArrayList<Double> MotionList2 = new ArrayList<Double>(); 

	public static void FileCreator() {
		String filePath = "D:\\Eclipse Stuff\\ASmartWatch";		//static location could be dynamic in the future	
try {
	List<String[]> data = new ArrayList<String[]>(); 
		
// set the file name to data.csv	
			File doc = new File(filePath+"\\Data"+".csv"); //append the name data and .csv 

// create the csv file writer object
			CSVWriter writer = new CSVWriter(new FileWriter(doc), // Create the csv constructor 
				    CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER,    
				    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
				    CSVWriter.RFC4180_LINE_END);

// create variables to store the data
			 	String Temperature; 
			 	String Pressure; 
			 	String Motion;

// get the data from the SQLConnect method
			 	Temperature = SQLConnect.getTemperature().toString(); // put the data into strings 
			 	Pressure = SQLConnect.getPressure().toString();
				Motion = SQLConnect.getMotion().toString();
						
				System.out.println("Huh"+Temperature+Pressure+Motion); //check the data has been put into the strings 
				
				data.add(new String[] {"Temp"+Temperature,"Pressure"+Pressure,"Motion"+Motion});

				// flush the data to the writer 
			writer.writeAll(data); //fixed it by putting this outside of the main data loop :) 

			writer.close(); // close the writer to prevent data leaks etc 

		}



		catch (ArrayIndexOutOfBoundsException e1)  // catch any issues when the arrays is out of bounds 
{


			// TODO Auto-generated catch block
			e1.printStackTrace(); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

	}
	
	
}
