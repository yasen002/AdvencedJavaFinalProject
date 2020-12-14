/*Author: Abudikeranmu Yasen      ID:1672199
 *Author: Amanuel Reda            ID:1659663
 *Date: 12/13/2020
 *Sponser: SMC 2020 Fall CS56 
 *File description: A class that holds methods which are useful for validation and storing
 */
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

public class Utilities {
    public static String fileName = "userFileDatabase.txt";  //file name

    //an alert window that shows success or failure 
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
    
    // a method that stores all the datas as a JSONArray to file database
    public static String writeTODataBase(String firstName,String lasttName,String email,String userName,String password) throws IOException{
      
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

    }catch(IOException e){
          System.out.println(e);
      }
      return jsonText;
}

//read from file method, that reads each line from a file a return the line as a string
public static String ReadFromFile(String fileName) {

        try {
            File buffer = new File(fileName);
            Scanner myReader = new Scanner(buffer);
            while (myReader.hasNextLine()) {

                return myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
         return null;
    }

// a method that writes to a file 
//String data - JSON string containing user info
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

//a JSONArray method that parses users data from file 
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
//Validate a login data method, uses JSON (username, password)
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


//Validate whether a username exists or not when a person wants to create an account, return true or false
//JSON
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
      //check if username exists, if so, return false (which means the person can not create account with an existing username
      if(userName.equals(name)){
          return false;
      }
      size--;
      }
      return true;
    }




    
}




