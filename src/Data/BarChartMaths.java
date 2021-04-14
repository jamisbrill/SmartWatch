package Data;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 

public class BarChartMaths extends ApplicationFrame {
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   private final JButton Save = new JButton("Save");

public BarChartMaths( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Data Type",            
         "Hpa,C,Newtons",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel );
      GridBagLayout gbl_chartPanel = new GridBagLayout();
      gbl_chartPanel.columnWidths = new int[]{69, 0};
      gbl_chartPanel.rowHeights = new int[]{230, 31, 0, 0, 0, 0, 0};
      gbl_chartPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
      gbl_chartPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      chartPanel.setLayout(gbl_chartPanel);
      GridBagConstraints gbc_Save = new GridBagConstraints();
      gbc_Save.anchor = GridBagConstraints.NORTH;
      gbc_Save.insets = new Insets(0, 0, 5, 0);
      gbc_Save.fill = GridBagConstraints.HORIZONTAL;
      gbc_Save.gridx = 0;
      gbc_Save.gridy = 0;
      Save.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		
      		
      		try {
				MathsPlotSave.main(null);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
      		
      	}
      });
      chartPanel.add(Save, gbc_Save);
   }
   
   private CategoryDataset createDataset( ) {
      final String Average = "Average";        
      final String Maximum = "Maximum";        
      final String Minimum = "Minimum";                
      
      final String Temperature = "Temperature";   
      final String Motion = "Motion";        
      final String Pressure = "Pressure";        
        
      
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      
      
      
      dataset.addValue( DataFile.getAvgTmp() , Temperature, Average );
      dataset.addValue( DataFile.getMaxTmp() , Temperature , Maximum );        
      dataset.addValue( DataFile.getMinTmp() , Temperature , Minimum);        

        dataset.addValue( DataFile.getAvgMot() , Motion , Average );    
        dataset.addValue( DataFile.getMaxMot() , Motion , Maximum );    
        dataset.addValue( DataFile.getMinMot(), Motion , Minimum );    

        
        
      dataset.addValue(DataFile.getAvgPres(), Pressure , Average );        
      dataset.addValue( DataFile.getMaxPres() , Pressure , Maximum );        
      dataset.addValue(DataFile.getMinPres(), Pressure , Minimum );        

              

      return dataset; 
   }
   
   public static void main( String[ ] args ) {
      BarChartMaths chart = new BarChartMaths("Patient Data", 
         "Patient Data");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}