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


public class MathsPlot extends JFrame{

	private static final long serialVersionUID = 1L;
	//declare variables where the graph will get its data from 
	
	public static   List<Double> MaxTmp;
	   public static  List<Double> MinTmp;
	  public static   List<Double> AvgTmp;
	  public static   List<Double> MaxMot;
	  public static List<Double>   MinMot;
	  public static   List<Double> AvgMot;
	  public static   List<Double> MaxPres;
	  public static   List<Double> MinPres;
	  public static   List<Double> AvgPres;

	  public static List<Double> AllTmp;
	  public static List<Double> AllPres;
	  public static List<Double> AllMot;

	  
	  
//constructor of the line chart 
	public  MathsPlot(String s,List<Double> MaxTmp,List<Double> MinTmp,List<Double> AvgTmp)//,List<Double> MaxMot)
	{		
		super(s);		

		// put the data that has been passed into it into local variables 
		MathsPlot.MaxTmp = MaxTmp;
		MathsPlot.MinTmp = MinTmp;
		MathsPlot.AvgTmp = AvgTmp;
		
					
			
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
		int i=0;
		
	//itterate through the data and add it to to the axis of the graph
		
				for(Double temp:MaxTmp){
			//System.out.println(i+" "+temp);
			xyseries.add(i,temp);
			++i;
		}
		i=1;
		for(Double temp:MinTmp){
			//System.out.println(i+" "+temp);
			xyseries1.add(i,temp);
			++i;
		}
		i=2;
		for(Double temp:AvgTmp){
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

		JFreeChart jfreechart = ChartFactory.createXYLineChart("Patient Data", "Patient ID", "Hpa,Newtons,C", xydataset, PlotOrientation.VERTICAL, true, true, false);
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