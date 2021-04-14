package Data;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

import SQL.SQLConnect;
public class JsonFileCreator {
   @SuppressWarnings("unchecked") // i dont like warnings so here it suppresses warnings 
public static void main(String args[]) {
      //Creating a JSONObject object
      JSONObject jsonObject = new JSONObject();
      //Inserting key-value pairs into the json object
      jsonObject.put("ID", SQLConnect.getID());
   //   jsonObject.
      jsonObject.put("Temperature",SQLConnect.getTemperature());
      jsonObject.put("Pressure", SQLConnect.getPressure().toString());
      jsonObject.put("Motion", SQLConnect.getMotion().toString());
      try {
         FileWriter file = new FileWriter("PatientData.json");
         file.write(jsonObject.toJSONString());
         file.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("JSON file created: "+jsonObject);
   }
}