package projectFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author gebre
 */
public class Utilities {
    public static String fileName = "userFileDatabase.txt";
    
     public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
    public static String writeTODataBase(String firstName,String lasttName,String email,String userName,String password) throws IOException{
    //if user info is valid store to db  
    
    //read from the file and 
      
    JSONObject input = new JSONObject();
    String jsonText = null;
    input.put("frisrName",firstName);
    input.put("LastName",lasttName); 
    input.put("email",email);    
    input.put("userName",userName);
    input.put("password",password);    

    JSONArray JsonArray = new JSONArray();
    JsonArray.add(input);    
try{
      StringWriter out = new StringWriter();
      JsonArray.writeJSONString(out);
      jsonText = out.toString();
      System.out.print(jsonText);


    }catch(IOException e){
          System.out.println(e);
      }
      return jsonText;
}


public static String ReadFromFile(String fileName) {

        try {
            File buffer = new File(fileName);
            Scanner myReader = new Scanner(buffer);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                System.out.println("new Line:");
                return data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
         return null;
    }



public static boolean StoreToFile(String Data){
        try {
            File userFile = new File("userFileDatabase.txt");
            
            FileWriter writer = new FileWriter(userFile);
                writer.write(Data);
                writer.flush();
                writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


public static JSONArray ParseUserData(String data){
    JSONParser parser = new JSONParser();
    JSONArray array = null;
    try{
         Object obj = parser.parse(data);
         array = (JSONArray)obj;
			
         
      }catch(ParseException pe) {
		
         System.out.println("position: " + pe.getPosition());
         System.out.println(pe);
      }
    
    return array;
}

public static boolean validateThroughFile(String userName,String password){
    
     String file = ReadFromFile(fileName);
      JSONArray Jarray = ParseUserData(file);
      int size = Jarray.size();
      //validating username
      while(size>0){
      JSONObject Jobject = (JSONObject) Jarray.get(size-1);
      String name = (String) Jobject.get("userName");
      String pass = (String) Jobject.get("password");
      if(userName.equals(name) && password.equals(pass)){
          return true;
      }
      size--;
      }
 
      return false;
    }



public static boolean validateThroughFile(String userName){

      String file = ReadFromFile(fileName);
      //check if file is empty. if it is empty return false or true
      if(file == null)
          return true;
      JSONArray Jarray = ParseUserData(file);
      int size = Jarray.size();
      while(size>0){
      JSONObject Jobject = (JSONObject) Jarray.get(size-1);
      String name = (String) Jobject.get("userName");
      if(userName.equals(name)){
          return false;
      }
      size--;
      }
      return true;
    }

    
}



