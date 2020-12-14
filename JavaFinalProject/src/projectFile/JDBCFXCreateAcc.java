/*Author: Abudikeranmu Yasen      ID:1672199
 *Author: Amanuel Reda            ID:1659663
 *Date: 12/13/2020
 *Sponser: SMC 2020 Fall CS56 
 *File description: A JDBCFXCreateAcc class that extends a Utilities class for the purpuse of validating,storing to a file, inserting to a database
 */
package projectFile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCFXCreateAcc extends Utilities{
  
    
    // Replace below database url, username and password with your actual database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:1527/projectFile?useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "admin";
    private static final String SELECT_QUERY = "SELECT * FROM Users WHERE userName = ?";
    private static final String SELECT_QUERYC = "Insert into Users(firstName,lastName,email,userName,password) values(?,?,?,?,?)";
    
    //for database validation purpose, a method that validates whether a username exists or not in the database
    public boolean validate(String userName) throws SQLException {

        // Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setString(1, userName);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }


        } catch (SQLException e) {
            // print SQL exception information
            //printSQLException(e);                        
            return validateThroughFile(userName); //validate from file
         
        }
        return false;
    }
    //for database insertion purpose, a method that inserts datas to Users table
    public boolean InsertToDb(String firstName, String lastName, String email, String userName, String password) throws SQLException, IOException {

        //  Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERYC)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, userName);
            preparedStatement.setString(5, password);

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }


        } catch (SQLException e) {
            // print SQL exception information
            //printSQLException(e);
            //using a method from Utilities class
            String data = writeTODataBase( firstName, lastName, email, userName, password);
            return StoreToFile(data); // store JSONArray data to file
        }
        return false;
    }
   // a throwable method for SQLException that prints the details of the exception 
    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }  
}