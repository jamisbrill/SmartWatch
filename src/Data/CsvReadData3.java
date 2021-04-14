package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CsvReadData3 {
	
	
	
	// array list to store the data for the csv GRAPH 
	
	private static ArrayList<Double> CsvTemperaturelist = new ArrayList<Double>();
	private static ArrayList<Double> CsvPressurelist = new ArrayList<Double>();
	private static ArrayList<Double> CsvMotionlist = new ArrayList<Double>();


	
	
	public static void CsvBuffered() {
	
	
	BufferedReader file = null;
	
	
	
	double Temperature[]= new double[1000000];
	double Pressure[] = new double[100000];   //capitalised the double to make them objects 1/9/20   // nope there back to lower case doubles
	double Motion[] = new double[100000];

	
	String filePath = "";


	filePath = DataFile.getFilePath();


	
	// FILE SELECTOR 
	if (filePath==null) {
		System.out.println("No File has been selected Cannot write");
		FileChooser.main(null);				
		filePath = FileChooser.getFilePath(); //asing filepath final to filepath 

		System.out.println(FileChooser.getFilePath());
		


	}
//END OF FILE SELECTOR 	
	
	try {
		file = new BufferedReader(new FileReader(filePath+"\\Data"+".csv"));   // this works to select data location 
		
		String line="";
		int index=0;
		
	
	
		

		while((line = file.readLine()) !=null) {

			String[] splits = line.split(",");
			
			// insert the data into separate arrays to allow for further parsing 
			
			
			
			Temperature[index] = Double.parseDouble(splits[0]);     //read in data into each specific array 
			Pressure[index] = Double.parseDouble(splits[1]);
			Motion[index] = Double.parseDouble(splits[2]);
			
			double CsvTemperatureTemporary = (Double.parseDouble(splits[0]));
			double CsvPressureTemporary = (Double.parseDouble(splits[1]));
			double CsvMotionTemporary = (Double.parseDouble(splits[2]));

			
			CsvTemperaturelist.add(CsvTemperatureTemporary);   
			CsvPressurelist.add(CsvPressureTemporary);   
			CsvMotionlist.add(CsvMotionTemporary);   
	
			
			System.out.println("TP:"+Temperature[index]+"HB:"+Pressure[index]+"TMP:"+Motion[index]);

			index++;

		}
		//end of the loop to add data to the array list and read from file 
		
		
		System.out.println("CSV ARRAY LIST IS:"+CsvTemperaturelist+"Pressure List"+CsvPressurelist+"MotionList is "+CsvMotionlist);

		
	
	}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}				
	
	
	
	
	System.out.println("Data File get total csv is" + DataFile.getCSVTotalPull());
	
	
	
}
	
	public static ArrayList<Double> getCsvTemperaturelist() {
       		
		System.out.println("TPList:"+CsvTemperaturelist);
		
		
		
		return CsvTemperaturelist;
    }
	public static ArrayList<Double> getCsvPressurelist() {
	       
		
		System.out.println("Pressure:"+CsvPressurelist);
		
		
		
		return CsvPressurelist;
    }
	public static ArrayList<Double> getCsvMotionlist() {
	       
		
		System.out.println("Motion :"+CsvMotionlist);
		
		
		
		return CsvMotionlist;
    }
	
	
	
	
	
	
	
	
}
