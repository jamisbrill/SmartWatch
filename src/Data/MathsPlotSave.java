package Data;

import java.io.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtilities;

public class MathsPlotSave {
   
   public static void main( String[ ] args )throws Exception {
	   final String Average = "Average";        
	      final String Maximum = "Maximum";        
	      final String Minimum = "Minimum";                
	      
	      final String Temperature = "Temperature";   
	      final String Motion = "Motion";        
	      final String Pressure = "Pressure";       

      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      
      dataset.addValue( DataFile.getAvgTmp() , Temperature, Average );
      dataset.addValue( DataFile.getMaxTmp() , Temperature , Maximum );        
      dataset.addValue( DataFile.getMinTmp() , Temperature , Minimum);        

        dataset.addValue( DataFile.getAvgMot() , Motion , Average );    
        dataset.addValue( DataFile.getMaxMot() , Motion , Maximum );    
        dataset.addValue( DataFile.getMinMot(), Motion , Minimum );    

        
        
      dataset.addValue(DataFile.getAvgPres(), Pressure , Average );        
      dataset.addValue( DataFile.getMaxPres() , Pressure , Maximum );        
      dataset.addValue(DataFile.getMinPres(), Pressure , Minimum );        

              

      JFreeChart barChart = ChartFactory.createBarChart(
         "Patient Data", 
         "Data type", "Hpa,C,Newtons", 
         dataset,PlotOrientation.VERTICAL, 
         true, true, false);
         
      int width = 640;    /* Width of the image */
      int height = 480;   /* Height of the image */ 
      File BarChart = new File( "BarChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
   }
}