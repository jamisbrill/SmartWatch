package Data;

import java.util.ArrayList;
import java.util.List;

import GUI.EmergencyPopUp;
import SQL.SQLConnect;

public class EmergencyTrigger {

	static String[][] PatientInNeedList = new String[20][2]; 

	public static void findUser() {	
		SQLConnect.getID();	}

	public static String teperature() {

		String TempOut = null; //declare somewhere to store the temperature
		String output = null;
		int CurrentID = 1 ;
		int	 x = 1; //for iterating 

		for (int i =0; i <  SQLConnect.Temperature.size(); i++) {		//iterate through all users in list
			String iStr = String.valueOf(i);	// Convert the iterative number integer to a string

			double TemperatureDub= (SQLConnect.Temperature.get(i));  //find the value of the current users temperature 


			if (TemperatureDub >= 38 ) {//38 is fever temperature )

				TempOut = "Temperature too High"; // Output string 

				PatientInNeedList[x][0] = iStr;   // https://cdn-codespeedy.pressidium.com/wp-content/uploads/2018/11/java-2d-array.jpg
				PatientInNeedList[x][1] = TempOut; // put the outcome in to the array 

			}
			if (TemperatureDub <= 25 ) // Patient too cold )
			{
				TempOut = "Temperature too Low";
				PatientInNeedList[x][0] = iStr;  
				PatientInNeedList[x][1] = TempOut;
			}
			else {
				TempOut = "Temperature Fine";
			}
			x++;
			output = TempOut+CurrentID;

		}
		

		EmergencyPopUp.main(null);


		return output;  

	}




	public static String Motion() {

		int xi = 7; // for iterating from where temp left off 
		String MotionOut = null;
		String output = null;

		int CurrentID = 1 ;

		for (int i =0; i <  SQLConnect.Motion.size(); i++) {		//Iterate through all users in list
			String iStr = String.valueOf(i);	// Convert the iterative number integer to a string

			double MotionDub= (SQLConnect.Motion.get(i));  //find the value of the current users temperature 


			if (MotionDub >= 1999) { 

				MotionOut = "Motion Very High";


				PatientInNeedList[xi][0] = iStr;   // https://cdn-codespeedy.pressidium.com/wp-content/uploads/2018/11/java-2d-array.jpg
				PatientInNeedList[xi][1] = MotionOut;


			}

			xi++;
			output = MotionOut+CurrentID;



		}

		for(int i = 0 ; i < 6 ; i++){
			for(int j = 0 ; j < 2; j++){
				System.out.print(PatientInNeedList[i][j] + " ");
			}
			System.out.println();
		}

		EmergencyPopUp.main(null);


		return output;


	}

	public static String[][] getPatientInNeedList()
	{


		return PatientInNeedList;

	}


}
