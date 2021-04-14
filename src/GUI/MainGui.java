package GUI;

import Plot.SensorPlot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.ui.RefineryUtilities;

import Data.BarChartMaths;
import Data.CsvReadData3;
import Data.DataFile;
import Data.DataManipulation;
import Data.DataSaver;
import Data.EmergencyTrigger;
import Plot.FreshPlot;
import Data.JsonFileCreator;
import Data.temperatureDials;
import Plot.MathsPlot;
import SQL.SQLConnect;
import SQL.SQLConnectAzure;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainGui extends JFrame {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8668510254750595996L; //idk what this is but java wanted it
	
	
	public static List<Double> TemperatureList = new ArrayList<Double>(); 
	public static List<Double> PressureList = new ArrayList<Double>(); 
	public static List<Double> MotionList = new ArrayList<Double>(); 
//	public static ArrayList<Double> TemperatureList = new ArrayList<Double>();  //extra lists for other variables if needed 

	
	//these array list are for the csv graph .... 
	public static ArrayList<Double> CsvTemperatureList = new ArrayList<Double>();  // create the array lists where the data will be stored 
	public static ArrayList<Double> CsvPressureList = new ArrayList<Double>();  
	public static ArrayList<Double> CsvMotionList = new ArrayList<Double>(); 
	
	//More variables. for the calculation graph 
	public static   ArrayList<Double> MaxTmp = new ArrayList<Double>();
	  public static  ArrayList<Double> MinTmp= new ArrayList<Double>();
	  public static   ArrayList<Double> AvgTmp= new ArrayList<Double>();
	  public static   ArrayList<Double> MaxMot= new ArrayList<Double>();
	  public static ArrayList<Double>   MinMot= new ArrayList<Double>();
	  public static   ArrayList<Double> AvgMot= new ArrayList<Double>();
	  public static   ArrayList<Double> MaxPres= new ArrayList<Double>();
	  public static   ArrayList<Double> MinPres= new ArrayList<Double>();
	  public static   ArrayList<Double> AvgPres= new ArrayList<Double>();

	  public static   ArrayList<Double> mathsPressureList= new ArrayList<Double>();
	  public static   ArrayList<Double> mathsTemperatureList= new ArrayList<Double>();
	  public static   ArrayList<Double> mathsMotionList= new ArrayList<Double>();
	
	

	private JPanel contentPane;
	private JTextField txtConnectionm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 957, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		txtConnectionm = new JTextField();
		txtConnectionm.setEditable(false);
		txtConnectionm.setText("Connection : ");
		txtConnectionm.setBounds(10, 72, 86, 23);
		contentPane.add(txtConnectionm);
		txtConnectionm.setColumns(10);
		
		JLabel lblConnectionYESNO = new JLabel("0");
		lblConnectionYESNO.setBounds(90, 72, 25, 23);
		contentPane.add(lblConnectionYESNO);
		
		JButton btnNewButton_1 = new JButton("Save Data locally");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DataSaver.FileCreator(); // call the file creation function 
				
			}
		});
		btnNewButton_1.setBounds(388, 11, 126, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		JTextArea SqlOutput = new JTextArea();
		SqlOutput.setEditable(false);
		SqlOutput.setBounds(26, 106, 579, 155);
		contentPane.add(SqlOutput);
		
		
		
		JButton btnNewButton = new JButton("Plot Data"); 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				SQLConnect.allvalues(); // run the key function in SQL Connect which connect to the DB + Puts the data in a list

				  TemperatureList = 	SQLConnect.getTemperature();    // use the get methods to put the data into the lists (The main method needs to be run first) 
				  PressureList = 	SQLConnect.getPressure();
				  MotionList = 	SQLConnect.getMotion();

				  
				System.out.println("templist is"+TemperatureList);
				
		
				SensorPlot chart = new SensorPlot("All Data Plot...",TemperatureList,PressureList,MotionList); // call the chart graph 	 and assign the parameterers of each lists 
					System.out.println("Temp List is :"+TemperatureList);
					System.out.println("PressureList is :"+PressureList);
					System.out.println("MotionList is :"+MotionList);
				// Debugging to check what data has been put into the lists . 
				
				
				
				chart.pack();
	       		RefineryUtilities.centerFrameOnScreen(chart);
	                		chart.setVisible(true);  // show the chart 
					
				System.out.println("LAUNCHING  GRAPH"); // debug stuff 
				
				
				btnNewButton_1.setEnabled(true);//enable the button after sql has been connected to 
				
			}
		});
		btnNewButton.setBounds(140, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		JButton btnCSV = new JButton("Csv File Load");
		btnCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			CsvReadData3.CsvBuffered(); // call the csvbuffered function in the csvreadata3 class 
				
				CsvReadData3.getCsvTemperaturelist(); 
				
			//pass the data from the csv file reader to the test gui 	
				
				CsvTemperatureList = CsvReadData3.getCsvTemperaturelist(); //transfer data from the read data method to the lists
				CsvPressureList = CsvReadData3.getCsvPressurelist();
				CsvMotionList = CsvReadData3.getCsvMotionlist();
				
			//	SqlOutput.setText(CsvTemperatureList.toString()+CsvPressureList.toString()+CsvMotionList.toString());
				SqlOutput.append("Temp"+CsvTemperatureList.toString()+System.getProperty("line.separator"));
				SqlOutput.append("Pressure"+CsvPressureList.toString()+System.getProperty("line.separator"));
				SqlOutput.append("Motoion"+CsvMotionList.toString());
				
				
				SensorPlot chart = new SensorPlot("All Data Plot...",CsvTemperatureList,CsvPressureList,CsvMotionList); // call the chart graph 	 and assign the parameterers of each lists 
	      		chart.pack();
	       		RefineryUtilities.centerFrameOnScreen(chart);
	                		chart.setVisible(true);  // show the chart 
					
				System.out.println("LAUNCHING CSV GRAPH");
					
				btnNewButton_1.setEnabled(true);
				
				
				
				
				 
				
				
				
				
				
				
			}
		});
		btnCSV.setBounds(258, 11, 104, 23);
		contentPane.add(btnCSV);
		
		JLabel AvgLbltmp = new JLabel("-");
		AvgLbltmp.setBounds(850, 139, 46, 14);
		contentPane.add(AvgLbltmp);
		
		JLabel maxLbltmp = new JLabel("-");
		maxLbltmp.setBounds(850, 164, 46, 14);
		contentPane.add(maxLbltmp);
		
		JLabel minLbltmp = new JLabel("-");
		minLbltmp.setBounds(850, 183, 46, 14);
		contentPane.add(minLbltmp);
		
		
		//Default dont change 
		JLabel lblTemperature = new JLabel("Temperature ");
		lblTemperature.setBounds(823, 111, 86, 14);
		contentPane.add(lblTemperature);
		
		JLabel lblMotion = new JLabel("Motion");
		lblMotion.setBounds(692, 111, 63, 14);
		contentPane.add(lblMotion);
		
		JLabel lblPrerssure = new JLabel("Pressure");
		lblPrerssure.setBounds(765, 111, 64, 14);
		contentPane.add(lblPrerssure);
		 
		JLabel minLblPres = new JLabel("-");
		minLblPres.setBounds(765, 183, 46, 14);
		contentPane.add(minLblPres);
		
		JLabel maxLblPres = new JLabel("-");
		maxLblPres.setBounds(765, 164, 46, 14);
		contentPane.add(maxLblPres);
		
		JLabel AvgLblPres = new JLabel("-");
		AvgLblPres.setBounds(765, 139, 46, 14);
		contentPane.add(AvgLblPres);
		
		JLabel maxLblMot = new JLabel("-");
		maxLblMot.setBounds(693, 164, 46, 14);
		contentPane.add(maxLblMot);
		
		JLabel minLbMot = new JLabel("-");
		minLbMot.setBounds(693, 183, 46, 14);
		contentPane.add(minLbMot);
		
		JLabel AvgLblmot = new JLabel("-");
		AvgLblmot.setBounds(693, 139, 46, 14);
		contentPane.add(AvgLblmot);
		
		JLabel lblNewLabel = new JLabel("Average");
		lblNewLabel.setBounds(615, 139, 68, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Max ");
		lblNewLabel_1.setBounds(615, 164, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Min");
		lblNewLabel_2.setBounds(615, 183, 68, 14);
		contentPane.add(lblNewLabel_2);
		
	
		
		JButton btnCalculationGraph = new JButton("Calculation Graph");
		btnCalculationGraph.setEnabled(false);
		btnCalculationGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//double temp = 
			//	MaxTmp.add(Double.parseDouble(AvgLblPres.getText())); 
				
		//		try {
		//		Double AvgLblPresD=Double.parseDouble(AvgLblPres.getText());  
		//		Double AvgPressure = AvgLblPresD;
		//		MaxTmp.add(AvgLblPresD);
		//		System.out.println("PresyreD is"+AvgPressure);
		//		System.out.println(AvgLblPresD);
		//		MaxTmp.addAll(AvgLblPresD);
				//System.out.println(MaxTmp.size());
			//	MaxTmp.add(AvgPressure) ;
				
			//	System.out.println(MaxTmp);

			//	MaxTmp.set(0, AvgLblPresD); //sets tthe first indexs of max tmp to the number of avglblpress
				
			//	System.out.println("MaxTmp is"+MaxTmp);
				
				
				/*
				Reuse this later 
				MaxTmp = SQLConnect.getTemperature();
				MinTmp = 	SQLConnect.getPressure();
				AvgTmp = 	SQLConnect.getMotion();
				*/
				System.out.println(DataFile.getMaxTmp());
				System.out.println( SQLConnect.getTemperature());
				
		
				FreshPlot.ThePlotNew();
				System.out.println("Big Stringo Dino"+mathsTemperatureList+"yup"+ mathsMotionList);
				
				
				MathsPlot chart = new MathsPlot("All Data Plot...",mathsTemperatureList,mathsPressureList,mathsMotionList); // call the chart graph 	 and assign the parameterers of each lists 

				chart.pack();
	       		RefineryUtilities.centerFrameOnScreen(chart);
	                		chart.setVisible(true);  // show the chart 
				
	                		
	            BarChartMaths.main(null);    		
				
				
				
	//		}	catch (Exception e2) {System.out.println("It broke"); System.out.println(e2);} 
				
			
			
			}
		});
		btnCalculationGraph.setBounds(721, 72, 136, 23);
		contentPane.add(btnCalculationGraph);
		
		
		
		JButton btnButtondataManipulation = new JButton("Calculations");
		 btnCalculationGraph.setEnabled(false);
			btnButtondataManipulation.setEnabled(false); //enable the button after sql has been connected to 

		btnButtondataManipulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
				
				
				 List<Double> list; // create list
				 list = SQLConnect.getTemperature(); //set list to temp list 
				 String Max = String.valueOf(DataManipulation.Max(list));
				 maxLbltmp.setText(Max);
				 DataFile.setMaxTmp(DataManipulation.Max(list)); //set the data into the datfile // for use with other methods
				 //min 		
				String Min = String.valueOf(DataManipulation.Min(list));
				minLbltmp.setText(Min);
				 DataFile.setMinTmp(DataManipulation.Min(list)); //set the data into the datafile // for use with other methods


				// average .... 
				String Avg = String.valueOf(DataManipulation.Avg(list));
				AvgLbltmp.setText(Avg);
				 DataFile.setAvgTmp(DataManipulation.Avg(list)); //set the data into the datafile // for use with other methods

				
				
				
				
				list = SQLConnect.getMotion(); //change list to motion
				Max = String.valueOf(DataManipulation.Max(list));
				maxLblMot.setText(Max);
				 DataFile.setMaxMot(DataManipulation.Max(list)); //set the data into the datafile // for use with other methods
				//min
				Min = String.valueOf(DataManipulation.Min(list));
				minLbMot.setText(Min);
				 DataFile.setMinMot(DataManipulation.Min(list)); //set the data into the datafile // for use with other methods
				 //avg
				 Avg = String.valueOf(DataManipulation.Avg(list));
				 AvgLblmot.setText(Avg);
				 DataFile.setAvgMot(DataManipulation.Avg(list)); //set the data into the datfile // for use with other methods


				list = SQLConnect.getPressure(); // change list to pressure 
				Max = String.valueOf(DataManipulation.Max(list));
				maxLblPres.setText(Max);
				 DataFile.setMaxPres(DataManipulation.Max(list)); //set the data into the datfile // for use with other methods

				Min = String.valueOf(DataManipulation.Min(list));
				minLblPres.setText(Min);
				 DataFile.setMinPres(DataManipulation.Min(list)); //set the data into the datfile // for use with other methods

				 Avg = String.valueOf(DataManipulation.Avg(list));
				 AvgLblPres.setText(Avg);
				 DataFile.setAvgPres(DataManipulation.Avg(list)); //set the data into the datfile // for use with other methods

				
				 
				 btnCalculationGraph.setEnabled(true);
				}
				catch (Exception e1)
				{
					System.out.println("you probs ran this b4 connecting to db");
					
				}
				
				
				
			}
		});
		btnButtondataManipulation.setBounds(740, 40, 89, 23);
		contentPane.add(btnButtondataManipulation);
		
		
		JButton btnjson = new JButton("Save Data (Json)");
		btnjson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JsonFileCreator.main(null);
			}
		});
		btnjson.setEnabled(false);
		btnjson.setBounds(388, 45, 126, 23);
		contentPane.add(btnjson);
		
		JButton btnConnect2 = new JButton("Connect 2");
		btnConnect2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				SqlOutput.setText(SQLConnect.allvalues()); // call the main function in the class (which connects to the db) 
				System.out.println("GPS IS"+SQLConnect.GPS); // probably wont be plotting the gps  // debugging to check where data is 
				btnNewButton_1.setEnabled(true); //enable the button after sql has been connected to 
			//	btnCalculationGraph.setEnabled(true);
				btnButtondataManipulation.setEnabled(true); //enable the button after sql has been connected to 
				btnjson.setEnabled(true);
				
		
			}
		});
		btnConnect2.setBounds(10, 11, 89, 23);
		contentPane.add(btnConnect2);
		
		JButton btnAzure = new JButton("Connect to Azure DB ");
		btnAzure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//SQLConnectAzure.allvalues();
				SqlOutput.setText(SQLConnectAzure.allvalues()); 
				btnNewButton_1.setEnabled(true); //enable the button after sql has been connected to 
				btnButtondataManipulation.setEnabled(true); //enable the button after sql has been connected to 
				
				
			}
		});
		btnAzure.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAzure.setBounds(538, 11, 145, 23);
		contentPane.add(btnAzure);
		
		JButton btnCheck = new JButton("Check Notifications");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				EmergencyTrigger.teperature();
				EmergencyTrigger.Motion();
			}
		});
		btnCheck.setBounds(10, 38, 126, 23);
		contentPane.add(btnCheck);
		
		JButton btnNewButton_2 = new JButton("Dials");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temperatureDials.main(null);
			}
		});
		btnNewButton_2.setBounds(150, 45, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
	}
}
