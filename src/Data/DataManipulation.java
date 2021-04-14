package Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataManipulation {

	public static double Max(List<Double> list) { // finding the maximum value of the list 
		List<Double> sortedlist = new ArrayList<Double>(list);  
		Collections.sort(sortedlist); // sort the list in ascending order
		double Final =  sortedlist.get(sortedlist.size() - 1);    // last element in the sorted list would be maximum :)
		return Final;  
	}


	public static double Min(List<Double> list) {
		List<Double> sortedlist = new ArrayList<Double>(list); //pass list from parameter to variable sorted list
		Collections.sort(sortedlist); // sort the list ascending order
		double Final =  sortedlist.get(0); // first value will be smallest value
		return Final; 
	}

	public static double Avg(List<Double> list) {
		List<Double> sortedlist = new ArrayList<Double>(list);//pass list from parameter to variable sorted list
		double sum = 0;  
		for (Double i : sortedlist) //Iterate through and add all data in list
		sum = sum + i;
		sum = sum / list.size(); // calculate average by using mean (total / Number of data points) 
		return sum; 


	}

	
	
	



}
