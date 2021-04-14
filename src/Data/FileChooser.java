package Data;

import java.io.File;

import javax.swing.JFileChooser;

import Data.DataFile;



//the prefered class over FILe selector 

public class FileChooser {
	
	
	 static String FilePath=null; //set to null and declare value 
	

	

	public static void main(String s[]) {
		JFileChooser chooser = new JFileChooser(); //create the File chooser object 
		chooser.setCurrentDirectory(new java.io.File(".")); 
		chooser.setDialogTitle("Select folder to store data in "); // Tell the user what to do 
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //Choose a directory not a file
		chooser.setAcceptAllFileFilterUsed(false);


		//makes the user select a Directory to open 
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
			System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
			//print out the current file that is selected  // debug to find this info 


			File  filePathF =  chooser.getSelectedFile(); // turn the current file path into a object 
			String filePath =  filePathF.toString(); // convert the file path into a string variable
			System.out.println("file path f is"+filePathF);   //print file path
			System.out.println("file path  is"+filePath);   //print file path in String

			DataFile DF = new DataFile(); // call upon the datafile class 

			DF.setFilePath(filePath); //set the file path to the data file
			
			
			System.out.println("DF FILE PATH IS"+ DataFile.getFilePath()); 
			// get the file path name / direcory
			
			
			FileChooser.getFilePath(); // run this method inside the class Filechooser 
			
			

		} else {
			System.out.println("No Selection "); //When no selection is made no directory 
		}
		

		
	}
	

	 public static String getFilePath() {
		 
		 System.out.println("Filepath at get file path is"+FilePath);
		System.out.println("this"+DataFile.getFilePath());
		 
		String FilePathFinal =  DataFile.getFilePath(); 
		return FilePathFinal; //used to return the current file path 
		
			}
	 
	 
	 public static String GetFile() {
	 JFileChooser chooser = new JFileChooser();	 // get file instead of directory if needed 
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("choosertitle3221");
		//could make the other method more efficient if using a if loop 
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //set to files instead of directory 
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {			
			File  filePathF =  chooser.getSelectedFile();	 // Append file path to the FilePathF 
			String filePath =  filePathF.toString(); // Convert it to a string
			
			System.out.println("file path f is"+filePathF);   //debug to find data 
			System.out.println("file path  is"+filePath);   //debug to find string

			DataFile DF = new DataFile();

			DF.setFilePath(filePath);
			
			
			System.out.println("DF FILE PATH IS"+ DataFile.getFilePath()); 

		} else {
			System.out.println("No Selection "); //When no selection is made no file selected  
		}
		return FilePath; // output the file path 
		
	 }
	
}

  