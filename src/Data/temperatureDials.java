package Data;



import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.*;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

import GUI.MainGui;
import SQL.SQLConnect;

public class temperatureDials extends JFrame
{
	static class DemoPanel extends JPanel
		implements ChangeListener
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JSlider slider;
		DefaultValueDataset dataset;

		public static JFreeChart createStandardDialChart(String s, String s1, ValueDataset valuedataset, double d, double d1, double d2, int i)
		{
			DialPlot dialplot = new DialPlot();
			dialplot.setDataset(valuedataset);
			dialplot.setDialFrame(new StandardDialFrame());
			dialplot.setBackground(new DialBackground());
			DialTextAnnotation dialtextannotation = new DialTextAnnotation(s1);
			dialtextannotation.setFont(new Font("Dialog", 1, 14));
			dialtextannotation.setRadius(0.69999999999999996D);
			dialplot.addLayer(dialtextannotation);
			DialValueIndicator dialvalueindicator = new DialValueIndicator(0);
			dialplot.addLayer(dialvalueindicator);
			StandardDialScale standarddialscale = new StandardDialScale(d, d1, -120D, -300D, 10D, 4);
			standarddialscale.setMajorTickIncrement(d2);
			standarddialscale.setMinorTickCount(i);
			standarddialscale.setTickRadius(0.88D);
			standarddialscale.setTickLabelOffset(0.14999999999999999D);
			standarddialscale.setTickLabelFont(new Font("Dialog", 0, 14));
			dialplot.addScale(0, standarddialscale);
			dialplot.addPointer(new org.jfree.chart.plot.dial.DialPointer.Pin());
			DialCap dialcap = new DialCap();
			dialplot.setCap(dialcap);
			return new JFreeChart(s, dialplot);
		}

		public void stateChanged(ChangeEvent changeevent)
		{
			dataset.setValue(new Integer(slider.getValue()));
		}

		public DemoPanel()
		{
			super(new BorderLayout());
			
			
			
			//MainGui.TemperatureList();
			System.out.println(SQLConnect.getTemperature().toString());	
			//		int i=(int)SQLConnect.getTemperature(); 
			

			dataset = new DefaultValueDataset(20); // data set 
			
			
			
			//dataset = new DefaultValueDataset(30D); // data set 

			JFreeChart jfreechart2 = createStandardDialChart("Patient temperature", "Temperature", dataset, -40D, 60D, 10D, 4);

			JFreeChart jfreechart = createStandardDialChart("Dial Demo 1", "Temperature", dataset, -40D, 60D, 10D, 4);
			DialPlot dialplot = (DialPlot)jfreechart.getPlot();
			StandardDialRange standarddialrange = new StandardDialRange(40D, 60D, Color.red);
			standarddialrange.setInnerRadius(0.52000000000000002D);
			standarddialrange.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrange);
			StandardDialRange standarddialrange1 = new StandardDialRange(10D, 40D, Color.orange);
			standarddialrange1.setInnerRadius(0.52000000000000002D);
			standarddialrange1.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrange1);
			StandardDialRange standarddialrange2 = new StandardDialRange(-40D, 10D, Color.green);
			standarddialrange2.setInnerRadius(0.52000000000000002D);
			standarddialrange2.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrange2);
			GradientPaint gradientpaint = new GradientPaint(new Point(), new Color(255, 255, 255), new Point(), new Color(170, 170, 220));
			DialBackground dialbackground = new DialBackground(gradientpaint);
			dialbackground.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
			dialplot.setBackground(dialbackground);
			dialplot.removePointer(0);
			org.jfree.chart.plot.dial.DialPointer.Pointer pointer = new org.jfree.chart.plot.dial.DialPointer.Pointer();
			pointer.setFillPaint(Color.yellow);
			dialplot.addPointer(pointer);
			ChartPanel chartpanel = new ChartPanel(jfreechart);
		//	ChartPanel chartpanel2 = new ChartPanel(jfreechart2);

			chartpanel.setPreferredSize(new Dimension(400, 400));
	
			add(chartpanel);
		//	add(chartpanel2);

		}
	}


	public temperatureDials(String s)
	{
		super(s);
		setDefaultCloseOperation(3);
		setContentPane(createDemoPanel());
	}

	public static JPanel createDemoPanel()
	{
		return new DemoPanel();
	}

	public static void main(String args[])
	{
		temperatureDials dialdemo1 = new temperatureDials("JFreeChart");
		dialdemo1.pack();
		dialdemo1.setVisible(true);
	}
}