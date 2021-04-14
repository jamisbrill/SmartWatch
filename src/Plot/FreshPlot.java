package Plot;

import Data.DataFile;
import GUI.MainGui;

public class FreshPlot {
	    
		
		
		public static void ThePlotNew() {	
 
			 MainGui.mathsTemperatureList.add(DataFile.getMaxTmp());
			 MainGui.mathsTemperatureList.add(DataFile.getMinTmp());
			 MainGui.mathsTemperatureList.add(DataFile.getAvgTmp());
			 
			 MainGui.mathsPressureList.add(DataFile.getAvgPres());
			 MainGui.mathsPressureList.add(DataFile.getMaxPres());
			 MainGui.mathsPressureList.add(DataFile.getMinPres());
			 
			 MainGui.mathsMotionList.add(DataFile.getAvgMot());
			 MainGui.mathsMotionList.add(DataFile.getMaxMot());
			 MainGui.mathsMotionList.add(DataFile.getMinMot());
			 
	       }
	       
	}

	
	
