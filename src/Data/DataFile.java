package Data;

import Data.DataFile;

public class DataFile {


		
		private static double Temperature;
		public static String FilePath;
		
		
		private static String sql;
		public static String BigTextField;
		
		private static Double[] CSVTotalPull;
		private static double[] CSVHeartBeat;
		private static double[] CSVTemperature;
		
		
		//new
		private static Double avgTmp;
		private static Double avgPres;
		private static Double avgMot;
		private static Double MaxTmp;
		private static Double MaxPres;
		private static Double MaxMot;
		private static Double MinTmp;
		private static Double MinPres;
		private static Double MinMot;

		
		


		//Getters and Setters used for getting data and assigning the data
	
		
	
		//Auto generated getters + Setters very useful :) 
		public static Double getAvgTmp() {
			return avgTmp;
		}
		public static void setAvgTmp(Double avgTmp) {
			DataFile.avgTmp = avgTmp;
		}
		public static Double getAvgPres() {
			return avgPres;
		}
		public static void setAvgPres(Double avgPres) {
			DataFile.avgPres = avgPres;
		}
		public static Double getAvgMot() {
			return avgMot;
		}
		public static void setAvgMot(Double avgMot) {
			DataFile.avgMot = avgMot;
		}
		public static Double getMaxTmp() {
			return MaxTmp;
		}
		public static void setMaxTmp(Double maxTmp) {
			MaxTmp = maxTmp;
		}
		public static Double getMaxPres() {
			return MaxPres;
		}
		public static void setMaxPres(Double maxPres) {
			MaxPres = maxPres;
		}
		public static Double getMaxMot() {
			return MaxMot;
		}
		public static void setMaxMot(Double maxMot) {
			MaxMot = maxMot;
		}
		public static Double getMinTmp() {
			return MinTmp;
		}
		public static void setMinTmp(Double minTmp) {
			MinTmp = minTmp;
		}
		public static Double getMinPres() {
			return MinPres;
		}
		public static void setMinPres(Double minPres) {
			MinPres = minPres;
		}
		public static Double getMinMot() {
			return MinMot;
		}
		public static void setMinMot(Double minMot) {
			MinMot = minMot;
		}
	
		
		public static double getTemperature() {// getting Temperature and using public so it can be accessed from else where.
			return Temperature; //returning Temperature
		}
		public static void setTemperature(double Temperature) {//method used to setTemperature
			DataFile.Temperature = Temperature;// "this" is a reference to Temperature
		}

		public static String getFilePath() {
			System.out.println("here get file path is accessed");
			
			return FilePath;
		}
		
		public void setFilePath(String FilePath) {//method used to set HeartBeat
			DataFile.FilePath = FilePath; // "this" is a reference to HeartBeat
		}
		
	
		

		
		public static String getSql() {// getting Light and using public so it can be accessed from else where.
						
			return sql;//returning Light
			
	}	
		public static void  setSql(String sql) {//method used to set Light
			
			DataFile.sql = sql;
			
		}
		
		
		public static String getBigTextField() {// getting Light and using public so it can be accessed from else where.
			
			
			return BigTextField;//returning Light
			
	}	
		
		
		public static void  setBigTextField(String BigTextField) {//method used to set Light

			DataFile.BigTextField = BigTextField;
			
		}
		
		
		
		public static Double[] getCSVTotalPull()
		{
			
			return CSVTotalPull;
			
		}
		public static void  setCSVTotalPull(Double[] totalPull2) {//method used to set Light

			DataFile.CSVTotalPull = totalPull2;
			
		}
		
		
		public static double[] getCSVHeartBeat()
		{
			
			return CSVHeartBeat;
			
		}
		public static void  setCSVHeartBeat(double[] CSVHeartBeat) {//method used to set Light

			DataFile.CSVHeartBeat = CSVHeartBeat;
			
		}
		
		
		public static double[] getCSVTemperature()
		{
			
			return CSVTemperature;
			
		}
		public static void  setCSVTemperature(double[] CSVTemperature) {//method used to set 

			DataFile.CSVTemperature = CSVTemperature;
			
		}
		
		
		
		

		public String toString(){// method created called toString
			return " Data [TotalPull="  + ", HeartBeat="  + ", Temperature=" // Overriding as it returns the values
					+ Temperature + "]";
		}
		
	}
