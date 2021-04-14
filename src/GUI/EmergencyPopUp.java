package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Data.EmergencyTrigger;
import SQL.SQLConnect;

public class EmergencyPopUp {
	  public static void main(String[] a) {
		  
		  //create variables to store data within
		    JFrame parent = new JFrame();
		    StringBuilder FormattedDataSB=new StringBuilder("");  
		    String Preformat = null;
		    //Format the string into one variable
		    String[][] PatienInNeedList = EmergencyTrigger.getPatientInNeedList(); //create 2D array 
		    for (int i=1; i < PatienInNeedList.length;  i++) 
		    {
		 
				if (PatienInNeedList[i][0] == null | PatienInNeedList[i][1] == null )     
					//  Check whether there is any null values within the string 
				{
					//Don't do anything/ this is just to run nothing if there is a null string 
				}
	
			else {
				//If array had data within in it put it intro string
    Preformat = "Users ID:  " + PatienInNeedList[i][0] + " Problem With User: "+PatienInNeedList[i][1]+"\r\n" + 		"";

			    FormattedDataSB.append(Preformat);; // put data from pre-format string into a string builder 
				
			}
		    }
		

		    //output the string onto a dialog pop up 
		    JOptionPane.showMessageDialog(parent, FormattedDataSB,"Patient Notification System", 2); 

		  }
}
