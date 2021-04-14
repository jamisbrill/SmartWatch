/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plot;


import java.awt.Dimension;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.RefineryUtilities;


public class SensorPlot extends JFrame{

	private static final long serialVersionUID = 1L;
	//declare variables where the graph will get its data from 
	
	public static   List<Double> Gps;
	   public static  List<Double> HeartBeat;
	  public static   List<Double> Temperature;
	  public static   List<Double> Motion;
	  public static List<Double> Pressure;

	//create some more lists to store the data in
	  //might nott need these variables 
	public ArrayList<Double> GpsList = new ArrayList<Double>();  
	public ArrayList<Double> HeartBeatList = new ArrayList<Double>();  
	public ArrayList<Double> TemperatureList = new ArrayList<Double>(); 
	public  ArrayList<Double> MotionList = new ArrayList<Double>(); 
	public ArrayList<Double> PressureList = new ArrayList<Double>();  


    


//constructor of the line chart 
	public  SensorPlot(String s,List<Double> MotionList,List<Double> Pressure,List<Double> Temp)
	{		
		super(s);		
//
//		GpsList.clear();
//		PressureList.clear();
//		MotionList.clear();
//		PressureList.clear();
//		TemperatureList.clear();
//		HeartBeatList.clear();
		// put the data that has been passed into it into local variables 
		SensorPlot.Temperature = Temp;
		SensorPlot.Motion = MotionList;
		SensorPlot.Pressure = Pressure;
		
		
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel jpanel = createDemoPanel();
		jpanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(jpanel);
	
	
	}

	
	

	private static XYDataset createDataset()
	{

	System.out.println("XY DATA SET IS STARTED ");
		
		
		//create data set here
		XYSeriesCollection xyseriescollection = new XYSeriesCollection();
		XYSeries xyseries = new XYSeries("Motion");
		XYSeries xyseries1 = new XYSeries("Pressure");
		XYSeries xyseries2 = new XYSeries("Temperature");
		int i=1;
		
	//itterate through the data and add it to to the axis of the graph
		
				for(Double temp:Temperature){
			//System.out.println(i+" "+temp);
			xyseries.add(i,temp);
			++i;
		}
		i=1;
		for(Double temp:Pressure){
			//System.out.println(i+" "+temp);
			xyseries1.add(i,temp);
			++i;
		}
		i=1;
		for(Double temp:Motion){
			//System.out.println(i+" "+temp);
			xyseries2.add(i,temp);
			++i;
		}
		
		
		
		//add the data that has just been iterated to the chart 
		xyseriescollection.addSeries(xyseries);   //adds the data to the chart 
		xyseriescollection.addSeries(xyseries1);
		xyseriescollection.addSeries(xyseries2);
		return xyseriescollection;
		
		
	}

	private static JFreeChart createChart(XYDataset xydataset) // create the chart 
	{
		System.out.println("CREATE CHART  IS STARTED ");
//Patient Data", "Patient ID", "Hpa,Newtons,C
		JFreeChart jfreechart = ChartFactory.createXYLineChart("Pressure,Motion and Temperature of Patients", "Patient ID", "Hpa,Newtons,C", xydataset, PlotOrientation.VERTICAL, true, true, false);
		XYPlot xyplot = (XYPlot)jfreechart.getPlot();
		xyplot.setDomainPannable(true);
		xyplot.setRangePannable(true);
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)xyplot.getRenderer();
		xylineandshaperenderer.setBaseShapesVisible(true);
		xylineandshaperenderer.setBaseShapesFilled(true);
		NumberAxis numberaxis = (NumberAxis)xyplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		return jfreechart;
	}

	public static JPanel createDemoPanel()
	{
		System.out.println("CREATE demo Panel  IS STARTED ");

		JFreeChart jfreechart = createChart(createDataset());
		ChartPanel chartpanel = new ChartPanel(jfreechart);
		chartpanel.setMouseWheelEnabled(true);
		return chartpanel;
	}







	
	
	

}